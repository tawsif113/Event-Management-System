package com.tawsif.eventmanagement.factory;

import com.tawsif.eventmanagement.models.Event;
import com.tawsif.eventmanagement.utility.Validator;

public class EventFactory {
    public Event createEvent(String type, String name, String date, String venue, int capacity) {
        if(capacity<0) throw Validator.getException("negative",capacity);
        return switch (type.toLowerCase()) {
            case "seminar" -> new Event.EventBuilder(name, type, date, venue, capacity)
                    .withSpeakerDetails("Default Speaker")
                    .build();
            case "concert" -> new Event.EventBuilder(name, type, date, venue, capacity)
                    .withVIPAccess(true)
                    .build();
            default ->throw Validator.getException("invalid",type);
        };
    }

}
