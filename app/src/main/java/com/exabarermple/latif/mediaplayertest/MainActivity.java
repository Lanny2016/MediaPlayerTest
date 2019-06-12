package com.exabarermple.latif.mediaplayertest;

import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

// testing mediaPlayer in android
public class MainActivity extends AppCompatActivity {

    Button play;
    Button pause;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        // creating MediaPlayer object
        mp = MediaPlayer.create ( this,R.raw.music );
        // casting play and pause buttons
        play = (Button)findViewById ( R.id.playButton );
        pause = (Button)findViewById ( R.id.pauseButton );

        // onClickListener for the playButton
        play.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                Log.v ("This activity","playing the mp3............");
                mp.start();
                Toast.makeText ( MainActivity.this,"Playing the audio",Toast.LENGTH_SHORT ).show ();
            }
        } );
        // onClickListener for the pauseButton
        pause.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Log.v ( "This Activity","Pause the sound......." );
                mp.pause ();
                Toast.makeText ( MainActivity.this,"Pausing the audio",Toast.LENGTH_SHORT ).show ();
            }
        } );
    }
}
