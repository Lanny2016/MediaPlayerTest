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
    private MediaPlayer mediaPlayer;
    /** below we set the mediaPlayer.setOnCompletionListener as a global object here so that we would not need to create
     * it every time we need it */
    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener () {
        @Override
        public void onCompletion(MediaPlayer mp) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        // creating MediaPlayer object
        mediaPlayer = MediaPlayer.create ( this, R.raw.music );
        // casting play and pause buttons
        play = (Button) findViewById ( R.id.playButton );
        pause = (Button) findViewById ( R.id.pauseButton );
        // onClickListener for the playButton
        play.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                releaseMediaPlayer ();
                mediaPlayer = MediaPlayer.create ( MainActivity.this,R.raw.music );
                 mediaPlayer.start ();
                // Setting up onCompletion message to the mediaPlay, which shows message after the audio file is finished
                mediaPlayer.setOnCompletionListener ( onCompletionListener );


            }
        } );
        // onClickListener for the pauseButton
        pause.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause ();
                Toast.makeText ( MainActivity.this, "Pausing the audio", Toast.LENGTH_SHORT ).show ();
            }

        } );
    }

    @Override
    protected void onStop() {
        super.onStop ();
        releaseMediaPlayer ();
        // when the activity is stopped, release the mediaPlayer
        // because we wont be playing the sound any more
    }
    /** clean up the media player by releasing its resources
     * so we should create a method to do so*/
    public void releaseMediaPlayer() {
            if (mediaPlayer != null) {
                // set the mediaPlayer to null so that the mediaPlayer cant play an audio file at the moment
                mediaPlayer.release ();
                mediaPlayer = null;
            }

    }
}


