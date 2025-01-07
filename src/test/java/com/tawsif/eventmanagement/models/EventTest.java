package com.tawsif.eventmanagement.models;

import com.tawsif.eventmanagement.factory.EventFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    @Test
    void addRegistration() {
        EventFactory eventFactory = new EventFactory();
        Event event = eventFactory.createEvent("seminar","Comicon","2025-12-11","dhaka",4);
        User user = new User("John Doe","abc@email.com","01533406937");
        assertTrue(event.addRegistration(user));
    }

    @Test
    void isFullyBooked() {
        EventFactory eventFactory = new EventFactory();
        Event event = eventFactory.createEvent("seminar","Comicon","2025-12-11","dhaka",3);
        User user = new User("John Doe","abc@email.com","01533406937");
        User user1 = new User("John Doe","abc@email.com","01533406937");
        User user2 = new User("John Doe","abc@email.com","01533406937");
        event.addRegistration(user);
        event.addRegistration(user1);
        event.addRegistration(user2);
        assertTrue(event.isFullyBooked());
    }

    @Test
    void getOccupancyPercentage_whenEventIsFull() {
        EventFactory eventFactory = new EventFactory();
        Event event = eventFactory.createEvent("seminar","Comicon","2025-12-11","dhaka",3);
        User user = new User("John Doe","abc@email.com","01533406937");
        User user1 = new User("John Doe","abc@email.com","01533406937");
        User user2 = new User("John Doe","abc@email.com","01533406937");
        event.addRegistration(user);
        event.addRegistration(user1);
        event.addRegistration(user2);
        assertEquals(100,event.getOccupancyPercentage());
    }
    @Test
    void getOccupancyPercentage_whenEventIsHalfFull() {
        EventFactory eventFactory = new EventFactory();
        Event event = eventFactory.createEvent("seminar","Comicon","2025-12-11","dhaka",6);
        User user = new User("John Doe","abc@email.com","01533406937");
        User user1 = new User("John Doe","abc@email.com","01533406937");
        User user2 = new User("John Doe","abc@email.com","01533406937");
        event.addRegistration(user);
        event.addRegistration(user1);
        event.addRegistration(user2);
        assertEquals(50,event.getOccupancyPercentage());
    }

    @Test
    void getId() {
        EventFactory eventFactory = new EventFactory();
        Event event = eventFactory.createEvent("seminar","Comicon","2025-12-11","dhaka",4);
        assertEquals(1,event.getId());
    }

    @Test
    void getName() {
        EventFactory eventFactory = new EventFactory();
        Event event = eventFactory.createEvent("seminar","Comicon","2025-12-11","dhaka",4);
        assertEquals("Comicon",event.getName());
    }

    @Test
    void getRegistrations() {
        EventFactory eventFactory = new EventFactory();
        Event event = eventFactory.createEvent("seminar","Comicon","2025-12-11","dhaka",4);
        User user = new User("John Doe","abc@email.com","01533406937");
        User user1 = new User("John Doe","abc@email.com","01533406937");
        event.addRegistration(user);
        event.addRegistration(user1);
        assertEquals(2,event.getRegistrations().size());
    }

    @Test
    void toCSV() {
        EventFactory eventFactory = new EventFactory();
        Event event = eventFactory.createEvent("seminar","Comicon","2025-12-11","dhaka",4);
        User user = new User("John Doe","abc@email.com","01533406937");
        User user1 = new User("John Doe","abc@email.com","01533406937");
        event.addRegistration(user);
        event.addRegistration(user1);
        assertEquals("1,Comicon,seminar,2025-12-11,dhaka,4,2",event.toCSV());
    }
}