package ManageStudent;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentManger {
    private final LinkedList studentList;
    private final Scanner scanner;
    

    public StudentManger() {
        studentList = new LinkedList();
        scanner = new Scanner(System.in);
    }

    public void addStudent() {
        int id = 0;
        String name = "";
        int age = 0;
        double marks = 0.0;

        while (true) {
            try {
                System.out.print("Enter Student ID: ");
                id = scanner.nextInt();
                if (id < 1) {
                    throw new IllegalArgumentException("ID must be larger than 0.");
                }
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                    System.out.print("Enter Student Name: ");
                    name = scanner.nextLine();
                    if (name.trim().isEmpty()) {
                        throw new IllegalArgumentException("Name cannot be empty.");
                    }
                    if (!name.matches("[a-zA-Z\\s]+")) {
                        throw new IllegalArgumentException("Name must only contain letters and spaces.");
                    }
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Enter Age: ");
                age = scanner.nextInt();
                if (age < 16) {
                    throw new IllegalArgumentException("Age must be at least 16.");
                }else if(age > 65){
                    throw new IllegalArgumentException("Invalid age.");
                }
                scanner.nextLine(); // Consume newline
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Age must be an integer.");
                scanner.nextLine(); // Clear the input buffer
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Enter Marks: ");
                marks = scanner.nextDouble();
                if (marks < 0) {
                    throw new IllegalArgumentException("Marks cannot be negative.");
                }else if(marks > 10){
                    throw new IllegalArgumentException("Marks cannot exceed 10.");
                }
                scanner.nextLine(); // Consume newline
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Marks must be a number.");
                scanner.nextLine(); // Clear the input buffer
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        Student student = new Student(id, name, age, marks);
        studentList.addStudent(student);
        System.out.println("Student added successfully.");
    }

    public void editStudent() {
        int id = 0;
        String name = "";
        int age = 0;
        double marks = 0.0;

        while (true) {
            try {
                System.out.print("Enter Student ID to edit: ");
                id = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine(); // Clear the input buffer
            }
        }

        while (true) {
            try {
        System.out.print("Enter New Student Name: ");
        name = scanner.nextLine();
        if (!name.matches("[a-zA-Z\\s]+")) {
            throw new IllegalArgumentException("Name must only contain letters and spaces.");
            }
            break; 
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Enter new Age: ");
                age = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine(); // Clear the input buffer
            }
        }

        while (true) {
            try {
                System.out.print("Enter new Marks: ");
                marks = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the input buffer
            }
        }

        studentList.editStudent(id, name, age, marks);
        System.out.println("Student updated successfully.");
    }

    public void deleteStudent() {
        while (true) {
            try {
                System.out.print("Enter Student ID to delete: ");
                int id = scanner.nextInt();
                studentList.deleteStudent(id);
                System.out.println("Student deleted successfully.");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine(); // Clear the input buffer
            }
        }
    }

    public void displayAllStudents() {
        studentList.displayAllStudents();
    }

    public void sortStudents() {
        studentList.sortStudents();
        System.out.println("Students sorted by marks in descending order.");
        studentList.displayAllStudents();
    }

    public void searchStudent() {
        while (true) {
            try {
                System.out.print("Enter Student ID to search: ");
                int id = scanner.nextInt();
                studentList.searchStudent(id);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine(); // Clear the input buffer
            }
        }
    }

    public static void main(String[] args) {
        StudentManger manager = new StudentManger();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Sort Students");
            System.out.println("6. Search Student");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        manager.addStudent();
                        break;
                    case 2:
                        manager.editStudent();
                        break;
                    case 3:
                        manager.deleteStudent();
                        break;
                    case 4:
                        manager.displayAllStudents();
                        break;
                    case 5:
                        manager.sortStudents();
                        break;
                    case 6:
                        manager.searchStudent();
                        break;
                    case 7:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine(); // Clear the input buffer
            }
        }
    }
}
