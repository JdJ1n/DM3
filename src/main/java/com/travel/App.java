package com.travel;

import com.travel.observer.SystemModel;
import com.travel.util.DataInitializer;
import com.travel.view.MainView;
import com.travel.controller.MainController;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SystemModel model = SystemModel.getInstance();
            DataInitializer.initialize(model);
            MainView main = new MainView();
            main.showView();
        });
    }
}
