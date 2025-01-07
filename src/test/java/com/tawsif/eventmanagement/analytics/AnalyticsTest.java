package com.tawsif.eventmanagement.analytics;

import com.tawsif.eventmanagement.factory.EventFactory;
import com.tawsif.eventmanagement.models.Event;
import com.tawsif.eventmanagement.models.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnalyticsTest {

    @Test
    void EventAnalyticsWithNoEvents() {
        List<Event> events = new ArrayList<>();
        Analytics.displayEventAnalytics(events);
        // Add assertions or mock verifications if Analytics.displayEventAnalytics outputs can be captured
    }

    @Test
    void EventAnalyticsWithSingleEvent() {
        List<Event> events = new ArrayList<>();
        EventFactory eventFactory = new EventFactory();
        events.add(eventFactory.createEvent("concert", "Java Bootcamp", "2025-09-20", "New York", 50));
        Analytics.displayEventAnalytics(events);
    }

    @Test
    void EventAnalyticsWhenAllFieldsAreValid() {
        List<Event> events = new ArrayList<>();
        EventFactory eventFactory = new EventFactory();
        events.add(eventFactory.createEvent("seminar","Comicon","2025-12-11","dhaka",10));
        events.add(eventFactory.createEvent("Concert","Taylor Swift Tour","2025-12-31","dhaka",100));
        User user = new User("Taylor","abc@gmail.com","12345678910");
        User user1 = new User("Taylor Mash","abc1@gmail.com","12345678910");
        events.get(0).addRegistration(user);
        events.get(1).addRegistration(user);
        events.get(1).addRegistration(user1);
        Analytics.displayEventAnalytics(events);

    }
}