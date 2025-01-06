package com.tawsif.eventmanagement.models;

import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private static int idCounter = 0;
    private final int id;

    @NotBlank
    private String name;
    private String type;
    private String date;
    private String venue;
    private int capacity;
    private String speakerDetails;
    private boolean vipAccess;
    private List<User> registrations;

    private Event(EventBuilder builder) {
        this.id = ++idCounter;
        this.name = builder.name;
        this.type = builder.type;
        this.date = builder.date;
        this.venue = builder.venue;
        this.capacity = builder.capacity;
        this.speakerDetails = builder.speakerDetails;
        this.vipAccess = builder.vipAccess;
        this.registrations = new ArrayList<>();
    }

    public boolean addRegistration(User user) {
        if (registrations.size() < capacity) {
            registrations.add(user);
            return true;
        }
        return false;
    }

    public boolean isFullyBooked() {
        return registrations.size() == capacity;
    }

    public int getOccupancyPercentage() {
        return (registrations.size() * 100) / capacity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<User> getRegistrations() {
        return registrations;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", date='" + date + '\'' +
                ", venue='" + venue + '\'' +
                ", capacity=" + capacity +
                ", speakerDetails='" + speakerDetails + '\'' +
                ", vipAccess=" + vipAccess +
                ", registrations=" + registrations.size() +
                '}';
    }

    public static class EventBuilder {
        private String name;
        private String type;
        private String date;
        private String venue;
        private int capacity;
        private String speakerDetails;
        private boolean vipAccess;

        public EventBuilder(String name, String type, String date, String venue, int capacity) {
            this.name = name;
            this.type = type;
            this.date = date;
            this.venue = venue;
            this.capacity = capacity;
        }

        public EventBuilder withSpeakerDetails(String speakerDetails) {
            this.speakerDetails = speakerDetails;
            return this;
        }

        public EventBuilder withVIPAccess(boolean vipAccess) {
            this.vipAccess = vipAccess;
            return this;
        }

        public Event build() {
            return new Event(this);
        }
    }
}
