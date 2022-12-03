package entertainments.humanoids;

public interface IMoves {
    String askQuestion(String object);
    String answerQuestion(String question);
    void sitOn(String objectToSit);
    void lieOn(String objectToLie);
    void watchOut(String objectToWatch);
}
