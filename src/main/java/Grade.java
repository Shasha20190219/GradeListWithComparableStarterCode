public class Grade implements Comparable<Grade> {
    private String student;
    private double grade;

    Grade(String student, double grade) {
        this.student = student;
        this.grade = grade;
    }

    public String toLetterGrade() {
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
        return this.student;
    }

    public double getGrade() {
        return this.grade;
    }

    public String toString() {
        return this.student +": " + this.grade;
    }

//    @Override
    public int compareTo(Grade other) {
        if (this.grade == other.getGrade()) {
            return 0;
        } else if (this.grade > other.getGrade()) {
            return 1;
        }
        return -1;
    }

}