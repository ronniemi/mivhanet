import java.util.HashSet;

public class StudentSolution {
    int grade;
    boolean changed;
    HashSet<Option> answers = new HashSet<>(20);
    ExamMoed em;
    Student student;

    public StudentSolution(ExamMoed em, Student student) {
        this.em = em;
        this.student = student;
    }

    public void addOption(Option option){}
    public void updateGrade(int grade){}

    public int getGrade() {
        return grade;
    }
}
