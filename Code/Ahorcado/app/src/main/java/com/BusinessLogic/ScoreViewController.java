package com.BusinessLogic;

import android.content.Context;

import com.DataAcces.Repositories.UserRepository;
import com.Presentation.ScoreActivity;

public class ScoreViewController {
    Context context;
    UserRepository userRepository;

    public ScoreViewController(Context context) {
        this.context = context;
        userRepository = new UserRepository(context);
    }

    /**
     * Esta funcion llama a UserRepository para encontrar al usuario usando su email.
     * @param email
     */
    public void viewScore(String email) {
        userRepository.getbyEmail("http://ahorcado1d.000webhostapp.com/get_user.php", email, null, 3);
    }

    /**
     * Esta funcion coge la informacion enviada del repositorio, toma el score del usuario y se lo envia a la actividad.
     * @param score
     */
    public void viewScoreAnswer(int score) {
        final ScoreActivity sa = (ScoreActivity) context;
        sa.nuevoIntent(score, context);
    }
}