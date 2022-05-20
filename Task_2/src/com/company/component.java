package com.company;

import java.util.HashMap;

public class component {

    private String type;
    private String id;
    private HashMap<String, String> netlist;
    private range range;

    public component(String type, String id, HashMap<String, String> netlist, range range) {
        this.type = type;
        this.id = id;
        this.netlist = netlist;
        this.range = range;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public HashMap<String, String> getNetlist() {
        return netlist;
    }

    public com.company.range getRange() {
        return range;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNetlist(HashMap<String, String> netlist) {
        this.netlist = netlist;
    }

    public void setRange(com.company.range range) {
        this.range = range;
    }




}
