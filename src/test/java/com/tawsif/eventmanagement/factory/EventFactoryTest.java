package com.tawsif.eventmanagement.factory;

import com.tawsif.eventmanagement.models.Event;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventFactoryTest {

    @Test
    void createEventAllFieldsAreValid() {
        EventFactory eventFactory = new EventFactory();
        Event event = eventFactory.createEvent("seminar","Comicon","2025-12-11","dhaka",4);
        assertNotNull(event);
    }
    @Test
    void createEventOnlyRequiredFieldsAreValid() {
        EventFactory eventFactory = new EventFactory();
        Event event = eventFactory.createEvent("seminar","Comicon","2025-12-11","dhaka",0);
        assertNotNull(event);
    }
    ///  failing test as we have just made it default
    @Test
    void createEventInvalidType() {
        EventFactory eventFactory = new EventFactory();
        assertThrows(IllegalArgumentException.class, () -> eventFactory.createEvent("invalid","Comicon","2025-12-11","dhaka",4));
    }
    @Test
    void createEventInvalidCapacity() {
        EventFactory eventFactory = new EventFactory();
        assertThrows(IllegalArgumentException.class, () -> eventFactory.createEvent("seminar","Comicon","2025-12-11","dhaka",-1));
    }
}