import java.util.HashSet;

public class Question {
    String id;
    String body;
    int difficulty;
    Long time;
    Course course;
    HashSet<Comment> comments = new HashSet<>(10);
    HashSet<Option> options;
    //HashSet<Score> scores;
    StudyWorker writtenBy;

    public Question(String body, int difficulty, Long time, StudyWorker writtenBy) {
        this.body = body;
        this.difficulty = difficulty;
        this.time = time;
        this.writtenBy = writtenBy;
    }

    public void addExamMoed(ExamMoed em){};

    public HashSet<Option> getAllOptions() {
        return options;
    }

    public Option getOption(String optionID){return null;}

    public void addOption(Option option){}

    public boolean isInExamMoed(){return false;}

    public StudyWorker getWriter() {
        return writtenBy;
    }

    public void editQuestionBody(String questionBody){}

    public void editTime(Long time){}

    public void rankQuestion(int rank){}

    public void addComment(Comment comment){}

    public int getNumberOfComments() {
        return comments.size();
    }
}
