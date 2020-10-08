package com.roqua;


import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlayerFragment extends BaseFragment {

    String path, name, type;
    MediaPlayer mp = new MediaPlayer();

    Player player;
    boolean play = false;
    @BindView(R.id.player_tv_surah_name)
    TextView playerTvSurahName;
    @BindView(R.id.btn_share)
    ImageView btnShare;
    @BindView(R.id.btn_rate)
    ImageView btnRate;
    @BindView(R.id.playr_ivpreview)
    ImageView playrIvpreview;
    @BindView(R.id.player_sbprogress)
    SeekBar playerSbprogress;
    @BindView(R.id.tv_timefrom)
    TextView tvTimefrom;
    @BindView(R.id.tv_timeto)
    TextView tvTimeto;
    @BindView(R.id.d)
    RelativeLayout d;
    @BindView(R.id.player_btnplay)
    Button playerBtnplay;
    @BindView(R.id.player_btn_pause)
    ImageView playerBtnPause;
    @BindView(R.id.rel1)
    RelativeLayout rel1;
    @BindView(R.id.adView_1)
    AdView adView1;
    @BindView(R.id.adView)
    AdView adView;
    @BindView(R.id.pprogressBar)
    ProgressBar pprogressBar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_player, container, false);
        ButterKnife.bind(this, root);
        playerTvSurahName.setText(name + "\n" + type);
        player = new Player();


        setUpActivity();

        player.start();
        playerSbprogress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
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


        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);


        AdRequest adRequest_1 = new AdRequest.Builder().build();
        adView1.loadAd(adRequest_1);


        pprogressBar.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                pprogressBar.setVisibility(View.GONE);

            }
        }, 5000);


        return root;
    }


    @OnClick({R.id.btn_share, R.id.btn_rate, R.id.player_btnplay, R.id.player_btn_pause})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_share:
                try {
                    final String appPackageName = getActivity().getPackageName();
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "الرقيه الشرعيه");
                    String shareMessage ="شارك التطبيق مع اصدقائك";
                    shareMessage = shareMessage + " https://play.google.com/store/apps/details?id=" + appPackageName;
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, getActivity().getString(R.string.app_name)));
                } catch (Exception e) {
                    //e.toString();
                }
                break;
            case R.id.btn_rate:
                Intent ratingIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?" + "id=com.roqua"));
                getActivity().startActivity(ratingIntent);
                break;
            case R.id.player_btnplay:

                if (!mp.isPlaying()) {
                    mp.start();
                    playerBtnplay.setBackgroundResource(R.drawable.img_btn_pause_pressed);

                } else if (mp.isPlaying()) {
                    mp.pause();
                    playerBtnplay.setBackgroundResource(R.drawable.img_btn_play_pressed);


                }

                break;

            case R.id.player_btn_pause:
                if (mp.isPlaying()) {
                    mp.pause();
                }
        }
    }


    class Player extends Thread {


        @Override
        public void run() {
            try {
                mp.stop();
                mp.reset();
                mp.setDataSource(path);
                try {

                    mp.prepare();
                } catch (Exception e) {
                }
                playerSbprogress.setMax(mp.getDuration());

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
                        playerSbprogress.setProgress(mp.getCurrentPosition());
                        SoundTime();
                    }
                });
            }
        }
    }


    @Override
    public void onBack() {
        super.onBack();
        mp.stop();
    }

    public void notifyData(String s) {
        Intent i = new Intent();
        i.setAction("com.medo.roquia");
        i.putExtra("path", s);
        getActivity().sendBroadcast(i);
    }





    private void SoundTime() {
        playerSbprogress.setMax(mp.getDuration());
        int tim = (playerSbprogress.getMax() / 1000);
        int m = tim / 60;
        int s = tim % 60;
        //////
        int tim0 = (playerSbprogress.getProgress() / 1000);
        int m0 = tim0 / 60;
        int s0 = tim0 % 60;

        tvTimeto.setText(s + ":" + m);
        tvTimefrom.setText(s0 + ":" + m0);
    }

}
