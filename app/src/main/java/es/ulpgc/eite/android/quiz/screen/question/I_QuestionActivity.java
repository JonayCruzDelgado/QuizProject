package es.ulpgc.eite.android.quiz.screen.question;

/**
 * Created by Jcruz on 04/02/2017.
 */
public interface I_QuestionActivity {
    boolean isAnswerVisible();

    void setAnswerVisibility(boolean visible);

    boolean isAnswerBtnClicked();

    void setAnswerBtnClicked(boolean clicked);

    void checkAnswerVisibility();

    //metodos de la vista.
    void hideAnswer();

    void hideToolbar();

    void setAnswer(String text);

    void setCheatButton(String label);

    void setFalseButton(String label);

    void setNextButton(String label);

    void setQuestion(String text);

    void setTrueButton(String label);

    void showAnswer();
}
