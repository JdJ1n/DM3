// src/main/java/com/travel/view/admin/AdminView.java
package com.travel.view.admin;

import com.travel.observer.Observer;
import com.travel.observer.Subject;

import javax.swing.*;
import java.awt.*;

public class AdminView extends JFrame implements Observer {
    public AdminView() {
        super("Admin Dashboard");
        // 只关闭自己窗口
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        // 示例布局，你可以根据需要扩展
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(new JLabel("Welcome, Admin!"), BorderLayout.NORTH);
    }

    @Override
    public void update(Subject subject) {
        // 系统模型变化时刷新 Admin 视图
        // 例如：reload tables, lists...
    }
}
