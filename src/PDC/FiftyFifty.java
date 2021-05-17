package PDC;

public class FiftyFifty {
    boolean canUseFiftyFifty;

    public FiftyFifty() {
        this.canUseFiftyFifty = true;
    }

    public boolean isCanUseFiftyFifty() {
        return canUseFiftyFifty;
    }

    public void setCanUseFiftyFifty(boolean canUseFiftyFifty) {
        this.canUseFiftyFifty = canUseFiftyFifty;
    }

    public void useFiftyFifty(Question question){
        if (isCanUseFiftyFifty()){
            String correctAnswer = question.getCorrectAnswer();

            if (correctAnswer.equals("A") || correctAnswer.equals("B")){

            }
            else if (correctAnswer.equals("C") || correctAnswer.equals("D")){

            }



        }

    }
}
