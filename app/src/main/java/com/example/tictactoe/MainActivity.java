package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean  gameActivity = true;
    //0 - x
    // 1 - o
    int activeplayer = 0;
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    // state meanings
  /*  0 - x
  1 -o
  2 - Null
   */
int [][] winPositions = {{0,1,2}, {3,4,5}, {6,7,8},{0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};

boolean check = true;
int l = 0;

    public void playertab(View view){

        ImageView img = (ImageView) view;
        int tappedImege = Integer.parseInt(img.getTag().toString());
        if (!gameActivity){
           gameReset (view);
        }

        if(gameState[tappedImege] == 2 ) {
            gameState[tappedImege] = activeplayer;
            img.setTranslationY(-1000f);
            if (activeplayer == 0) {
                img.setImageResource(R.drawable.ox2);
                activeplayer = 1;
                TextView stetus = findViewById(R.id.stetus);
                stetus.setText("O's Turn - Tap to Play");
            } else {
                img.setImageResource(R.drawable.o);
                activeplayer = 0;
                TextView stetus = findViewById(R.id.stetus);
                stetus.setText("X's Turn - Tap to Play");
            }

            img.animate().translationYBy(1000f).setDuration(300);
        }
        // check if any player has won
        for (int[] winPositions: winPositions){
           if (gameState[winPositions[0]] == gameState[winPositions[1]] && gameState[winPositions[1]] == gameState[winPositions[2]] &&
                              gameState[winPositions[0]] != 2){
               // somebody has won! find out who!
               String winnerStr;
               gameActivity = false;

               if(gameState[winPositions[0]] == 0){
                   winnerStr = "X has won";
               }
               else {
                   winnerStr = "O has won";
               }
               // Update the status bar for winner  announcement
               TextView stetus = findViewById(R.id.stetus);
               stetus.setText(winnerStr);

           }
        }
        l++;
        if (l == 9){
            gameActivity = false;


        }
    }

public void Reset (View view){
    Toast.makeText(this, "Reset now .....", Toast.LENGTH_SHORT).show();
    gameReset(view);

}

    public void gameReset(View view){
        gameActivity = true;
        l = 0;
        activeplayer = 0;
        for(int i = 0; i<gameState.length; i++){
            gameState[i] = 2;
        }
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        TextView stetus = findViewById(R.id.stetus);

        stetus.setText("X's Turn - Tap to play");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}