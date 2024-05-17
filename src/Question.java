public class Question {
    private String question;
    private String rightAnswer;
    private double rightAnswerNum;
    private boolean rightAnswerBool;
    // private String userAnswer;
    private ScoreChanger score;
    
    
    //Constructor
    public Question(String newQuestion, String corrAnswerStr, ScoreChanger myScore) {
        question = newQuestion;
        rightAnswer = corrAnswerStr;
        score = myScore;
    }
    public Question(String newQuestion, double corrAnswerNum, ScoreChanger myScore) {
        question = newQuestion;
        rightAnswerNum = corrAnswerNum;
        score = myScore;
    }
    
    public String wordTrue(String input){
        if (input.equalsIgnoreCase(rightAnswer)) {
            score.value++;
            return "Correct!";
        }
        else{
            return "Incorrect";
        }
    }
    public String boolTrue(boolean input){
        if (input == rightAnswerBool) {
            score.value++;
            return "Correct!";
        }
        else{
            return "Incorrect";
        }
    }
    
    public String numberTrue(double input){
        if (input == rightAnswerNum) {
            score.value++;
            return "Correct!";
        }
        else{
            return "Incorrect";
        }
    }
    
    public String toString() {
        return question + "? ";
    }
}