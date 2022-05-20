package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
    try {
        Singleton_DB singleton_db = Singleton_DB.getInstance();
        TopologyFunctions.readJson("E:\\Projects\\Master_Micro_Tasks\\Task_2\\src\\Topology.json");
        //TopologyFunctions.writeJson("top1","E:\\Projects\\Master_Micro_Tasks\\Task_2\\src\\writetest.json");
        //TopologyFunctions.deleteTopology("top1");

        HashMap<String, String> netlist = new HashMap<>();
        netlist.put("t1", "vdd");
        netlist.put("t2", "n1");
        netlist.put("t3", "n2");
        ArrayList<component> comp = TopologyFunctions.queryDevicesWithNetlistNode("top1" , netlist);
        /*
         find the devices with netlist:{
         "t1" : "vdd",
         "t2" :"n1",
         "t3" : "n2"
         }
        */
        for(component component : comp)
            System.out.println(component.getId());
        // The Array of the devices will be null as there is not netlist in any component with these values..
    }catch (Exception e){
    }





    }
}
