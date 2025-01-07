package com.tawsif.eventmanagement.utility;


import com.tawsif.eventmanagement.models.Event;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileManager {
    private static final String filePath = "C:\\Users\\tawsif.rahman\\Downloads\\ab.csv";
    public static void exportToCSV(List<Event> events) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("ID,Name,Type,Date,Venue,Capacity,Registrations\n");
            for (Event event : events) {
                writer.write(event.toCSV() + "\n");
            }
        }
    }
}
