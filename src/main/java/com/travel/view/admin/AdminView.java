// src/main/java/com/travel/view/admin/AdminView.java
package com.travel.view.admin;

import com.travel.observer.Observer;
import com.travel.observer.Subject;
import com.travel.observer.SystemModel;
import com.travel.model.journey.Journey;

import javax.swing.*;
import java.awt.*;

public class AdminView extends JFrame implements Observer {
    private final DefaultListModel<Journey> journeyListModel = new DefaultListModel<>();
    private final JList<Journey> journeyList = new JList<>(journeyListModel);
    private final JButton addBtn    = new JButton("Add Journey");
    private final JButton removeBtn = new JButton("Remove Journey");
    private final JButton refreshBtn= new JButton("Refresh List");

    public AdminView() {
        super("Admin Dashboard");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // 中心：Journey 列表
        journeyList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(journeyList);
        add(scrollPane, BorderLayout.CENTER);

        // 南部：功能按钮
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addBtn);
        buttonPanel.add(removeBtn);
        buttonPanel.add(refreshBtn);
        add(buttonPanel, BorderLayout.SOUTH);

        // 按钮逻辑（可进一步扩展）
        refreshBtn.addActionListener(e -> refreshJourneys());
        removeBtn.addActionListener(e -> {
            Journey sel = journeyList.getSelectedValue();
            if (sel != null) {
                // TODO: 调用 Controller 或 SystemModel 删除
                // SystemModel.getInstance().removeJourney(sel);
                journeyListModel.removeElement(sel);
            }
        });
        addBtn.addActionListener(e -> {
            // TODO: 弹出对话框，创建新 Journey，然后
            // SystemModel.getInstance().addJourney(newJourney);
            // journeyListModel.addElement(newJourney);
        });

        // 首次加载
        refreshJourneys();
    }

    private void refreshJourneys() {
        journeyListModel.clear();
        for (Journey j : SystemModel.getInstance().getJourneys()) {
            journeyListModel.addElement(j);
        }
    }

    @Override
    public void update(Subject subject) {
        // 系统模型变化时刷新列表
        SwingUtilities.invokeLater(this::refreshJourneys);
    }
}
