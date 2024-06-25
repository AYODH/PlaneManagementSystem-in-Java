import java.io.FileWriter;
import java.io.IOException;

public class Ticket {
    private char row;
    private int seat;
    private double price;
    private Person person;

    // Getter and setter methods.
    public char get_row() {
        return row;
    }

    public void set_row(char Row) {
        this.row = Row;
    }

    public int get_seat() {
        return seat;
    }

    public void set_seat(int Seat) {
        this.seat = Seat;
    }

    public double get_price() {
        return price;
    }

    public void set_price(double Price) {
        this.price = Price;
    }

    public Person get_person() {
        return person;
    }

    public void set_person(Person Person) {
        this.person = Person;
    }

    // Method to print ticket information.
    public void print_info() {
        System.out.println("Row: " + get_row());
        System.out.println("Seat: " + get_seat());
        System.out.println("Price:  £" + get_price());
        System.out.println("Person Information:");
        person.print_info();
    }

    // Method to save ticket information to a file.
    public void save() {
        char row_save = get_row();
        int seat_save = get_seat();
        String file_name = row_save + "" + seat_save + ".txt"; // Generate file name based on row and seat.
        try (FileWriter writer = new FileWriter(file_name)) { // Open file writer.
            writer.write("Ticket Information:\n");
            writer.write("Row: " + row_save + "\n");
            writer.write("Seat: " + seat_save + "\n");
            writer.write("Price: £" + price + "\n");
            writer.write("Person Information:\n");
            writer.write("Name: " + person.get_name() + "\n");
            writer.write("Surname: " + person.get_surname() + "\n");
            writer.write("Email: " + person.get_email() + "\n");
            System.out.println("Ticket information saved to file: " + file_name);
        } catch (IOException e) {
            System.out.println("Error writing ticket information to file: " + e.getMessage());
        }
    }
}

