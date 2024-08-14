package ManageStudent2;
public class Student {
    private final int id;
    private String fullName;
    private double marks;
    private String ranking;

    public Student(int id, String fullName, double marks) {
        this.id = id;
        this.fullName = fullName;
        this.marks = marks;
        this.ranking = Ranking(marks);
    }

    private String Ranking(double marks) {
        if (marks < 5) {
            return "Fail";
        } else if (marks < 6.5) {
            return "Medium";
        } else if (marks < 7.5) {
            return "Good";
        } else if (marks < 9) {
            return "Very good";
        } else {
            return "Excellent";
        }
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public double getMarks() {
        return marks;
    }

    public String getRanking() {
        return ranking;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setMarks(double marks) {
        this.marks = marks;
        this.ranking = Ranking(marks);
    }

    public void display() {
        System.out.println("ID: " + id + ", Full Name: " + fullName + ", Marks: " + marks + ", Ranking: " + ranking);
    }
}

