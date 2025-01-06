package com.tawsif.eventmanagement.analytics;

import com.tawsif.eventmanagement.models.Event;

import java.util.List;

public class Analytics {
    public static void displayEventAnalytics(List<Event> events) {
        events.forEach(event -> {
            System.out.println("Event: " + event.getName());
            System.out.println("Occupancy: " + event.getOccupancyPercentage() + "%");
        });

        System.out.println("Total Events: " + events.size());

        System.out.println("Total Occupancy for each Event:");
        events.forEach(event -> System.out.println(event.getName()+" : "+event.getRegistrations().size()));
    }
}
