//package com.travel.gui.client;
//
//import com.travel.command.CommandManager;
//import com.travel.gui.admin.AdminFrame;
//import com.travel.gui.client.ClientFrame;
//import com.travel.observer.TravelModel;
//import javax.swing.JFrame;
//import javax.swing.JTabbedPane;
//
///**
// * ClientFrame is the main window for the client interface.
// * It contains a tabbed pane with client panels (e.g., ReservationClientPanel for bookings).
// */
//public class ClientFrame extends JFrame {
//    private TravelModel model;
//    private CommandManager commandManager;
//
//    public ClientFrame(TravelModel model, CommandManager commandManager) {
//        super("Client Console");
//        this.model = model;
//        this.commandManager = commandManager;
//
//        JTabbedPane tabs = new JTabbedPane();
//        //ReservationClientPanel reservationPanel = new ReservationClientPanel(model, commandManager);
//        //tabs.addTab("Reservations", reservationPanel);
//        add(tabs);
//
//        // Attach the panel as an observer
//        //model.attach(reservationPanel);
//
//        // Frame settings
//        setSize(500, 400);
//        setLocation(620, 100);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//    }
//}
//
