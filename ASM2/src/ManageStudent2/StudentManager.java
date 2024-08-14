package ManageStudent2;
import java.util.Scanner;
public class StudentManager {
    private final Student[] students;
    private int size;
    public StudentManager(int capacity) {
        students = new Student[capacity];
        size = 0;
    }
    public void addStudent(int id, String fullName, double marks) {
        if (size >= students.length) {
            System.out.println("Cannot add more students. Capacity full.");
            return;
        }
        students[size++] = new Student(id, fullName, marks);
    }
    public void editStudent(int id, String fullName, double marks) {
        for (int i = 0; i < size; i++) {
            if (students[i].getId() == id) {
                students[i].setFullName(fullName);
                students[i].setMarks(marks);
                return;
            }
        }
        System.out.println("Student not found.");
    }
    public void deleteStudent(int id) {
        for (int i = 0; i < size; i++) {
            if (students[i].getId() == id) {
                students[i] = students[--size];
                return;
            }
        }
        System.out.println("Student not found.");
    }
    //insertionSort
    public void insertionSort() {
        for (int i = 1; i < size; i++) {
            Student key = students[i];
            int j = i - 1;
            while (j >= 0 && students[j].getId() > key.getId()) {
                students[j + 1] = students[j];
                j = j - 1;
            }
            students[j + 1] = key;
        }
    }
    
    //selectionSort
    public void selectionSort() {
    for (int i = 0; i < size - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < size; j++) {
            if (students[j].getMarks() < students[minIndex].getMarks()) {
                minIndex = j;
            }
        }
        // Swap the found minimum element with the first element
        Student temp = students[minIndex];
        students[minIndex] = students[i];
        students[i] = temp;
        }
    }

    //tim kiem nhi phan
    public void binarySearch(int id) {
        int left = 0;
        int right = size - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (students[mid].getId() == id) {
                students[mid].display();
                return;
            }
            if (students[mid].getId() < id) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("Student not found.");
    }
    
    //tim kiem tuyen tinh
    public void searchById(int id) {
    for (int i = 0; i < size; i++) {
        if (students[i].getId() == id) {
            students[i].display();
            return;
        }
    }
        System.out.println("Student with ID '" + id + "' not found.");
    }


    public void displayAllStudents() {
        for (int i = 0; i < size; i++) {
            students[i].display();
        }
    }
    public static void main(String[] args) {
        StudentManager manager = new StudentManager(100);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Sort Students");
            System.out.println("5. Search Student");
            System.out.println("6. Display All Students");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Full Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = scanner.nextDouble();
                    manager.addStudent(id, name, marks);
                    break;
                case 2:
                    System.out.print("Enter ID of student to edit: ");
                    int editId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Full Name: ");
                    String editName = scanner.nextLine();
                    System.out.print("Enter New Marks: ");
                    double editMarks = scanner.nextDouble();
                    manager.editStudent(editId, editName, editMarks);
                    break;
                case 3:
                    System.out.print("Enter ID of student to delete: ");
                    int deleteId = scanner.nextInt();
                    manager.deleteStudent(deleteId);
                    break;
                case 4:
                    manager.insertionSort();
                    break;
                case 5:
                    System.out.print("Enter ID of student to search: ");
                    int searchId = scanner.nextInt();
                    manager.binarySearch(searchId);
                    break;
                case 6:
                    manager.displayAllStudents();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
