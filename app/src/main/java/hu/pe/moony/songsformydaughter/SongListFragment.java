package hu.pe.moony.songsformydaughter;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SongListFragment extends ListFragment {
    private ArrayList<Song> mSongs;
    public SongListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.list_of_songs);
        mSongs = SongLab.get(getActivity()).getSongs();

        //ArrayAdapter<Song> adapter =
         //       new ArrayAdapter<Song>(getActivity(), android.R.layout.simple_list_item_1, mSongs);
        SongAdapter adapter = new SongAdapter(mSongs);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        //Song s = (Song)(getListAdapter()).getItem(position);
        Song s =  ((SongAdapter)getListAdapter()).getItem(position);
        //Log.d("Song", s.getTitle() + " was clicked");
        Intent i = new Intent(getActivity(), SongDetailActivity.class);
        i.putExtra(SongDetailFragment.EXTRA_SONG_ID, s.getId());
        startActivity(i);
    }

    private class SongAdapter extends ArrayAdapter<Song> {
        public SongAdapter(ArrayList<Song> songs) {
            super(getActivity(), 0, songs);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater()
                        .inflate(R.layout.list_item_song, null);
            }

            Song s = getItem(position);

            TextView title = (TextView)convertView.findViewById(R.id.song_title_list);
            title.setText(s.getTitle());

            ImageView imageIcon = (ImageView)convertView.findViewById(R.id.song_icon_list);
            imageIcon.setImageResource(s.getImgId());

            return convertView;
        }
    }
}
