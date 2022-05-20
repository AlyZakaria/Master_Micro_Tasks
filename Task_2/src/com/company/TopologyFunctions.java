package com.company;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class TopologyFunctions {

    static Topology readJson(String jsonpath ) throws IOException  {

        String json = Files.readString(Path.of(jsonpath));
        Map<String,Object> topology = new Gson().fromJson(json,Map.class);
        String id = (String) topology.get("id");

        var devicesList = new Gson().fromJson(topology.get("components").toString() , ArrayList.class);
        ArrayList<component> devices = new ArrayList<>();

        for(var i : devicesList)
            devices.add(get_the_component(i.toString()));

        Topology t = new Topology(id,devices);
        DataBase_Memory.topologyArrayList.add(t);

    return t;
    }
    private static void write(Topology topology , String filepath) throws IOException {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id",topology.getId());
        hashMap.put("components",topology.getDevices());
        String json = new ObjectMapper().writeValueAsString(hashMap);
        File file = new File(filepath);

        FileWriter writer = new FileWriter(filepath);
        writer.write(json);
        writer.close();
    }
    static void writeJson(String topologyId , String filepath) throws IOException {
        for (Topology t : DataBase_Memory.topologyArrayList){
            if (t.getId().equals(topologyId)) {
                write(t, filepath);
                return;
            }
        }
        System.out.println("There is no id with this topology");

    }

    private static component get_the_component(String i) {
        String type = "";
        String id = "";
        range Range = null;
        HashMap<String , String> netlist = null;
        Map<String,Object> device = new Gson().fromJson(i,Map.class);

        for(Map.Entry<String, Object> entry : device.entrySet()){
            if(entry.getKey().equals("type"))
                type = (String) entry.getValue();
            else if(entry.getKey().equals("id"))
                id = (String) entry.getValue();
            else if(entry.getKey().equals("netlist"))
                netlist = get_the_netlist(entry.getValue().toString());
            else
                Range = get_the_component_range(entry.getKey() , entry.getValue().toString());
        }
     return new component(type, id , netlist , Range);
    }

    private static HashMap<String, String> get_the_netlist(String toString) {
        HashMap<String, String> newhash = new HashMap<String, String>();
        Map<String, Object> map = new Gson().fromJson(toString, Map.class);

        for (Map.Entry<String, Object> i : map.entrySet())
            newhash.put(i.getKey(), (String) i.getValue());
    return newhash;
    }

    private static range get_the_component_range(String key, String value) {
        Map<String, Double> Range =  new Gson().fromJson(value, Map.class);

    return new range(key, Range.get("default"), Range.get("max"), Range.get("min"));
    }


    public static ArrayList<Topology> queryTopologies(){
        return DataBase_Memory.topologyArrayList;
    }
    public static void deleteTopology(String TopologyID){
        Topology tempTopology = search_Topology(TopologyID);
            if(tempTopology != null)
                DataBase_Memory.topologyArrayList.remove(tempTopology);
            else
                System.out.println("There is no id with this topology");
    }

    public static ArrayList<component> queryDevices(String ID){

        Topology tempTopology = search_Topology(ID);
        if(tempTopology != null)
            return tempTopology.getDevices();
        else
            System.out.println("There is no id with this topology");
    return null;
    }

    public static ArrayList<component> queryDevicesWithNetlistNode(String id , HashMap<String,String> netlist) {

        ArrayList<component> result = null;
        Topology tempTopology = search_Topology(id);

        if(tempTopology == null){
            System.out.println("There is no id with this topology");
            return null;
        }

        for(component comp : tempTopology.getDevices()){
            if(comp.getNetlist() == netlist)
                result.add(comp);
        }
        return result;
    }

    public static Topology search_Topology(String id){
        for(Topology t : DataBase_Memory.topologyArrayList){
            if(t.getId().equals(id)){
                return t;
            }
        }
    return null;
    }
}
