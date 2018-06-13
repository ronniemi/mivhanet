package Model;

public class Comment {
    String body;
    Question question;
    StudyWorker writtenBy;

    public Comment(String body, StudyWorker writtenBy) {
        this.body = body;
        this.writtenBy = writtenBy;
    }
}
