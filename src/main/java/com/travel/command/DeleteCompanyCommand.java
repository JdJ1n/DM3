//package com.travel.command;
//
//import com.travel.model.*;
//import com.travel.observer.*;
///**
// * Concrete Command to delete a company.
// * This will remove the company and all its flights (and associated reservations) from the model.
// */
//public class DeleteCompanyCommand implements Command {
//    private TravelModel model;
//    private Company company;
//
//    public DeleteCompanyCommand(TravelModel model, Company company) {
//        this.model = model;
//        this.company = company;
//    }
//
//    @Override
//    public void execute() {
//        model.removeCompany(company);
//    }
//}
//
