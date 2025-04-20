//package com.travel.factory;
//
//import com.travel.model.Company;
//import com.travel.model.hub.Hub;
//import com.travel.model.Section;
//import com.travel.model.Trip;
//import java.time.LocalDateTime;
//
///**
// * Abstract Factory for creating travel-related objects (companies, locations, trips, sections) in different domains (air, marine, rail).
// */
//public interface TravelFactory {
//    /**
//     * Creates a company object specific to a travel domain.
//     * @param code unique code for the company
//     * @param name name of the company
//     * @return a new Company instance (AirCompany, CruiseCompany, or RailLine)
//     */
//    Company createCompany(String code, String name);
//
//    /**
//     * Creates a location object specific to a travel domain (airport, port, or station).
//     * @param code unique code for the location
//     * @param name name of the location
//     * @return a new Hub instance (Airport, Port, or Station)
//     */
//    Hub createLocation(String code, String name);
//
//    /**
//     * Creates a trip (journey) object specific to a travel domain.
//     * @param code unique code for the trip (or null to auto-generate)
//     * @param company the company operating the trip
//     * @param origin the origin location
//     * @param destination the destination location
//     * @param departureTime departure date/time
//     * @param arrivalTime arrival date/time
//     * @return a new Trip instance (Flight, Itinerary, or Journey)
//     */
//    Trip createTrip(String code, Company company, Hub origin, Hub destination,
//                    LocalDateTime departureTime, LocalDateTime arrivalTime);
//
//    /**
//     * Creates a section for seating or cabins specific to a travel domain.
//     * @param name name or class of the section (e.g., "Economy", "Suite")
//     * @param capacity number of seats or cabins in this section
//     * @param basePrice base price per seat or cabin in this section
//     * @return a new Section instance (FlightSection, CruiseSection, or RailSection)
//     */
//    Section createSection(String name, int capacity, double basePrice);
//}
