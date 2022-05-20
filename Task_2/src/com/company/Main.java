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




//    range Range = new range("resistor", 100 , 10 , 800);
//    HashMap<String,String> hashMap = new HashMap<>();
//    hashMap.put("t1" , "test");
//    hashMap.put("t2" , "test2");
//    component co = new component("resistor" , "res1" , hashMap, Range);
//    arr.add(co);
//    Topology topology = new Topology("Top2", arr);
//    //TopologyFunctions.write(topology,"E:\\Projects\\Master_Micro_Tasks\\Task_2\\src\\writetest.json");
    }
}
