public class Person {
    private String name;
    private String surname;
    private String email;

    // Constructor to initialize a person object with name, surname and email.
    public Person(String _name, String _surname, String _email) {
        set_name(_name);
        set_surname(_surname);
        set_email(_email);
    }

    // Getters and setters
    public String get_name() {
        return name;
    }

    public void set_name(String _name) {
        this.name = _name;
    }

    public String get_surname() {
        return surname;
    }

    public void set_surname(String _surname) {
        this.surname = _surname;
    }

    public String get_email() {
        return email;
    }

    public void set_email(String _email) {
        this.email = _email;
    }

    // Method to print person information
    public void print_info() {
        System.out.println("Name: " + get_name());
        System.out.println("Surname: " + get_surname());
        System.out.println("Email: " + get_email());
    }
}

