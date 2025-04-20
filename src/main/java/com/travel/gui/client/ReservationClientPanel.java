//package com.travel.gui.client;
//
//import travel.*;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
///**
// * ReservationClientPanel is the client panel for viewing flights and making reservations.
// * It implements Observer to update the available flights and reservations lists when the model changes.
// * Clients can select a flight and reserve a seat, which creates a new itinerary (reservation).
// */
//public class ReservationClientPanel extends JPanel implements Observer {
//    private TravelModel model;
//    private CommandManager commandManager;
//    private JList<Flight> flightJList;
//    private JList<Itinerary> itineraryJList;
//    private DefaultListModel<Flight> flightListModel;
//    private DefaultListModel<Itinerary> itineraryListModel;
//    private JButton reserveButton;
//
//    public ReservationClientPanel(TravelModel model, CommandManager commandManager) {
//        this.model = model;
//        this.commandManager = commandManager;
//        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//
//        // Initialize list models and lists
//        flightListModel = new DefaultListModel<>();
//        itineraryListModel = new DefaultListModel<>();
//        flightJList = new JList<>(flightListModel);
//        itineraryJList = new JList<>(itineraryListModel);
//        flightJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        itineraryJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        // (Itinerary list is read-only for the client)
//
//        // Custom renderers using ClientDisplayVisitor for display formatting
//        flightJList.setCellRenderer(new DefaultListCellRenderer() {
//            private ClientDisplayVisitor visitor = new ClientDisplayVisitor();
//            @Override
//            public Component getListCellRendererComponent(JList<?> list, Object value,
//                                                          int index, boolean isSelected, boolean cellHasFocus) {
//                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
//                if (value instanceof Flight) {
//                    label.setText(visitor.visitFlight((Flight) value));
//                }
//                return label;
//            }
//        });
//        itineraryJList.setCellRenderer(new DefaultListCellRenderer() {
//            private ClientDisplayVisitor visitor = new ClientDisplayVisitor();
//            @Override
//            public Component getListCellRendererComponent(JList<?> list, Object value,
//                                                          int index, boolean isSelected, boolean cellHasFocus) {
//                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
//                if (value instanceof Itinerary) {
//                    label.setText(visitor.visitItinerary((Itinerary) value));
//                }
//                return label;
//            }
//        });
//
//        reserveButton = new JButton("Reserve Seat");
//
//        // Labels for sections
//        JLabel flightsLabel = new JLabel("Available Flights:");
//        JLabel reservationsLabel = new JLabel("Your Reservations:");
//
//        // Align components and set preferred sizes for scroll panes
//        flightsLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
//        add(flightsLabel);
//        JScrollPane flightScroll = new JScrollPane(flightJList);
//        flightScroll.setAlignmentX(Component.LEFT_ALIGNMENT);
//        flightScroll.setPreferredSize(new Dimension(450, 150));
//        add(flightScroll);
//        reserveButton.setAlignmentX(Component.LEFT_ALIGNMENT);
//        add(reserveButton);
//        reservationsLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
//        add(reservationsLabel);
//        JScrollPane itineraryScroll = new JScrollPane(itineraryJList);
//        itineraryScroll.setAlignmentX(Component.LEFT_ALIGNMENT);
//        itineraryScroll.setPreferredSize(new Dimension(450, 100));
//        add(itineraryScroll);
//
//        // Reserve button action
//        reserveButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Flight selectedFlight = flightJList.getSelectedValue();
//                if (selectedFlight == null) {
//                    JOptionPane.showMessageDialog(ReservationClientPanel.this,
//                            "Please select a flight to reserve.",
//                            "No Flight Selected", JOptionPane.WARNING_MESSAGE);
//                } else {
//                    if (selectedFlight.getAvailableSeats() <= 0) {
//                        JOptionPane.showMessageDialog(ReservationClientPanel.this,
//                                "No seats available on the selected flight.",
//                                "Reservation Failed", JOptionPane.ERROR_MESSAGE);
//                        return;
//                    }
//                    // Execute ReserveSeat command
//                    Command cmd = new ReserveSeatCommand(model, selectedFlight);
//                    commandManager.executeCommand(cmd);
//                    // (Optional: show confirmation message)
//                }
//            }
//        });
//
//        // Populate initial lists
//        refreshLists();
//    }
//
//    private void refreshLists() {
//        flightListModel.clear();
//        for (Flight f : model.getFlights()) {
//            flightListModel.addElement(f);
//        }
//        itineraryListModel.clear();
//        for (Itinerary it : model.getItineraries()) {
//            itineraryListModel.addElement(it);
//        }
//    }
//
//    @Override
//    public void update(Subject subject) {
//        // Update flight and itinerary lists when model changes
//        refreshLists();
//    }
//}
//
