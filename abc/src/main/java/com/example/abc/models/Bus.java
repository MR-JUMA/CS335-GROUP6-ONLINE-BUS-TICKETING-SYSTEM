package com.example.abc.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Bus extends Common{
    private String Name;
    private String PlateNumber;
    private String Type;


    //    @ManyToOne
//    private BusSchedule busSchedule;


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPlateNumber() {
        return PlateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        PlateNumber = plateNumber;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

//    public BusSchedule getBusSchedule() {
//        return busSchedule;
//    }
//
//    public void setBusSchedule(BusSchedule busSchedule) {
//        this.busSchedule = busSchedule;
//    }

    @Override
    public String toString() {
        return "Bus{" +
                "Name='" + Name + '\'' +
                ", PlateNumber='" + PlateNumber + '\'' +
                ", Type='" + Type + '\'' +
               // ", busSchedule=" + busSchedule +
                '}';
    }
}
