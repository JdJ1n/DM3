// src/main/java/com/travel/view/client/ClientView.java
package com.travel.view.client;

import com.travel.observer.Observer;
import com.travel.observer.Subject;

import javax.swing.*;
import java.awt.*;

public class ClientView extends JFrame implements Observer {
    public ClientView() {
        super("Client Dashboard");
        // 只关闭自己窗口
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        // 示例布局，你可以根据需要扩展
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(new JLabel("Welcome, Client!"), BorderLayout.NORTH);
    }

    @Override
    public void update(Subject subject) {
        // 系统模型变化时刷新 Client 视图
        // 例如：reload user-specific data...
    }
}
