//package com.travel.gui.admin;
//
//import com.travel.*;
//import com.travel.command.CommandManager;
//import com.travel.model.*;
//import com.travel.observer.Observer;
//import com.travel.observer.TravelModel;
//import com.travel.visitor.AdminDisplayVisitor;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
///**
// * FlightAdminPanel is the admin panel for managing flights and companies.
// * It implements Observer to refresh its display when the TravelModel changes.
// * Admin can delete a company (and its flights) or add a new flight using commands.
// */
//public class FlightAdminPanel extends JPanel implements Observer {
//    private TravelModel model;
//    private CommandManager commandManager;
//    private JList<Company> companyJList;
//    private JList<Flight> flightJList;
//    private DefaultListModel<Company> companyListModel;
//    private DefaultListModel<Flight> flightListModel;
//    private JButton deleteCompanyButton;
//    private JButton addFlightButton;
//
//    public FlightAdminPanel(TravelModel model, CommandManager commandManager) {
//        this.model = model;
//        this.commandManager = commandManager;
//        setLayout(new BorderLayout());
//
//        // Initialize list models and JLists
//        companyListModel = new DefaultListModel<>();
//        flightListModel = new DefaultListModel<>();
//        companyJList = new JList<>(companyListModel);
//        flightJList = new JList<>(flightListModel);
//        companyJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        flightJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//
//        // Use custom cell renderers to display details via AdminDisplayVisitor
//        companyJList.setCellRenderer(new DefaultListCellRenderer() {
//            private AdminDisplayVisitor visitor = new AdminDisplayVisitor();
//            @Override
//            public Component getListCellRendererComponent(JList<?> list, Object value,
//                                                          int index, boolean isSelected, boolean cellHasFocus) {
//                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
//                if (value instanceof Company) {
//                    label.setText(visitor.visitCompany((Company) value));
//                }
//                return label;
//            }
//        });
//        flightJList.setCellRenderer(new DefaultListCellRenderer() {
//            private AdminDisplayVisitor visitor = new AdminDisplayVisitor();
//            @Override
//            public Component getListCellRendererComponent(JList<?> list, Object value,
//                                                          int index, boolean isSelected, boolean cellHasFocus) {
//                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
//                if (value instanceof Flight) {
//                    label.setText(visitor.visitFlight((Flight) value));
//                }
//                return label;
//            }
//        });
//
//        // Create buttons
//        deleteCompanyButton = new JButton("Delete Company");
//        addFlightButton = new JButton("Add Flight");
//
//        // Panel for companies list and delete button
//        JPanel companyPanel = new JPanel(new BorderLayout());
//        companyPanel.add(new JLabel("Companies:"), BorderLayout.NORTH);
//        companyPanel.add(new JScrollPane(companyJList), BorderLayout.CENTER);
//        companyPanel.add(deleteCompanyButton, BorderLayout.SOUTH);
//
//        // Panel for flights list and add button
//        JPanel flightPanel = new JPanel(new BorderLayout());
//        flightPanel.add(new JLabel("Flights:"), BorderLayout.NORTH);
//        flightPanel.add(new JScrollPane(flightJList), BorderLayout.CENTER);
//        flightPanel.add(addFlightButton, BorderLayout.SOUTH);
//
//        // Combine sub-panels side by side
//        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 10, 0));
//        mainPanel.add(companyPanel);
//        mainPanel.add(flightPanel);
//        add(mainPanel, BorderLayout.CENTER);
//
//        // Button actions
//        deleteCompanyButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Company selected = companyJList.getSelectedValue();
//                if (selected == null) {
//                    JOptionPane.showMessageDialog(FlightAdminPanel.this,
//                            "Please select a company to delete.",
//                            "No Company Selected", JOptionPane.WARNING_MESSAGE);
//                } else {
//                    // Execute DeleteCompany command
//                    Command cmd = new DeleteCompanyCommand(model, selected);
//                    commandManager.executeCommand(cmd);
//                }
//            }
//        });
//        addFlightButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Company selectedCompany = companyJList.getSelectedValue();
//                if (selectedCompany == null) {
//                    JOptionPane.showMessageDialog(FlightAdminPanel.this,
//                            "Please select a company for the new flight.",
//                            "No Company Selected", JOptionPane.WARNING_MESSAGE);
//                    return;
//                }
//                // Prompt admin for new flight details
//                String origin = JOptionPane.showInputDialog(FlightAdminPanel.this,
//                        "Enter origin city/airport for the new flight:");
//                if (origin == null || origin.trim().isEmpty()) {
//                    return; // cancelled or empty
//                }
//                String destination = JOptionPane.showInputDialog(FlightAdminPanel.this,
//                        "Enter destination city/airport for the new flight:");
//                if (destination == null || destination.trim().isEmpty()) {
//                    return;
//                }
//                String seatsStr = JOptionPane.showInputDialog(FlightAdminPanel.this,
//                        "Enter total number of seats for the new flight:");
//                if (seatsStr == null || seatsStr.trim().isEmpty()) {
//                    return;
//                }
//                int totalSeats;
//                try {
//                    totalSeats = Integer.parseInt(seatsStr.trim());
//                } catch (NumberFormatException ex) {
//                    JOptionPane.showMessageDialog(FlightAdminPanel.this,
//                            "Invalid number of seats.",
//                            "Input Error", JOptionPane.ERROR_MESSAGE);
//                    return;
//                }
//                // Execute CreateTrip command (to add flight)
//                Command cmd = new CreateTripCommand(model, selectedCompany, origin, destination, totalSeats);
//                commandManager.executeCommand(cmd);
//            }
//        });
//
//        // Populate initial lists
//        refreshLists();
//    }
//
//    private void refreshLists() {
//        companyListModel.clear();
//        for (Company comp : model.getCompanies()) {
//            companyListModel.addElement(comp);
//        }
//        flightListModel.clear();
//        for (Flight f : model.getFlights()) {
//            flightListModel.addElement(f);
//        }
//    }
//
//    @Override
//    public void update(Subject subject) {
//        // Refresh lists when model changes
//        refreshLists();
//    }
//}
//
