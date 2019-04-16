public class Grade implements Comparable<Grade> {
    private String student;
    private double grade;

    Grade(String student, double grade) {
        // TODO constructor that sets the student and grade fields
        this.student = student;
        this.grade = grade;
    }

    public String toLetterGrade() {
        // TODO return the letter grade corresponding to the grade field
        // >= 90 is a A, 80-89 B, 70-79 C, 60-69 D, < 60 F
        if (grade >= 90) {
            return "A";
        } else if (grade >= 80) {
            return "B";
        } else if (grade >= 70) {
            return "C";
        } else if (grade >= 60) {
            return "D";
        }
        return "F";
    }

    public String getStudent() {
        // TODO getter for the student field
        return this.student;
    }

    public double getGrade() {
        // TODO getter for the grade field
        return this.grade;
    }

    public String toString() {
        // TODO return a useful representation of the object, including the name and grade fields
        return this.student +": " + this.grade;
    }

//    @Override
    public int compareTo(Grade other) {
        // TODO implement compareTo.
        // Don't forget anything else that might be missing in this class for this function to be called correctly.
        if (this.grade == other.getGrade()) {
            return 0;
        } else if (this.grade > other.getGrade()) {
            return 1;
        }
        return -1;
    }

}