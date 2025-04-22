package com.travel.model.vehicle;
import com.travel.model.section.*;
import com.travel.model.company.*;

import java.util.ArrayList;

public class Cruise extends Vehicle{
    private String id;
    private ArrayList<CruiseSection> sections;
    public Cruise(Company company, String id, String type) {

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

    public ArrayList<CruiseSection> getSections() {
        return sections;
    }

    public void setSections(ArrayList<CruiseSection> sections) {
        this.sections = sections;
    }
}
