import java.util.Scanner;

public class PlaneManagement {
    private static final int[][] seats = new int[4][];
    private static final Ticket[] tickets = new Ticket[52];

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Plane Management application!");
        initialize_seats();
        int option;
        while (true) {
            // Initial Display.
            System.out.println();
            System.out.println("*************************************************");
            System.out.println("*               MENU OPTIONS                    *");
            System.out.println("*************************************************");
            System.out.println("1)  Buy a seat");
            System.out.println("2)  Cancel a seat");
            System.out.println("3)  Find first available seat");
            System.out.println("4)  Show seating plane");
            System.out.println("5)  Print tickets information and total sales");
            System.out.println("6)  Search tickets");
            System.out.println("0)  Quit");
            System.out.println("*************************************************");
            System.out.print("Please select an option: "); // Enter an option.

            try {
                option = scanner.nextInt();
                scanner.nextLine();
                System.out.println();
            } catch (Exception e) {
                System.out.println("Please enter the number of the option.");
                scanner.next();
                System.out.println();
                continue;
            }

            switch (option) {
                case 1:
                    buy_seat();
                    break;
                case 2:
                    cancel_seat();
                    break;
                case 3:
                    find_first_available();
                    break;
                case 4:
                    show_seating_plan();
                    break;
                case 5:
                    print_tickets_info();
                    break;
                case 6:
                    search_ticket();
                    break;
                case 0: // Quitting the program.
                    System.out.println("Thank you for using our service. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please select a number from the given menu options.");
            }
        }
    }

    // Initializing the seats
    private static void initialize_seats() {
        seats[0] = new int[14];
        seats[1] = new int[12];
        seats[2] = new int[12];
        seats[3] = new int[14];
    }

    // Getting inputs
    private static int[] row_seat_input() {
        int[] row_and_seat = new int[2];
        while (true) {
            try {
                System.out.print("Please enter a row letter (A, B, C, D): ");
                char row_letter = scanner.next().toUpperCase().charAt(0);

                if (row_letter >= 'A' && row_letter <= 'D') {
                    row_and_seat[0] = row_letter - 'A';

                    System.out.print("Please enter a seat number: ");
                    int seat_num = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character.
                    System.out.println();

                    if (seat_num >= 0 && seat_num <= seats[row_and_seat[0]].length) {
                        row_and_seat[1] = seat_num - 1;
                        break;

                    } else {
                        System.out.println("Invalid seat number.");
                        System.out.println();
                    }

                } else {
                    System.out.println("Invalid row letter.");
                    System.out.println();
                }

            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                System.out.println();
                scanner.next();
            }
        }
        return row_and_seat;
    }

    // Buying a Seat.
    public static void buy_seat() {
        int[] row_and_seat = row_seat_input();
        int row_index = row_and_seat[0];
        int seat_index = row_and_seat[1];

        if (seats[row_index][seat_index] == 1) {
            System.out.println("Seat already sold. Please choose another seat.");
        } else {
            System.out.print("Enter person's name: ");
            String name = scanner.nextLine();
            System.out.print("Enter person's surname: ");
            String surname = scanner.nextLine();
            System.out.print("Enter person's email: ");
            String email = scanner.nextLine();

            // Calculating price based on row and seat number.
            double price;
            if (seat_index >= 0 && seat_index <= 4) {
                price = 200.0;
            } else if (seat_index >= 5 && seat_index <= 8) {
                price = 150.0;
            } else {
                price = 180.0;
            }

            Person person = new Person(name, surname, email);

            Ticket ticket = new Ticket();
            ticket.set_row((char) (row_index + 'A'));
            ticket.set_seat(seat_index + 1);
            ticket.set_price(price);
            ticket.set_person(person);

            tickets[(row_index * seats[row_index].length) + seat_index] = ticket; // Storing tickets in the array.
            seats[row_index][seat_index] = 1; // Marking seat as sold in the seating plan.

            System.out.println("Seat successfully purchased.");
            ticket.save();
        }
    }

    // Cancelling a seat.
    private static void cancel_seat() {
        int[] row_and_seat = row_seat_input();
        int row_index = row_and_seat[0];
        int seat_index = row_and_seat[1];

        if (seats[row_index][seat_index] == 0) {
            System.out.println("Seat is already available.");
        } else {
            seats[row_index][seat_index] = 0; // Marking seat as available in the seating plan.
            tickets[(row_index * seats[row_index].length) + seat_index] = null; // Removing ticket from the array.
            System.out.println("Seat successfully canceled.");
        }
    }

    // Finding first available seat.
    private static void find_first_available() {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] == 0) {
                    char row_letter = (char) ('A' + i);
                    System.out.println("First available seat found at Row " + row_letter + ", Seat " + (j + 1));
                    return;
                }
            }
        }
        System.out.println("No available seats found.");
    }

    // Showing seating plan.
    private static void show_seating_plan() {
        System.out.println("Seating Plan:");
        for (int i = 0; i < seats.length; i++) {
            System.out.print((char) (i + 'A') + ": ");
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] == 0) {
                    System.out.print("O ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    // Printing ticket information.
    private static void print_tickets_info() {
        double total_sales = 0.0;
        System.out.println("Tickets Information:");
        for (Ticket ticket : tickets) {
            if (ticket != null) {
                ticket.print_info();
                System.out.println();
                total_sales += ticket.get_price();
            }

        }
        System.out.println("Total sales: £" + total_sales);
        System.out.println();
    }

    // Searching for a ticket.
    private static void search_ticket() {
        int[] row_and_seat = row_seat_input();
        int row_index = row_and_seat[0];
        int seat_index = row_and_seat[1];

        Ticket ticket = tickets[(row_index * seats[row_index].length) + seat_index];
        if (ticket != null) {
            System.out.println("Ticket found:");
            ticket.print_info();
        } else {
            System.out.println("This seat is available.");
        }
    }
}
