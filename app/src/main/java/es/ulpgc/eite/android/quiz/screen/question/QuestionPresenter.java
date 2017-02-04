package es.ulpgc.eite.android.quiz.screen.question;

import es.ulpgc.eite.android.quiz.QuestionStore;

/**
 * Created by Jcruz on 04/02/2017.
 */

public class QuestionPresenter {
    QuestionStore myQuestionStore;
    I_QuestionActivity myQuestionActivity;

    public QuestionPresenter(){
        myQuestionStore = new QuestionStore();
    }

    public I_QuestionActivity getMyQuestionActivity() {
        return myQuestionActivity;
    }

    public void setMyQuestionActivity(I_QuestionActivity myQuestionActivity) {
        this.myQuestionActivity = myQuestionActivity;
    }

    public void onAnswerBtnClicked(boolean answer) {
        getQuestionStore().setCurrentAnswer(answer);
        myQuestionActivity.setAnswer(getQuestionStore().getCurrentAnswer());
        myQuestionActivity.setAnswerVisibility(true);
        myQuestionActivity.setAnswerBtnClicked(true);
        myQuestionActivity.checkAnswerVisibility();
    }
    public void setButtonLabels(){
        myQuestionActivity.setTrueButton(getQuestionStore().getTrueLabel());
        myQuestionActivity.setFalseButton(getQuestionStore().getFalseLabel());
        myQuestionActivity.setCheatButton(getQuestionStore().getCheatLabel());
        myQuestionActivity.setNextButton(getQuestionStore().getNextLabel());
    }
    private QuestionStore getQuestionStore() {
        return myQuestionStore;
    }
    public void onNextBtnClicked(){
        myQuestionActivity.setQuestion(getQuestionStore().getNextQuestion());
    }
    public void start() {
        myQuestionActivity.setQuestion(getQuestionStore().getCurrentQuestion());
        if (myQuestionActivity.isAnswerBtnClicked()) {
            myQuestionActivity.setAnswer(getQuestionStore().getCurrentAnswer());
        }
    }

}
