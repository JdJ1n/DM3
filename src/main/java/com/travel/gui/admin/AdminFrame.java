//package com.travel.gui.admin;
//
//
//import com.travel.command.CommandManager;
//import com.travel.gui.admin.AdminFrame;
//import com.travel.gui.client.ClientFrame;
//import com.travel.observer.TravelModel;
//import javax.swing.JFrame;
//import javax.swing.JTabbedPane;
//
///**
// * AdminFrame is the main window for the admin interface.
// * It contains a tabbed pane with administrative panels (e.g., FlightAdminPanel).
// */
//public class AdminFrame extends JFrame {
//    private TravelModel model;
//    private CommandManager commandManager;
//
//    public AdminFrame(TravelModel model, CommandManager commandManager) {
//        super("Admin Console");
//        this.model = model;
//        this.commandManager = commandManager;
//
//        // Set up tabbed pane and add admin panels
//        JTabbedPane tabs = new JTabbedPane();
//        //FlightAdminPanel flightAdminPanel = new FlightAdminPanel(model, commandManager);
//        //tabs.addTab("Flights", flightAdminPanel);
//        add(tabs);
//
//        // Attach the panel as an observer of the model
//        //model.attach(flightAdminPanel);
//
//        // Frame settings
//        setSize(500, 400);
//        setLocation(100, 100);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//    }
//}
//
