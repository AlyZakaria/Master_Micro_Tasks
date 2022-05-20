package com.company;

import java.util.ArrayList;

public class Singleton_DB {
    public ArrayList<Topology> topologyArrayList = new ArrayList<>();
    private static Singleton_DB unique;

    private Singleton_DB(){}
    public static Singleton_DB getInstance(){
        if(unique == null)
            unique = new Singleton_DB();
        return unique;
    }

    public Topology search_Topology(String id){
        for(Topology t : topologyArrayList){
            if(t.getId().equals(id)){
                return t;
            }
        }
        return null;
    }


}
