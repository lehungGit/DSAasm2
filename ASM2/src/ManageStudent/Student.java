package ManageStudent;
public class Student {
    int StudentID;
    String Name;
    int Age;
    double Marks;

    public Student(int StudentID, String Name, int Age, double Marks) {
        this.StudentID = StudentID;
        this.Name = Name;
        this.Age = Age;
        this.Marks = Marks;
    }
    public String getRanks(){
        if (Marks < 5) {
            return "Fail";
        } else if (Marks < 6.5) {
            return "Medium";
        } else if (Marks < 7.5) {
            return "Good";
        } else if (Marks < 9) {
            return "Very good";
        } else {
            return "Excellent";
        }
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public double getMarks() {
        return Marks;
    }

    public void setMarks(double Marks) {
        this.Marks = Marks;
    }
}
