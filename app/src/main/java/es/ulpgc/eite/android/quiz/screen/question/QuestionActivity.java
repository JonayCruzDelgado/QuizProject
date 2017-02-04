package es.ulpgc.eite.android.quiz.screen.question;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.ulpgc.eite.android.quiz.screen.cheat.CheatActivity;
import es.ulpgc.eite.android.quiz.QuestionStore;
import es.ulpgc.eite.android.quiz.R;

public class QuestionActivity extends AppCompatActivity  implements I_QuestionActivity{


  private boolean toolbarVisible;
  private boolean answerVisible;
  private boolean answerBtnClicked;

  private Toolbar toolbarScreen;
  private Button buttonTrue, buttonFalse, buttonCheat, buttonNext;
  private TextView labelQuestion, labelAnswer;
  //private QuizApp quizApp;
  private QuestionPresenter myQuestionPresenter;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_question);


    labelQuestion = (TextView) findViewById(R.id.labelQuestion);
    labelAnswer = (TextView) findViewById(R.id.labelAnswer);

    toolbarScreen = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbarScreen);

    myQuestionPresenter = new QuestionPresenter();
    myQuestionPresenter.setMyQuestionActivity(this);
    buttonTrue = (Button) findViewById(R.id.buttonTrue);
    buttonTrue.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
          onTrueBtnClicked();
      }
    });
    buttonFalse = (Button) findViewById(R.id.buttonFalse);
    buttonFalse.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        onFalseBtnClicked();
      }
    });
    buttonCheat = (Button) findViewById(R.id.buttonCheat);
    buttonCheat.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        onCheatBtnClicked();
      }
    });
    buttonNext = (Button) findViewById(R.id.buttonNext);
    buttonNext.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        onNextBtnClicked();
      }
    });

    onScreenStarted();

  }

  private void onScreenStarted() {
    //quizApp = (QuizApp) getApplication();

    myQuestionPresenter.setButtonLabels();
    checkVisibility();
    myQuestionPresenter.start();

  }




  private void onCheatBtnClicked() {
    goToCheatScreen();
  }

  private void onFalseBtnClicked() {
    myQuestionPresenter.onAnswerBtnClicked(false);
  }

  private void onNextBtnClicked(){
    myQuestionPresenter.onNextBtnClicked();
  }

  private void onTrueBtnClicked() {
    myQuestionPresenter.onAnswerBtnClicked(true);
  }

  @Override
  public boolean isAnswerVisible() {
    return answerVisible;
  }

  private boolean isToolbarVisible() {
    return toolbarVisible;
  }
  @Override
  public void setAnswerVisibility(boolean visible) {
    answerVisible = visible;
  }
  @Override
  public boolean isAnswerBtnClicked() {
    return answerBtnClicked;
  }
  @Override
  public void setAnswerBtnClicked(boolean clicked) {
    answerBtnClicked = clicked;
  }

  /*
  private boolean isAnswerBtnClicked() {
    return quizApp.isAnswerBtnClicked();
  }

  private void setAnswerBtnClicked(boolean clicked) {
    quizApp.setAnswerBtnClicked(clicked);
  }

  private QuestionStore getQuestionStore() {
    return quizApp.getQuestionStore();
  }

  private boolean isToolbarVisible() {
    return quizApp.isToolbarVisible();
  }

  private void setAnswerVisibility(boolean visible) {
    quizApp.setAnswerVisibility(visible);
  }

  private boolean isAnswerVisible() {
    return quizApp.isAnswerVisible();
  }
  */

  private void goToCheatScreen(){
    startActivity(new Intent(this, CheatActivity.class));
    //quizApp.goToCheatScreen(this);
  }
 @Override
 public void checkAnswerVisibility(){
    if(!isAnswerVisible()) {
      hideAnswer();
    } else {
      showAnswer();
    }
  }

  private void checkToolbarVisibility(){
    if (!isToolbarVisible()) {
      hideToolbar();
    }
  }


  private void checkVisibility(){
    checkToolbarVisibility();
    checkAnswerVisibility();
  }

//metodos de la vista.
  @Override
  public void hideAnswer() {
    labelAnswer.setVisibility(View.INVISIBLE);
  }
  @Override
  public void hideToolbar() {
    toolbarScreen.setVisibility(View.GONE);
  }
  @Override
  public void setAnswer(String text) {
    labelAnswer.setText(text);
  }
  @Override
  public void setCheatButton(String label) {
    buttonCheat.setText(label);
  }
  @Override
  public void setFalseButton(String label) {
    buttonFalse.setText(label);
  }
  @Override
  public void setNextButton(String label) {
    buttonNext.setText(label);
  }
  @Override
  public void setQuestion(String text) {
    labelQuestion.setText(text);
  }
  @Override
  public void setTrueButton(String label) {
    buttonTrue.setText(label);
  }
  @Override
  public void showAnswer() {
    labelAnswer.setVisibility(View.VISIBLE);
  }


}
