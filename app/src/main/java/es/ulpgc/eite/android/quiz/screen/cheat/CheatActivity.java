package es.ulpgc.eite.android.quiz.screen.cheat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.ulpgc.eite.android.quiz.QuizApp;
import es.ulpgc.eite.android.quiz.R;

public class CheatActivity extends AppCompatActivity {
  private QuizApp quizApp;

  private String falseLabel, trueLabel;
  private String confirmLabel;
  private boolean trueAnswer;

  private Toolbar toolbarScreen;
  private Button buttonTrue, buttonFalse;
  private TextView labelConfirm, labelAnswer;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cheat);

    labelConfirm = (TextView) findViewById(R.id.labelConfirm);
    labelAnswer = (TextView) findViewById(R.id.labelAnswer);

    toolbarScreen = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbarScreen);

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
    
    onScreenStarted();
  }

  private void onScreenStarted() {
    quizApp = (QuizApp) getApplication();
    trueAnswer = quizApp.getQuestionStore().getCurrentBoleeanAnswer();
    falseLabel = "False";
    trueLabel = "True";
    confirmLabel = "Are you sure?";

    setButtonLabels();
    checkVisibility();

    if(quizApp.isAnswerBtnClicked()){
      setAnswer(getAnswer());
    }
  }

  private void onFalseBtnClicked() {
    quizApp.backToQuestionScreen(this);
  }

  private void onTrueBtnClicked() {
    setAnswer(getAnswer());
    setAnswerVisibility(true);
    quizApp.setAnswerCheatVisible(true);
    checkAnswerVisibility();
  }


  private void setAnswerVisibility(boolean visible) {
    quizApp.setAnswerVisibility(visible);
  }

  private boolean isAnswerVisible() {
    return quizApp.isAnswerVisible();
  }

  private boolean isToolbarVisible() {
    return quizApp.isToolbarVisible();
  }


  private void checkAnswerVisibility(){
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


  private void setButtonLabels(){
    setTrueButton(getTrueLabel());
    setFalseButton(getFalseLabel());
    setConfirm(getConfirmLabel());
  }
  
  
  private void hideToolbar() {
    toolbarScreen.setVisibility(View.GONE);
  }

  private void hideAnswer() {
    labelAnswer.setVisibility(View.INVISIBLE);
  }

  private void setAnswer(String txt) {
    labelAnswer.setText(txt);
  }

  private void setConfirm(String text) {
    labelConfirm.setText(text);
  }

  private void setFalseButton(String label) {
    buttonFalse.setText(label);
  }

  private void setTrueButton(String label) {
    buttonTrue.setText(label);
  }

  private void showAnswer() {
    labelAnswer.setVisibility(View.VISIBLE);
  }


  private String getConfirmLabel() {
    return confirmLabel;
  }


  private String getFalseLabel() {
    return falseLabel;
  }


  private String getAnswer() {
    if(trueAnswer) {
      return trueLabel;
    } else {
      return falseLabel;
    }
  }

  private String getTrueLabel() {
    return trueLabel;
  }

  private void setAnswer(boolean answer){
    trueAnswer = answer;
  }
}
