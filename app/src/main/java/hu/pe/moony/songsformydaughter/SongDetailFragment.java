package hu.pe.moony.songsformydaughter;


import android.os.Bundle;
import android.app.Fragment;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.UUID;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SongDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SongDetailFragment extends Fragment {
    public static final String EXTRA_SONG_ID =
            "hu.pe.moony.songsformaydaughter.song_id";
    private Song mSong;
    private AudioPlayer mPlayer;
    ImageView image;

    public static SongDetailFragment newInstance(UUID songId) {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_SONG_ID, songId);

        SongDetailFragment fragment = new SongDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public SongDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        //UUID songId = (UUID) getActivity().getIntent()
         //       .getSerializableExtra(EXTRA_SONG_ID);
        UUID songId = (UUID) getArguments().getSerializable(EXTRA_SONG_ID);
        mSong = SongLab.get(getActivity()).getSong(songId);
        mPlayer = AudioPlayer.createAudioPlayer(mSong.getRawId());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_song_detail, container, false);

        image = (ImageView) v.findViewById(R.id.song_icon);
        image.setImageResource(mSong.getImgId());

        TextView title = (TextView) v.findViewById(R.id.song_title);
        title.setText(mSong.getTitle());

        Button play = (Button)v.findViewById(R.id.play_button);
        Button stop = (Button)v.findViewById(R.id.stop_button);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation anim = AnimationUtils.loadAnimation(getActivity(), R.anim.rotate);
                image.startAnimation(anim);
            }
        }, 1000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mPlayer.play(getActivity());
            }
        }, 2000);

        play.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Toast.makeText(getActivity(), "play button clicked", Toast.LENGTH_SHORT).show();
                mPlayer.play(getActivity());
            }
        });

        stop.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View view) {
               // Toast.makeText(getActivity(), "stop button clicked", Toast.LENGTH_SHORT).show();
                mPlayer.stop();
            }
        });

        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPlayer.stop();
    }
}
