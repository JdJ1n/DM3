// src/main/java/com/travel/view/admin/AdminView.java
package com.travel.view.admin;

import com.travel.controller.MainController;
import com.travel.factory.JourneyFactory;
import com.travel.model.hub.Hub;
import com.travel.model.hub.Airport;
import com.travel.model.journey.Journey;
import com.travel.model.vehicle.Vehicle;
import com.travel.observer.SystemModel;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;

public class AdminView extends JFrame implements com.travel.observer.Observer {
    private final MainController controller;
    private final DefaultListModel<Journey> listModel = new DefaultListModel<>();
    private final JList<Journey> journeyList = new JList<>(listModel);

    public AdminView(MainController controller) {
        super("Admin Dashboard");
        this.controller = controller;
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10,10));

        add(new JScrollPane(journeyList), BorderLayout.CENTER);
        JPanel btnPanel = new JPanel();
        JButton addBtn    = new JButton("Add Journey");
        JButton removeBtn = new JButton("Remove Journey");
        btnPanel.add(addBtn);
        btnPanel.add(removeBtn);
        add(btnPanel, BorderLayout.SOUTH);

        removeBtn.addActionListener(e -> {
            Journey sel = journeyList.getSelectedValue();
            if (sel != null) {
                controller.removeJourney(sel);
            }
        });

        addBtn.addActionListener(e -> {
            String[] types = {"Flight", "Train", "Cruise"};
            String type = (String) JOptionPane.showInputDialog(
                    this, "Select journey type:", "Type",
                    JOptionPane.QUESTION_MESSAGE, null, types, types[0]
            );
            if (type == null) return;

            String id = JOptionPane.showInputDialog(this, "Enter Journey ID:");
            if (id == null || id.trim().isEmpty()) return;

            // select hubs
            List<Hub> hubs = SystemModel.getInstance().getHubs();
            String[] hubNames = hubs.stream().map(Object::toString).toArray(String[]::new);
            String depName = (String) JOptionPane.showInputDialog(
                    this, "Select departure hub:", "Hub",
                    JOptionPane.QUESTION_MESSAGE, null, hubNames, hubNames[0]
            );
            String arrName = (String) JOptionPane.showInputDialog(
                    this, "Select arrival hub:", "Hub",
                    JOptionPane.QUESTION_MESSAGE, null, hubNames, hubNames[0]
            );
            if (depName == null || arrName == null) return;
            Hub dep = hubs.stream().filter(h->h.toString().equals(depName)).findFirst().orElse(null);
            Hub arr = hubs.stream().filter(h->h.toString().equals(arrName)).findFirst().orElse(null);
            if (dep == null || arr == null) return;

            List<Vehicle> vehicles = SystemModel.getInstance().getVehicles();
            String[] vehNames = vehicles.stream().map(Object::toString).toArray(String[]::new);
            String vehName = (String) JOptionPane.showInputDialog(
                    this, "Select vehicle:", "Vehicle",
                    JOptionPane.QUESTION_MESSAGE, null, vehNames, vehNames[0]
            );
            Vehicle veh = vehicles.stream().filter(v->v.toString().equals(vehName)).findFirst().orElse(null);
            if (veh == null) return;

            LocalDateTime depTime = LocalDateTime.now();
            LocalDateTime arrTime = depTime.plusHours(2);

            Journey j;
            switch (type) {
                case "Flight":
                    j = JourneyFactory.getInstance()
                            .createFlightJourney(id, depTime, arrTime, veh,
                                    (Airport)dep, (Airport)arr);
                    break;
                case "Train":
                    j = JourneyFactory.getInstance()
                            .createTrainJourney(id, depTime, arrTime, veh, dep, arr);
                    break;
                case "Cruise":
                    j = JourneyFactory.getInstance()
                            .createCruiseJourney(id, depTime, arrTime, veh, dep, arr);
                    break;
                default:
                    return;
            }
            controller.addJourney(j);
        });

        refreshList();
    }

    private void refreshList() {
        listModel.clear();
        for (Journey j : controller.getAllJourneys()) {
            listModel.addElement(j);
        }
    }

    @Override
    public void update(com.travel.observer.Subject subject) {
        SwingUtilities.invokeLater(this::refreshList);
    }
}
