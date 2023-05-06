package com.example.tictactoe348;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    boolean isWinner = false;
    int imageClicked = -1;
    int player = 1;//player 1 is cross
    int[][] winningState = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},{0,4,8},{0,3,6}};
    int[] gameState = {-1, -1, -1, -1, -1, -1, -1, -1, -1};

    public void load(View view)
    {

        ImageView v=(ImageView) view;
        int tag=Integer.parseInt(v.getTag().toString());
        imageClicked=gameState[tag];
        if(!isWinner && imageClicked==-1) {
            if (player == 1) {
                v.setImageResource(R.drawable.cros);
                gameState[tag] = player;
                Toast.makeText(this, tag + "" + " cross", Toast.LENGTH_SHORT).show();
                player = 0;
            } else {
                v.setImageResource(R.drawable.zero);
                gameState[tag] = player;
                Toast.makeText(this, tag + "" + " zero", Toast.LENGTH_SHORT).show();
                player = 1;
            }
            for (int[] ints : winningState) {
                if (gameState[ints[0]] == gameState[ints[1]] && gameState[ints[1]] == gameState[ints[2]] && gameState[ints[0]] > -1) {
                    Toast.makeText(this, "winner is " + (player == 0 ? 1 : 0), Toast.LENGTH_SHORT).show();
                    isWinner = true;
                }
            }
        }
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}