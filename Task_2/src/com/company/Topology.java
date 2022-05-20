package com.company;

import java.util.ArrayList;

public class Topology {
    private String id;
    private ArrayList<component> Devices;

    public Topology(String id, ArrayList<component> devices) {
        this.id = id;
        Devices = devices;
    }

    public String getId() {
        return id;
    }

    public ArrayList<component> getDevices() {
        return Devices;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDevices(ArrayList<component> devices) {
        Devices = devices;
    }
}
