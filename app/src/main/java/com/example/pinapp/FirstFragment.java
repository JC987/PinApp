package com.example.pinapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.ArrayList;

public class FirstFragment extends Fragment {
    ListView listView;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        final View root =  inflater.inflate(R.layout.fragment_first, container, false);
        listView = root.findViewById(R.id.listView);
        Button firstButton = root.findViewById(R.id.button_first);
       

        ArrayAdapter a = new ArrayAdapter<String>(root.getContext(), R.layout.support_simple_spinner_dropdown_item, PinList.getList());
        listView.setAdapter(a);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(root.getContext(),"hello " + listView.getItemAtPosition(i).toString(),Toast.LENGTH_LONG).show();

                Bundle bnd = new Bundle();
                bnd.putString("string_key",listView.getItemAtPosition(i).toString() + " was pressed!");
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment,bnd);

                Intent intent = new Intent(root.getContext(), MapsActivity.class);

                startActivity(intent);

            }
        });

        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        // Inflate the layout for this fragment
        return root;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }
}
