 Vehicle Trip Management System

 Project Description
This is a Java-based Object-Oriented Programming project that simulates a vehicle trip management system with comprehensive exception handling. The system allows users to:

- Create different types of vehicles (Buses and Taxis) with dynamic input validation
- Register drivers with license number validation
- Add passengers to the system
- Assign vehicles to drivers with null checks
- Create and manage trips with status tracking (CREATED → STARTED → COMPLETED/FAILED)
- Process payments for completed trips
- Handle errors gracefully without crashing the program

 Key Features
- Dynamic User Input: Interactive console-based data entry
- Multiple Vehicle Types: 
  - Buses: Simple fare calculation (fare per km × distance)
  - Taxis: Base fare + per-kilometer rate
- Trip Management: Full lifecycle management with status tracking
- Payment Processing: Passengers can make payments for trips
- Exception Handling: Comprehensive error handling for all scenarios
- Input Validation: All user inputs are validated before processing

 Exceptions Implemented

 1. NumberFormatException
Location: `Main.java` - Throughout all user input sections

When triggered:
- User enters text instead of numbers for:
  - Vehicle capacity
  - Fare amounts (fare per km, base fare, rate per km)
  - Trip distances
  - Menu choices

How it's handled:
`java
try {
    int capacity = Integer.parseInt(scanner.nextLine());
} catch (NumberFormatException e) {
    System.err.println("Invalid number format. Using default values.");
    // Falls back to default values to continue program execution
}
