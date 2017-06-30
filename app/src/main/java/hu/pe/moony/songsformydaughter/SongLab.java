package hu.pe.moony.songsformydaughter;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by 이상문 on 2016-09-19.
 */
public class SongLab {
    private ArrayList<Song> mSongs;

    private static SongLab sSongLab;
    private Context mAppContext;

    private SongLab(Context appContext) {
        mAppContext = appContext;
        mSongs = new ArrayList<Song>();
        for (int i = 0; i < songsTitle.length; i++) {
            Song s = new Song();
            s.setTitle(songsTitle[i]);
            s.setImgId(imgIds[i]);
            s.setRawId(rawIds[i]);
            mSongs.add(s);
        }
    }

    public static SongLab get(Context c) {
        if (sSongLab == null) {
            sSongLab = new SongLab(c.getApplicationContext());
        }
        return sSongLab;
    }

    public ArrayList<Song> getSongs() {
        return mSongs;
    }

    public Song getSong(UUID id) {
        for (Song s : mSongs) {
            if (s.getId().equals(id))
                return s;
        }
        return null;
    }

    String[] songsTitle = {
            "숨바꼭질",
            "빗방울",
            "우리 또 만나요",
            "웃음",
            "코끼리와 거미",
            "그대로 멈춰라",
            "싹트네",
            "씨앗"
    };

    Integer[] imgIds = {
            R.drawable.hidenseek,
            R.drawable.raindrop,
            R.drawable.meetagain,
            R.drawable.smile,
            R.drawable.elephantspider,
            R.drawable.stopmotion,
            R.drawable.springup,
            R.drawable.seed
    };

    Integer[] rawIds = {
            R.raw.hidenseek,
            R.raw.raindrop,
            R.raw.meetagain,
            R.raw.smile,
            R.raw.elephantspider,
            R.raw.stopmotion,
            R.raw.springup,
            R.raw.seed
    };
}
