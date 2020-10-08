package com.roqua;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.home_gv_authors_list)
    RecyclerView homeGvAuthorsList;
    ArrayList<AuthorsItem> list;
    AuthorsAdapter adapter;
    AdView madView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme2);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        addAuthors();


        madView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        madView.loadAd(adRequest);

    }

    private void addAuthors() {
        homeGvAuthorsList.setLayoutManager(new LinearLayoutManager(HomeActivity.this));
        list=new ArrayList<>();
        list.add(new AuthorsItem(R.drawable.baset , "الشيخ عبد الباسط" ,
                "https://firebasestorage.googleapis.com/v0/b/demoapp-803e5.appspot.com/o/%D8%A7%D9%84%D8%B1%D9%82%D9%8A%D9%87%20%D8%A7%D9%84%D8%B4%D8%B1%D8%B9%D9%8A%D9%87%20%D9%84%D9%84%D8%AD%D8%B3%D8%AF%20%D9%88%D8%A7%D9%84%D8%B3%D8%AD%D8%B1%20-%20%D8%A7%D9%84%D8%B4%D9%8A%D8%AE%20%D8%B9%D8%A8%D8%AF%20%D8%A7%D9%84%D8%A8%D8%A7%D8%B3%D8%B7%20%D8%B9%D8%A8%D8%AF%20%D8%A7%D9%84%D8%B5%D9%85%D8%AF%20(128%20kbps).mp3?alt=media&token=cc70aca3-8352-4cd0-9e4e-9775f5065fb6" ,
                "https://firebasestorage.googleapis.com/v0/b/demoapp-803e5.appspot.com/o/ROQIA%20ROKIA%20%20%D8%B9%D8%A8%D8%AF%20%D8%A7%D9%84%D8%A8%D8%A7%D8%B3%D8%B7%20%D8%B9%D8%A8%D8%AF%20%D8%A7%D9%84%D8%B5%D9%85%D8%AF%20%D8%A7%D9%84%D8%B1%D9%82%D9%8A%D9%87%20%D8%A7%D9%84%D8%B4%D8%B1%D8%B9%D9%8A%D9%87%20%D8%A7%D9%8A%D8%A7%D8%AA%20%D8%A7%D9%84%D8%AD%D8%B1%D9%82%20%D9%88%20%D8%A7%D9%84%D8%B9%D8%B0%D8%A7%D8%A8%20%20%20%20%D9%88%D8%A7%D9%8A%D8%A7%D8%AA%20%D8%A7%D9%84%D8%B2%D9%82%D9%88%D9%85%20%D9%85%D9%83%D8%B1%D8%B1%D9%87%20%20%D8%B3%D8%A7%D8%B9%D9%87%20(128%20kbps).mp3?alt=media&token=9a477574-a090-40e9-a61c-6969fdc7c9fa"));
        list.add(new AuthorsItem(R.drawable.maher , "الشيخ ماهر المعيقلي" ,
                "https://firebasestorage.googleapis.com/v0/b/demoapp-803e5.appspot.com/o/%D8%A3%D9%82%D9%88%D9%89%20%D8%B1%D9%82%D9%8A%D8%A9%20%D8%B4%D8%B1%D8%B9%D9%8A%D8%A9%20%D9%83%D8%A7%D9%85%D9%84%D9%87%23%20%D9%88%D8%AA%D8%AD%D8%AF%D9%89%23%20%D8%A7%D9%84%D8%B4%D9%8A%D8%AE%20%D9%85%D8%A7%D9%87%D8%B1%20%D8%A7%D9%84%D9%85%D8%B9%D9%8A%D9%82%D9%84%D9%8A%20%D8%B9%D9%84%D8%A7%D8%AC%20%D8%A7%D9%84%D8%AD%D8%B3%D8%AF%20%D9%88%20%D8%A7%D9%84%D8%B3%D8%AD%D8%B1%D9%88%20%D8%A7%D9%84%D9%87%D9%85%20%D9%88%D8%A7%D9%84%D8%BA%D9%85%20%D9%88%D8%A7%D9%84%D8%B6%D9%8A%D9%82%20incantation%20(128%20kbps).mp3?alt=media&token=1656e9e6-548a-46a1-844c-dc4a5c71c993" ,
                "https://firebasestorage.googleapis.com/v0/b/demoapp-803e5.appspot.com/o/%D8%A7%D9%8A%D8%A7%D8%AA%20%D8%AD%D8%B1%D9%82%20%D9%88%D8%B9%D8%B0%D8%A7%D8%A8%20%D8%A7%D9%84%D8%AC%D9%86%20%D8%A8%D8%B5%D9%88%D8%AA%20%D8%A7%D9%84%D8%B4%D9%8A%D8%AE%20%D9%85%D8%A7%D9%87%D8%B1%20%D8%A7%D9%84%D9%85%D8%B9%D9%8A%D9%82%D9%84%D9%89%20(128%20kbps).mp3?alt=media&token=46ab74d3-e269-47ee-b941-3dc573663ea6"));
        list.add(new AuthorsItem(R.drawable.faris , "الشيخ فارس عباد" ,
                "https://firebasestorage.googleapis.com/v0/b/demoapp-803e5.appspot.com/o/%D8%A7%D9%84%D8%B1%D9%82%D9%8A%D8%A9%20%D8%A7%D9%84%D8%B4%D8%B1%D8%B9%D9%8A%D8%A9%20%D9%84%D9%84%D8%B9%D9%8A%D9%86%20%D9%88%D8%A7%D9%84%D8%AD%D8%B3%D8%AF%20%D8%A8%D8%B5%D9%88%D8%AA%20%D8%A7%D9%84%D8%B4%D9%8A%D8%AE%20%D9%81%D8%A7%D8%B1%D8%B3%20%D8%B9%D8%A8%D8%A7%D8%AF%20(128%20kbps).mp3?alt=media&token=2df7dcf0-de0f-46a6-91e9-29c1472daf5d" ,
                "https://firebasestorage.googleapis.com/v0/b/demoapp-803e5.appspot.com/o/%D8%A7%D9%84%D8%B4%D9%8A%D8%AE%20%D9%81%D8%A7%D8%B1%D8%B3%20%D8%B9%D8%A8%D8%A7%D8%AF.%20%D8%A2%D9%8A%D8%A7%D8%AA%20%D8%AC%D9%87%D9%86%D9%85%20%D9%84%D8%AD%D8%B1%D9%82%20%D9%83%D9%84%20%D8%B4%D9%8A%D8%B7%D8%A7%D9%86%20%D8%B9%D9%86%D9%8A%D8%AF%20(128%20kbps).mp3?alt=media&token=fcfae4b5-ab5c-428c-b644-890d5ca89dd5"));
        list.add(new AuthorsItem(R.drawable.kaled , "الشيخ خالد الجليل" ,
                "https://firebasestorage.googleapis.com/v0/b/demoapp-803e5.appspot.com/o/%D8%A7%D9%84%D8%B1%D9%82%D9%8A%D8%A9%20%D8%A7%D9%84%D8%B4%D8%B1%D8%B9%D9%8A%D8%A9%20%D8%A8%D8%B5%D9%88%D8%AA%20%D8%A7%D9%84%D8%B4%D9%8A%D8%AE%20%D8%AE%D8%A7%D9%84%D8%AF%20%D8%A7%D9%84%D8%AC%D9%84%D9%8A%D9%84%20%D9%85%D8%A4%D8%AB%D8%B1%D8%A9%20%D8%AC%D8%AF%D8%A7%D8%A7%D8%A7%D8%A7%D8%A7%D8%A7%20%D8%A7%D9%84%D8%B3%D8%AD%D8%B1%20%D9%88%D8%A7%D9%84%D8%B9%D9%8A%D9%86%20%D9%88%D8%A7%D9%84%D9%85%D8%B3%20I%20%D9%82%D9%86%D8%A7%D8%A9%20%D8%B3%D9%84%D8%B7%D8%A7%D9%86%20%D8%A7%D9%84%D8%B9%D9%88%D8%A7%D8%AF%20(128%20kbps).mp3?alt=media&token=0d367e3b-43aa-4ff0-a182-610b2701422b" ,
                "https://firebasestorage.googleapis.com/v0/b/demoapp-803e5.appspot.com/o/%D8%AD%D8%B1%D9%82%20%D8%A7%D9%84%D8%AC%D8%A7%D9%86%20%D8%A7%D9%84%D8%A3%D8%B2%D8%B1%D9%82%20%D8%A8%D8%B5%D9%88%D8%AA%20%D8%A7%D9%84%D8%B4%D9%8A%D8%AE%20%D8%AE%D8%A7%D9%84%D8%AF%20%D8%A7%D9%84%D8%AC%D9%84%D9%8A%D9%84%20(128%20kbps).mp3?alt=media&token=69a9d073-29bd-4c7d-be1c-aa4152f87cb4"));
        list.add(new AuthorsItem(R.drawable.mhsny , "الشيخ محمد المحيسني" ,
                "https://firebasestorage.googleapis.com/v0/b/demoapp-803e5.appspot.com/o/%D8%A7%D9%84%D8%B1%D9%82%D9%8A%D8%A9%20%D8%A7%D9%84%D8%B4%D8%B1%D8%B9%D9%8A%D8%A9%20%D9%84%D9%84%D8%B4%D9%8A%D8%AE%20%D9%85%D8%AD%D9%85%D8%AF%20%D8%A7%D9%84%D9%85%D8%AD%D9%8A%D8%B3%D9%86%D9%8A%20ROQIA%20(128%20kbps).mp3?alt=media&token=9fef8b23-4b41-4422-8e35-761cf2657a79" ,
                "https://firebasestorage.googleapis.com/v0/b/demoapp-803e5.appspot.com/o/%D8%A7%D9%84%D8%B5%D9%88%D8%A7%D8%B9%D9%82%20%D8%A7%D9%84%D9%85%D8%AD%D8%B1%D9%82%D9%87%20%D9%84%D9%84%D8%AC%D9%86%20%D8%A7%D9%84%D9%83%D9%81%D8%B1%D9%87%20%D8%A8%D8%B5%D9%88%D8%AA%20%D8%A7%D9%84%D8%B4%D9%8A%D8%AE%20%D8%A7%D9%84%D9%85%D8%AD%D9%8A%D8%B3%D9%86%D9%8A%20(128%20kbps).mp3?alt=media&token=625d44f7-1ec8-4a27-a388-43141e61ce72"));
        adapter=new AuthorsAdapter(list , HomeActivity.this , HomeActivity.this);
        homeGvAuthorsList.setAdapter(adapter);


    }



    @Override
    public void superBackPressed() {
        super.superBackPressed();
    }
}