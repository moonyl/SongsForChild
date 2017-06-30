package hu.pe.moony.songsformydaughter;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by 이상문 on 2016-09-20.
 */
public class AudioPlayer {
    private MediaPlayer mPlayer;
    private int mRawId;

    public static AudioPlayer createAudioPlayer(int rawId) {
        AudioPlayer player = new AudioPlayer();
        player.mRawId = rawId;
        return player;
    }

    public void stop() {
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }

    public void play(Context c) {
        stop();
        mPlayer = MediaPlayer.create(c, mRawId);

        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                stop();
            }
        });

        mPlayer.start();
    }
}
