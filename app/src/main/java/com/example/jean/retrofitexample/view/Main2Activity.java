package com.example.jean.retrofitexample.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jean.retrofitexample.R;
import com.example.jean.retrofitexample.model.History;
import com.example.jean.retrofitexample.presenter.Main2Presenter;
import com.example.jean.retrofitexample.view.MainActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Main2Activity extends AppCompatActivity implements Main2View{
    TextView tvNama,tvNoPung,tvDesk;
    ImageView imageView;
    int posisi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent =getIntent();
        posisi =intent.getIntExtra("posisi",0);
        Main2Presenter main2Presenter = new Main2Presenter(this);
        main2Presenter.getDetail();
        tvNama = (TextView) findViewById(R.id.namaPlayerDetail);
        tvNoPung= (TextView) findViewById(R.id.noPunggung);
        tvDesk= (TextView) findViewById(R.id.Deskripsi);
        imageView = (ImageView) findViewById(R.id.imgBigPlayer);
    }

    @Override
    public void updateDetailPlayer(List<History> histories) {
        tvNama.setText(histories.get(posisi).getNama());
        tvNoPung.setText(histories.get(posisi).getNomor());
        tvDesk.setText(histories.get(posisi).getDeskripsi());
            Picasso.with(this).load(histories.get(posisi).getGambar()).into(imageView);

    }
}
