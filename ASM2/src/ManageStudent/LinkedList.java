package ManageStudent;

public class LinkedList {
    Node head;
    public LinkedList() {
        this.head = null;
    }
    public void addStudent(Student student) {
        Node newNode = new Node(student);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    public void editStudent(int id, String name, int age, double marks) {
        Node current = head;
        while (current != null) {
            if (current.data.getStudentID() == id) {
                current.data.setName(name);
                current.data.setAge(age);
                current.data.setMarks(marks);
                return;
            }
            current = current.next;
        }
    }
    public void deleteStudent(int id) {
        if (head == null) {
            return;
        }
        if (head.data.getStudentID() == id) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data.getStudentID() == id) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
    public void displayAllStudents() {
        Node current = head;
         if (current == null) {
            System.out.println("No students found.");
            return;
        }
        while (current != null) {
            System.out.println("ID: " + current.data.getStudentID() + ", Name: " + current.data.getName() +
                               ", Age: " + current.data.getAge() + ", Marks: " + current.data.getMarks() +
                               ", Rank: " + current.data.getRanks());
            current = current.next;
        }
    }
    public void sortStudents() {
        if (head == null || head.next == null) {
            return;
        }
        boolean swapped;
        do {
            Node current = head;
            Node prev = null;
            Node next = head.next;
            swapped = false;
            while (next != null) {
                if (current.data.getMarks() < next.data.getMarks()) {
                    swapped = true;
                    if (prev == null) {
                        Node temp = next.next;
                        next.next = current;
                        current.next = temp;
                        head = next;
                        prev = next;
                    } else {
                        Node temp = next.next;
                        prev.next = next;
                        next.next = current;
                        current.next = temp;
                        prev = next;
                    }
                } else {
                    prev = current;
                    current = next;
                }
                next = current.next;
            }
        } while (swapped);
    }
    public void searchStudent(int id) {
        Node current = head;
        while (current != null) {
            if (current.data.getStudentID() == id) {
                System.out.println("ID: " + current.data.getStudentID() 
                                    + ", Name: " + current.data.getName() 
                                    + ", Age: " + current.data.getAge() 
                                    + ", Marks: " + current.data.getMarks());
                return;
            }
            current = current.next;
        }
        System.out.println("Student not found.");
    }
}

