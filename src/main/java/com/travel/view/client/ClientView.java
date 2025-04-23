// src/main/java/com/travel/view/client/ClientView.java
package com.travel.view.client;

import com.travel.controller.MainController;
import com.travel.model.journey.CruiseJourney;
import com.travel.model.journey.FlightJourney;
import com.travel.model.journey.Journey;
import com.travel.model.journey.TrainJourney;
import com.travel.model.reservation.CruiseReservation;
import com.travel.model.reservation.FlightReservation;
import com.travel.model.reservation.Reservation;
import com.travel.model.reservation.TrainReservation;
import com.travel.observer.Observer;
import com.travel.observer.Subject;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class ClientView extends JFrame implements Observer {
    private final MainController controller;

    private final DefaultListModel<Journey> journeyModel       = new DefaultListModel<>();
    private final JList<Journey>         journeyList            = new JList<>(journeyModel);
    private final JButton                bookBtn                = new JButton("Book");

    private final DefaultListModel<Reservation> resModel  = new DefaultListModel<>();
    private final JList<Reservation>          resList   = new JList<>(resModel);
    private final JButton                     deleteBtn = new JButton("Delete");

    public ClientView(MainController controller) {
        super("Client Dashboard");
        this.controller = controller;

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        split.setResizeWeight(0.5);

        JPanel top = new JPanel(new BorderLayout());
        top.setBorder(BorderFactory.createTitledBorder("Available Journeys"));
        top.add(new JScrollPane(journeyList), BorderLayout.CENTER);
        top.add(bookBtn, BorderLayout.EAST);

        JPanel bot = new JPanel(new BorderLayout());
        bot.setBorder(BorderFactory.createTitledBorder("Your Reservations"));
        bot.add(new JScrollPane(resList), BorderLayout.CENTER);
        bot.add(deleteBtn, BorderLayout.EAST);

        split.setTopComponent(top);
        split.setBottomComponent(bot);
        add(split, BorderLayout.CENTER);

        deleteBtn.addActionListener(e -> {
            Reservation sel = resList.getSelectedValue();
            if (sel != null) {
                controller.removeReservation(sel);
            }
        });

        bookBtn.addActionListener(e -> {
            Journey sel = journeyList.getSelectedValue();
            if (sel == null) {
                JOptionPane.showMessageDialog(this, "Please select a journey");
                return;
            }
            String ref = JOptionPane.showInputDialog(this, "Enter reservation ref:");
            if (ref == null || ref.trim().isEmpty()) return;

            LocalDateTime now = LocalDateTime.now();
            Reservation r;
            if (sel instanceof FlightJourney) {
                r = new FlightReservation(ref, sel, now, now.plusDays(1));
            } else if (sel instanceof TrainJourney) {
                r = new TrainReservation(ref, sel, now, now.plusDays(1));
            } else if (sel instanceof CruiseJourney) {
                r = new CruiseReservation(ref, sel, now, now.plusDays(1));
            } else {
                JOptionPane.showMessageDialog(this, "Unknown journey type");
                return;
            }
            controller.addReservation(r);
        });

        refreshJourneys();
        refreshReservations();
    }

    private void refreshJourneys() {
        journeyModel.clear();
        for (Journey j : controller.getAllJourneys()) {
            journeyModel.addElement(j);
        }
    }

    private void refreshReservations() {
        resModel.clear();
        for (Reservation r : controller.getAllReservations()) {
            resModel.addElement(r);
        }
    }

    @Override
    public void update(Subject subject) {
        SwingUtilities.invokeLater(() -> {
            refreshJourneys();
            refreshReservations();
        });
    }
}
