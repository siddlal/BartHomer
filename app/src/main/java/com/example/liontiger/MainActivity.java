package com.example.liontiger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     enum Player {

        ONE, TWO,NO
     }
     Player currentPlayer = Player.ONE;
     Player[] playerChoices = new Player[9];

     int[][] winnerRowsColumns = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playerChoices[0] = Player.NO;
        playerChoices[1] = Player.NO;
        playerChoices[2] = Player.NO;
        playerChoices[3] = Player.NO;
        playerChoices[4] = Player.NO;
        playerChoices[5] = Player.NO;
        playerChoices[6] = Player.NO;
        playerChoices[7] = Player.NO;
        playerChoices[8] = Player.NO;

    }
    public void imageViewIsClicked(View imageView){
        ImageView tappedImageView = (ImageView) imageView;//Important part do look into the video again for this part.
        tappedImageView.setTranslationX(-2000);
        int tiTag = Integer.parseInt(tappedImageView.getTag().toString());
        playerChoices[tiTag] = currentPlayer;   
        if(currentPlayer == Player.ONE) {
            tappedImageView.setImageResource(R.drawable.homer);
            currentPlayer = Player.TWO;
        }
        else if (currentPlayer == Player.TWO){
            tappedImageView.setImageResource(R.drawable.bart);
            currentPlayer = Player.ONE;
        }

        tappedImageView.animate().translationXBy(2000).alpha(1).rotation(3600).setDuration(1000);
        Toast.makeText(this,tappedImageView.getTag().toString(),Toast.LENGTH_SHORT).show();

        for(int[] winnerColumns : winnerRowsColumns){
            if(playerChoices[winnerColumns[0]] == playerChoices[winnerColumns[1]] && playerChoices[winnerColumns[1]] == playerChoices[winnerColumns[2]] && playerChoices[winnerColumns[0]] != Player.NO){
                Toast.makeText(this,"we have a winner",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
