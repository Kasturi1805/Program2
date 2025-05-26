import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Student {
    private String name;
    private LocalDate dob;

    public Student(String name, String dobInput) {
        this.name = name;
        this.dob = parseDate(dobInput);
    }

    private LocalDate parseDate(String input) {
        DateTimeFormatter[] formats = {
            DateTimeFormatter.ofPattern("dd-MM-yyyy"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd")
        };

        for (DateTimeFormatter formatter : formats) {
            try {
                return LocalDate.parse(input, formatter);
            } catch (Exception e) {
                // Try next format
            }
        }

        throw new IllegalArgumentException("Invalid date format. Use DD-MM-YYYY or YYYY-MM-DD.");
    }

    public void displayInfo() {
        LocalDate today = LocalDate.now();
        int age = Period.between(dob, today).getYears();
        System.out.println("Student Name: " + name);
        System.out.println("Age: " + age + " years");
    }

    // Test via main
    public static void main(String[] args) {
        // Hardcoded values for testing
        Student student = new Student("Kasturi", "15-08-2002");
        student.displayInfo();
    }
}
