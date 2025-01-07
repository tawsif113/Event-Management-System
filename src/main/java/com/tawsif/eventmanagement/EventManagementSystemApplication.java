package com.tawsif.eventmanagement;

import com.tawsif.eventmanagement.analytics.Analytics;
import com.tawsif.eventmanagement.factory.EventFactory;
import com.tawsif.eventmanagement.models.Event;
import com.tawsif.eventmanagement.models.User;
import com.tawsif.eventmanagement.utility.FileManager;
import com.tawsif.eventmanagement.utility.Validator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class EventManagementSystemApplication {
	private static final List<Event> events = new ArrayList<>();
	private static final EventFactory eventFactory = new EventFactory();
	private static final ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

	public static void main(String[] args) {
		SpringApplication.run(EventManagementSystemApplication.class, args);

		Scanner scanner = new Scanner(System.in);
		boolean running = true;
		System.out.println("Event Management System");
		while(running){
			System.out.println("1. Create Event\n2. Register User\n3. View Analytics\n4.Export Data\n5. Exit");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice){
				case 1 -> createEvent(scanner);
				case 2 -> registerUser(scanner);
				case 3 -> viewAnalytics(scanner);
				case 4 -> exportData();
				case 5 -> running = false;
				default -> System.out.println("Invalid choice. Please try again.");
			}

		}
		executor.shutdown();
	}
	private static void createEvent(Scanner scanner) {

		System.out.println("Enter event name: ");
		String name = scanner.nextLine();
		System.out.println("Enter event type (seminar / concert): ");
		String type = scanner.nextLine();
		System.out.println("Enter event date (YYYY-MM-DD): ");
		String date = scanner.nextLine();
		System.out.println("Enter event venue: ");
		String venue = scanner.nextLine();
		System.out.println("Enter event capacity: ");
		int capacity = scanner.nextInt();
		scanner.nextLine();

		Event event = eventFactory.createEvent(type, name, date, venue, capacity);
		if(Validator.validateEvent("name",name)
				&& Validator.validateEvent("date",date)
				&& Validator.validateEvent("capacity",capacity)
				&& Validator.validateEvent("venue",venue)) events.add(event);
		else {
			System.out.println("Event creation failed. Please try again. Invalid input");
			return;
		}
		System.out.println("Event created: " + event);

	}
	private static void registerUser(Scanner scanner) {
		System.out.println("Enter event ID to register for the event");
		int eventId = scanner.nextInt();
		scanner.nextLine();

		Event event = events.stream().filter(e->e.getId() == eventId).findFirst().orElse(null);

		if(event == null){
			System.out.println("Event not found");
			return;
		}

		System.out.println("Enter your name: ");
		String name = scanner.nextLine();
		System.out.println("Enter your email: ");
		String email = scanner.nextLine();
		System.out.println("Enter your phone: ");
		String phone = scanner.nextLine();

		executor.submit(()->{
			User user = new User(name,email,phone);
			if(user.validate() && !Validator.validateDuplicateUser(event,user) && event.addRegistration(user)){
				System.out.println("You have successfully registered for the event");
			}
			else {
				System.out.println("Registration failed. Event might be full or u have already registered for the event.");
			}
		});
		executor.submit(()->viewAnalytics(scanner));
	}

	private static void exportData() {
		executor.submit(() -> {
			try {
				FileManager.exportToCSV(events);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		});
	}

	private static void viewAnalytics(Scanner scanner) {
		executor.submit(() -> Analytics.displayEventAnalytics(events));
	}


}
