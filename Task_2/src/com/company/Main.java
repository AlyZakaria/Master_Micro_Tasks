package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
    try {
        Singleton_DB singleton_db = Singleton_DB.getInstance();
         //TopologyFunctions.readJson("E:\\Projects\\Master_Micro_Tasks\\Task_2\\src\\Topology.json");
         // TopologyFunctions.writeJson("top1","E:\\Projects\\Master_Micro_Tasks\\Task_2\\src\\writetest.json");
         //TopologyFunctions.deleteTopology("top1");

        ArrayList<component> res = TopologyFunctions.queryDevices("top1");
        for (component c : res)
            System.out.println(c.getId());

    }catch (Exception e){
    }





    }
}
