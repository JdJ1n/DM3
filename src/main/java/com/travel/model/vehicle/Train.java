package com.travel.model.vehicle;
import com.travel.model.section.*;
import com.travel.model.company.*;

import java.util.ArrayList;

public class Train extends Vehicle{
    private String id;
    private ArrayList<TrainSection> sections;
    public Train(Company company, String id, String type) {
        super(company, type);
        this.id = id;
        sections=new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<TrainSection> getSections() {
        return sections;
    }

    public void setSections(ArrayList<TrainSection> sections) {
        this.sections = sections;
    }
}
