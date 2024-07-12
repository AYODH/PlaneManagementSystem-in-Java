# Plane Management Application

## Overview

The Plane Management Application is a Java-based system for managing plane seating, ticketing, and customer information. It consists of three main components:

1. `Person.java`: Defines the `Person` class to store customer details.
2. `Ticket.java`: Defines the `Ticket` class to store ticket details, including the seat, price, and customer information.
3. `PlaneManagement.java`: The main application class that manages the seating and ticketing system.

## Components

### Person.java

This class represents a person with the following attributes:
- `name`: The first name of the person.
- `surname`: The surname of the person.
- `email`: The email address of the person.

#### Methods
- **Constructor**: Initializes a new `Person` object.
- **Getters and Setters**: Methods to get and set the `name`, `surname`, and `email` attributes.
- **print_info()**: Prints the person's information.

### Ticket.java

This class represents a ticket with the following attributes:
- `row`: The row of the seat.
- `seat`: The seat number.
- `price`: The price of the ticket.
- `person`: A `Person` object representing the customer.

#### Methods
- **Getters and Setters**: Methods to get and set the `row`, `seat`, `price`, and `person` attributes.
- **print_info()**: Prints the ticket information.

### PlaneManagement.java

This is the main class of the application that manages the plane seating and ticketing. It includes:
- A 2D array to represent the seats.
- An array to store tickets.
- A main method to run the application with a menu-driven interface.

#### Methods
- **initialize_seats()**: Initializes the seating arrangement.
- **buy_seat()**: Allows a user to buy a seat.
- **cancel_seat()**: Allows a user to cancel a seat.
- **find_first_available_seat()**: Finds the first available seat.
- **show_seating_plan()**: Displays the current seating plan.
- **save_seating()**: Saves the seating information.
- **load_seating()**: Loads the seating information.

## How to Run

1. Clone the repository:
   ```sh
   git clone https://github.com/AYODH/PlaneManagementSystem-in-Java

