# Event Management System

## Overview
The **Event Management System** is a modular, console-based application written in Java 21 that allows users to create, manage, and track events. It integrates essential features like user management, event scheduling, ticket booking, and real-time analytics, while adhering to modern software development practices and incorporating advanced Java features.

## Features
### User Requirements
1. **Event Creation & Management**:
   - Create events with attributes like name, type, date, venue, and capacity.
   - Update or delete existing events.
2. **User Registration**:
   - Register users for events with validation to prevent duplicate entries.
3. **Analytics**:
   - Display real-time statistics such as total registrations and event occupancy percentage.
4. **Data Export**:
   - Export event and registration details to CSV or JSON files.

### Functional Requirements (Tech Focus)
1. **Java 21 Features**:
   - **Virtual Threads**: Efficiently handle concurrent operations like user registration and analytics updates.
   - **Pattern Matching**: Validate user inputs, such as email and phone number, with pattern matching.
2. **OOP Principles and Design Patterns**:
   - **Encapsulation**: Securely manage event and user data.
   - **Inheritance and Polymorphism**: Implement a modular system for handling different event types.
   - **Design Patterns**:
     - **Singleton**: Centralized file management with a single instance.
     - **Factory**: Create event objects of various types (e.g., seminars, concerts).
     - **Builder**: Handle optional properties like speaker details and VIP access.
3. **Collections Framework, Streams, and Multithreading**:
   - Use collections (e.g., `Map` for event lookups, `List` for registrations).
   - Utilize streams for filtering and aggregating data (e.g., finding fully booked events).
   - Implement multithreading for parallel operations, such as analytics and ticket updates.
4. **Java I/O and Functional Programming**:
   - **Java I/O**: Read/write event and user data to/from CSV/JSON files.
   - **Functional Programming**: Use lambdas and functional interfaces for managing filters and input processing.

## System Design
### Core Classes
1. **Event**:
   - Attributes: `id`, `name`, `type`, `date`, `venue`, `capacity`, `registrations`.
   - Methods: `addRegistration()`, `isFullyBooked()`.
2. **User**:
   - Attributes: `id`, `name`, `email`, `phone`.
   - Methods: `validate()`.
3. **EventFactory**:
   - Create events of different types using the Factory pattern.
4. **Analytics**:
   - Real-time calculation of registration statistics using streams and multithreading.

### Utility Classes
1. **FileManager**:
   - Handles reading/writing data to/from CSV/JSON using Java I/O.
2. **ThreadManager**:
   - Manages concurrent operations using Virtual Threads.
3. **Validator**:
   - Validates inputs such as email, phone number, and event details using pattern matching.

## Features Mapped to Topics
| Feature               | Topic Coverage                                       |
|-----------------------|------------------------------------------------------|
| Event creation        | OOP principles (encapsulation, inheritance), Factory pattern |
| Registration management | Collections Framework, Streams, Functional Interfaces |
| Real-time analytics   | Streams API, Multithreading, Virtual Threads         |
| Data validation       | Pattern Matching (Switch), Functional Interfaces     |
| Export to CSV/JSON    | Java I/O, Functional Programming                     |
| Concurrency handling  | Multithreading, Virtual Threads                      |

## Example Workflow
1. **Start Console Application**:
   - Display menu with options: Create Event, Register User, View Analytics, Export Data.
2. **Event Creation**:
   - User inputs event details (validated using pattern matching).
   - Event object is created using the Factory and Builder patterns.
3. **Registration**:
   - User selects an event and provides registration details (validated using pattern matching).
   - Registration is handled with Virtual Threads to avoid blocking.
4. **View Analytics**:
   - Analytics generated using streams are displayed in real time.
5. **Export Data**:
   - Event and registration details are written to CSV/JSON files using Java I/O.

## Technologies Used
- **Java 21**: Core programming language with advanced features like Virtual Threads and Pattern Matching.
- **JUnit**: Unit testing framework for validating functionality.
- **Maven/Gradle**: Dependency and build management.
- **Collections and Streams**: Efficient data processing.
- **Multithreading**: For handling concurrency with Virtual Threads.


## Contribution
Contributions are welcome! Feel free to fork the repository and submit a pull request with your changes.

## License
This project is licensed under the MIT License. See the `LICENSE` file for details.
