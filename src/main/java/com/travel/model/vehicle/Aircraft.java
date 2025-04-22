package com.travel.model.vehicle;
import com.travel.model.section.*;
import com.travel.model.company.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Aircraft extends Vehicle{
    private int id;
    private ArrayList<FlightSection> sections;
    private static final Set<Integer> usedCodes = new HashSet<>();
    public Aircraft(Company company, int id, String type) {
        super(company, type);
        validateCode(id);
        this.id = id;
        usedCodes.add(id);
        sections=new ArrayList<>();
    }

    public Aircraft(Company company, int id, String type,ArrayList<FlightSection> sections) {
        super(company, type);
        validateCode(id);
        this.id = id;
        usedCodes.add(id);
        this.sections=sections;
    }

    private void validateCode(int code) {
        if (code > 9999||code<1) {
            throw new IllegalArgumentException("Aircraft code must be 1 - 9999.");
        }
        if (usedCodes.contains(code)) {
            throw new IllegalArgumentException("Aircraft code \"" + code + "\" must be unique.");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        validateCode(id);
        usedCodes.remove(this.id);
        this.id = id;
        usedCodes.add(id);
    }

    public String getFullId() {
        return this.getCompany().getCode()+id;
    }

    public ArrayList<FlightSection> getSections() {
        return sections;
    }

    public boolean addSection(String name,int row,int col,char classe,String classeName,double rate) {
        for (Section s:sections){
            if(s.getClasse().getId()==classe)
                return false;
        }
        this.sections.add(new FlightSection(name,row,col,new Classe(classe,classeName,rate)));
        return true;
    }

    public FlightSection findSection(char classe){
        for (FlightSection s:sections){
            if (s.getClasse().getId() == classe) {
                return s;
            }
        }
        return null;
    }

    public void setSections(ArrayList<FlightSection> sections) {
        this.sections = sections;
    }

}
