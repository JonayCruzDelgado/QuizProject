package es.ulpgc.eite.android.quiz.screen.question;

import es.ulpgc.eite.android.quiz.QuestionStore;
import es.ulpgc.eite.android.quiz.QuizApp;

/**
 * Created by Jcruz on 04/02/2017.
 */

public class QuestionPresenter {

    QuizApp quizApp;

    public QuestionPresenter(QuizApp quizApp1){
       quizApp = quizApp1;
    }


    public void onAnswerBtnClicked(boolean answer) {
        getQuestionStore().setCurrentAnswer(answer);
        getQuestionActivity().setAnswer(getQuestionStore().getCurrentAnswer());
        getQuestionActivity().setAnswerVisibility(true);
        getQuestionActivity().setAnswerBtnClicked(true);
        getQuestionActivity().checkAnswerVisibility();
    }
    public void setButtonLabels(){
        getQuestionActivity().setTrueButton(getQuestionStore().getTrueLabel());
        getQuestionActivity().setFalseButton(getQuestionStore().getFalseLabel());
        getQuestionActivity().setCheatButton(getQuestionStore().getCheatLabel());
        getQuestionActivity().setNextButton(getQuestionStore().getNextLabel());
    }
    private QuestionStore getQuestionStore() {
        return quizApp.getQuestionStore();
    }
    public void onNextBtnClicked(){
        getQuestionActivity().setQuestion(getQuestionStore().getNextQuestion());
    }
    public void start() {
        getQuestionActivity().setQuestion(getQuestionStore().getCurrentQuestion());
        if (getQuestionActivity().isAnswerBtnClicked()) {
            getQuestionActivity().setAnswer(getQuestionStore().getCurrentAnswer());
        }
    }
    private QuestionActivity getQuestionActivity(){
        return quizApp.getQuestionActivity();
    }

}
