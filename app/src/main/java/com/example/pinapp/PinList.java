package com.example.pinapp;

import java.util.ArrayList;

public class PinList {
    static ArrayList<String> list = new ArrayList<>();
    public PinList(){

    }
    static public void addList(String s){
        list.add(s);
    }
    static public ArrayList<String> getList(){
        return list;
    }
}
