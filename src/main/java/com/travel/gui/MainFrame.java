//package com.travel.gui;
//
//
//import com.travel.command.CommandManager;
//import com.travel.gui.admin.AdminFrame;
//import com.travel.gui.client.ClientFrame;
//import com.travel.observer.TravelModel;
//
//import javax.swing.JFrame;
//
///**
// * MainFrame sets up the entire application. It creates the shared model and command manager,
// * then launches the AdminFrame and ClientFrame windows.
// */
//public class MainFrame extends JFrame {
//    public static void main(String[] args) {
//        // Initialize model and command manager
//        TravelModel model = new TravelModel();
//        CommandManager commandManager = new CommandManager(model);
//        // Launch Admin and Client GUI frames
//        AdminFrame adminFrame = new AdminFrame(model, commandManager);
//        ClientFrame clientFrame = new ClientFrame(model, commandManager);
//        adminFrame.setVisible(true);
//        clientFrame.setVisible(true);
//    }
//}
//
