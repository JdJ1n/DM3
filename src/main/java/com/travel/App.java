package com.travel;

import com.travel.view.MainView;
import com.travel.controller.MainController;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainView main = new MainView();
            main.showView();
        });
    }
}
