// 文件：src/main/java/com/travel/view/MainView.java
package com.travel.view;

import com.travel.controller.MainController;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    private final MainController controller;

    public MainView() {
        super("Travel System - Select Role");
        this.controller = new MainController();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setSize(300, 120);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        JButton adminBtn = new JButton("Admin");
        JButton clientBtn = new JButton("Client");

        adminBtn.addActionListener(e -> controller.handleRoleSelection(this, true));
        clientBtn.addActionListener(e -> controller.handleRoleSelection(this, false));

        add(adminBtn);
        add(clientBtn);
    }

    public void showView() {
        setVisible(true);
    }
}
