package hu.pe.moony.songsformydaughter;

import android.app.Fragment;

import java.util.UUID;

/**
 * Created by 이상문 on 2016-09-19.
 */
public class SongDetailActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        //return new SongDetailFragment();
        UUID songId = (UUID) getIntent().getSerializableExtra(SongDetailFragment.EXTRA_SONG_ID);
        return SongDetailFragment.newInstance(songId);
    }
}
