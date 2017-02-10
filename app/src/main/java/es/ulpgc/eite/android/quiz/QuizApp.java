package es.ulpgc.eite.android.quiz;

import android.app.Application;
import android.content.Intent;

import es.ulpgc.eite.android.quiz.screen.cheat.CheatActivity;
import es.ulpgc.eite.android.quiz.screen.question.QuestionActivity;
import es.ulpgc.eite.android.quiz.screen.question.QuestionPresenter;

public class QuizApp extends Application {

  private QuestionState questionState;
  private CheatState cheatState;
  private QuestionStore questionStore;
  private QuestionPresenter questionPresenter;

  public QuestionActivity getQuestionActivity() {
    return questionActivity;
  }

  public void setQuestionActivity(QuestionActivity questionActivity) {
    this.questionActivity = questionActivity;
  }

  private QuestionActivity questionActivity;
  @Override
  public void onCreate() {
    super.onCreate();
    questionPresenter = new QuestionPresenter(this);
    questionState = new QuestionState();
    questionState.toolbarVisible = false;
    questionState.answerVisible = false;

    questionStore = new QuestionStore();
  }

  public QuestionStore getQuestionStore(){
    return questionStore;
  }

  public boolean isAnswerBtnClicked() {
    return questionState.answerBtnClicked;
  }

  public void setAnswerBtnClicked(boolean clicked) {
    questionState.answerBtnClicked = clicked;
  }

  public boolean isAnswerVisible() {
    return questionState.answerVisible;
  }

  public boolean isToolbarVisible() {
    return questionState.toolbarVisible;
  }

  public void setAnswerVisibility(boolean visible) {
    questionState.answerVisible = visible;
  }

  public void goToCheatScreen(QuestionActivity activity){
    cheatState = new CheatState();
    cheatState.toolbarVisible = false;
    cheatState.answerVisible = false;
    cheatState.answerBtnClicked = questionState.answerBtnClicked;

    activity.startActivity(new Intent(activity, CheatActivity.class));
  }


  public void backToQuestionScreen(CheatActivity activity){
    activity.finish();
  }

  public QuestionPresenter getQuestionPresenter() {
    return questionPresenter;
  }


  private class QuestionState {
    boolean toolbarVisible;
    boolean answerVisible;
    boolean answerBtnClicked;

  }

  private class CheatState {
    boolean toolbarVisible;
    boolean answerVisible;
    boolean answerBtnClicked;
  }
  public boolean isAnswerCheatVisible() {
    return questionState.answerVisible;
  }

  public boolean isToolbarChaeatVisible() {
    return questionState.toolbarVisible;
  }

  public boolean isAnsweCheatBtnClicked() {
    if(cheatState!= null) {
      return cheatState.answerBtnClicked;
    }else{
      return false;
    }
  }
  public void setAnswerCheatVisible(boolean clicked) {

    cheatState.answerVisible = clicked;
  }


}
