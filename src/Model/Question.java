package Model;

import java.util.HashSet;

public class Question {
    String id;
    String body;
    int difficulty;
    String time;

    public Question(String id, String body, int difficulty, String time) {
        this.id = id;
        this.body = body;
        this.difficulty = difficulty;
        this.time = time;
    }

    public void addExamMoed(ExamMoed em){};

    public HashSet<Option> getAllOptions() {
        return null;
    }

    public Option getOption(String optionID){return null;}

    public void addOption(Option option){}

    public boolean isInExamMoed(){return false;}

    public StudyWorker getWriter() {
        return null;
    }

    public void editQuestionBody(String questionBody){}

    public void editTime(Long time){}

    public void rankQuestion(int rank){}

    public void addComment(Comment comment){}

    public int getNumberOfComments() {
        return 0;
    }
}
