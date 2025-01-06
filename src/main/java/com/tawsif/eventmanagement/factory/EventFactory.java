package com.tawsif.eventmanagement.factory;

import com.tawsif.eventmanagement.models.Event;

public class EventFactory {
    public Event createEvent(String type, String name, String date, String venue, int capacity) {
        return switch (type.toLowerCase()) {
            case "seminar" -> new Event.EventBuilder(name, type, date, venue, capacity)
                    .withSpeakerDetails("Default Speaker")
                    .build();
            case "concert" -> new Event.EventBuilder(name, type, date, venue, capacity)
                    .withVIPAccess(true)
                    .build();
            default -> new Event.EventBuilder(name, type, date, venue, capacity).build();
        };
    }
}
