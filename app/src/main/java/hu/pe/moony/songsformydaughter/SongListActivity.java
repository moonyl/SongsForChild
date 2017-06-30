package hu.pe.moony.songsformydaughter;

import android.app.Fragment;

/**
 * Created by 이상문 on 2016-09-19.
 */
public class SongListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {

        return new SongListFragment();
    }
}
