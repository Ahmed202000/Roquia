package com.roqua;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainFragment extends BaseFragment {
    boolean play = false;
    @BindView(R.id.reting)
    ImageView reting;
    @BindView(R.id.share)
    ImageView share;
    @BindView(R.id.tb)
    Toolbar tb;
    @BindView(R.id.songs_lv)
    ListView songsLv;
    @BindView(R.id.TextStart)
    TextView TextStart;
    @BindView(R.id.TextEnd)
    TextView TextEnd;
    @BindView(R.id.playbtn)
    Button playbtn;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.type)
    TextView type;
    @BindView(R.id.volume)
    SeekBar volume;
    @BindView(R.id.ln)
    RelativeLayout ln;
    @BindView(R.id.adView)
    AdView adView;
    @BindView(R.id.adView_1)
    AdView adView1;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;


    private MediaPlayer mp = new MediaPlayer();
    private Player player;
    private int position;
    private String path;

    ArrayList<AuthorItem> data = new ArrayList<>();
    AuthorAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        ButterKnife.bind(this, v);


        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        AdRequest adRequest_1 = new AdRequest.Builder().build();
        adView1.loadAd(adRequest_1);


        initListView();
        songsLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {

                progressBar.setVisibility(View.VISIBLE  );

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.GONE  );

                    }
                }, 10000);


                view.setSelected(true);
                playbtn.setBackgroundResource(R.drawable.ic_play_arrow_black_24dp);

                mp.stop();
                //  mp.reset();
                player = new Player(data.get(position).getSong_url());
                player.start();
                mp.start();
                name.setText(data.get(position).name);
                type.setText(data.get(position).type);


            }
        });
        volume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser && mp != null) {
                    mp.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });



        return v;
    }

    private void SoundTime() {
        volume.setMax(mp.getDuration());
        int tim = (volume.getMax() / 1000);
        int m = tim / 60;
        int s = tim % 60;
        //////
        int tim0 = (volume.getProgress() / 1000);
        int m0 = tim0 / 60;
        int s0 = tim0 % 60;

        TextEnd.setText(s + " : " + m);
        TextStart.setText(s0 + " : " + m0);
    }

    private void initListView() {
        data.add(new AuthorItem("الرقية الشرعية", "ماهر المعيقلي", R.drawable.maher,
                "https://9wtquran.com/up/uploads/1467172156351.mp3"));

        data.add(new AuthorItem("الرقية الشرعية", "عبد الباسط عبد الصمد", R.drawable.baset,
                "https://www.mboxdrive.com/الرقيه%20الشرعيه%20للحسد%20والسحر%20-%20الشيخ%20عبد%20الباسط%20عبد%20الصمد%20(128%20kbps).mp3"));

        data.add(new AuthorItem("الرقية الشرعية", "فارس عباد", R.drawable.faris,
                "https://www.mboxdrive.com/الرقية%20الشرعية%20للعين%20والحسد%20بصوت%20الشيخ%20فارس%20عباد%20(128%20kbps).mp3"));
        data.add(new AuthorItem("الرقية الشرعية", "خالد الجليل", R.drawable.kaled,
                "https://www.mboxdrive.com/الرقية%20الشرعية%20بصوت%20الشيخ%20خالد%20الجليل%20مؤثرة%20جداااااا%20السحر%20والعين%20والمس%20I%20قناة%20سلطان%20العواد%20(128%20kbps).mp3"));

        data.add(new AuthorItem("الرقية الشرعية", "محمد المحسيني", R.drawable.mhsny,
                "https://www.mboxdrive.com/الرقية%20الشرعية%20للشيخ%20محمد%20المحيسني%20ROQIA%20(128%20kbps).mp3"));


        data.add(new AuthorItem("سوره الحرق", "ماهر المعيقلي", R.drawable.maher,
                "https://www.mboxdrive.com/ايات%20حرق%20وعذاب%20الجن%20بصوت%20الشيخ%20ماهر%20المعيقلى%20(128%20kbps).mp3"));

        data.add(new AuthorItem("سوره الحرق", "عبد الباسط عبد الصمد", R.drawable.baset,
                "https://www.mboxdrive.com/ROQIA%20ROKIA%20%20عبد%20الباسط%20عبد%20الصمد%20الرقيه%20الشرعيه%20ايات%20الحرق%20و%20العذاب%20%20%20%20وايات%20الزقوم%20مكرره%20%20ساعه%20(128%20kbps).mp3"));

        data.add(new AuthorItem("سوره الحرق", "فارس عباد", R.drawable.faris,
                "https://www.mboxdrive.com/الشيخ%20فارس%20عباد.%20آيات%20جهنم%20لحرق%20كل%20شيطان%20عنيد%20(128%20kbps).mp3"));
        data.add(new AuthorItem("سوره الحرق", "خالد الجليل", R.drawable.kaled,
                "https://www.mboxdrive.com/حرق%20الجان%20الأزرق%20بصوت%20الشيخ%20خالد%20الجليل%20(128%20kbps).mp3"));

        data.add(new AuthorItem("سوره الحرق", "محمد المحسيني", R.drawable.mhsny,
                "https://www.mboxdrive.com/الصواعق%20المحرقه%20للجن%20الكفره%20بصوت%20الشيخ%20المحيسني%20(128%20kbps).mp3"));

        adapter = new AuthorAdapter(data, getActivity());
        songsLv.setAdapter(adapter);

    }

    @OnClick({R.id.share, R.id.reting, R.id.playbtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.share:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_SUBJECT, "الرقية الشرعية للشيخ " + name);
                sendIntent.putExtra(Intent.EXTRA_TEXT, path);
                sendIntent.setType("img/plain");
                startActivity(Intent.createChooser(sendIntent, "اختار التطبيق الذي مشاركة النص معه :"));
                break;
            case R.id.reting:
                Intent val_i = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + BuildConfig.APPLICATION_ID));
                startActivity(val_i);
                break;
            case R.id.playbtn:
                if (!mp.isPlaying()) {
                    mp.start();
                    playbtn.setBackgroundResource(R.drawable.ic_pause_black_24dp);

                } else if (mp.isPlaying()) {
                    mp.pause();
                    playbtn.setBackgroundResource(R.drawable.ic_play_arrow_black_24dp);


                }

                break;
        }
    }

    class Player extends Thread {
        String url;

        public Player(String url) {
            this.url = url;
        }

        @Override
        public void run() {
            try {
                mp.setDataSource(url);
                try {

                    mp.prepare();
                    //     mp.start();
                } catch (Exception e) {
                }
                volume.setMax(mp.getDuration());

            } catch (IOException e) {
                e.printStackTrace();
            }
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (getActivity() == null) {
                    return;
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        volume.setProgress(mp.getCurrentPosition());
                        SoundTime();
                    }
                });
            }
        }
    }

    @Override
    public void onBack() {
        mp.stop();
    }
}