import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Grades {
    private List<Grade> grades;

    public Grades() {
        grades = new ArrayList<>();
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void readGrades(String fileName) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(fileName));
        while (scan.hasNextLine()) {
            String student = scan.next();
            double grade = scan.nextDouble();
            Grade ele = new Grade(student, grade);
            grades.add(ele);
        }
    }

    public double calcAverage() {
        double total = 0.0;
        for (Grade ele : grades) {
            total += ele.getGrade();
        }
        return total / grades.size();
    }

    public double dropLowest() {
        Grade lowest = grades.get(0);
        double minGrade = lowest.getGrade();
        for (Grade ele : grades) {
            if (ele.getGrade() < minGrade) {
                lowest = ele;
                minGrade = ele.getGrade();
            }
        }
        grades.remove(lowest);
        return minGrade;
    }

   public void addGrade(Grade grade) {
        grades.add(grade);
    }



//    public boolean removeAllGrades(Grade grade) {
//        return grades.removeAll(Collections.singleton(grade));
//    }
    public boolean removeAllGrades(double grade) {
        boolean flag = false;
        for (int i = 0; i < grades.size(); i++) {
            if(grades.get(i).getGrade() == grade) {
                grades.remove(i);
                flag = true;
                i--;

            }
        }
        return flag;
    }

    // Collections.sort sorts the input list as a side-effect, which I didn't prefer
    // So I created a copy and sorted that.
    // You could also just sort grades.
    public void printSortedGrades() {
        List<Grade> gradesCopy = new ArrayList<>(grades);
        Collections.sort(gradesCopy);

        System.out.println(gradesCopy);
    }

    public void printGradeBreakdown() {
        int cntA = 0;
        int cntB = 0;
        int cntC = 0;
        int cntD = 0;
        int cntF = 0;
        for (Grade grade: grades) {
            if (grade.toLetterGrade().equals("A")) {
                cntA++;
            } else if (grade.toLetterGrade().equals("B")) {
                cntB++;
            } else if (grade.toLetterGrade().equals("C")) {
                cntC++;
            } else if (grade.toLetterGrade().equals("D")) {
                cntD++;
            } else if (grade.toLetterGrade().equals("F")) {
                cntF++;
            }
        }
        System.out.println("A: " + cntA + ", B: " + cntB + ", C: " + cntC + ", D: " + cntD + ", F: " + cntF);
    }

    public String getStudentWithHighestGrade() {
        double max = Double.MIN_VALUE;
        String highestStudents = "";
        for (int i = 0; i < grades.size(); i++) {
            if(grades.get(i).getGrade() > max) {
                max = grades.get(i).getGrade();
                highestStudents = grades.get(i).getStudent();
            }
        }
        return highestStudents + max;
    }

    // Simplest version of toString() for this method
    //    public String toString() {
    //        return grades.toString();
    //    }

    // Using StringBuilder rather than less efficient string concatentation
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < grades.size() - 1; i++) {
            result.append(grades.get(i));
            result.append(", ");
        }
        result.append(grades.get(grades.size() - 1));
        result.append("]");

        return result.toString();
    }

}

