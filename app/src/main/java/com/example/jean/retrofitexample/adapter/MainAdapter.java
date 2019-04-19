package com.example.jean.retrofitexample.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jean.retrofitexample.R;
import com.example.jean.retrofitexample.model.History;
import com.example.jean.retrofitexample.view.Main2Activity;
import com.example.jean.retrofitexample.view.MainActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>  {
    private List<History> historyList;
    private Context context;
    public MainAdapter(MainActivity mainActivity, List<History> historyList) {
        this.historyList = historyList;
    }
    public void setHistoryList(List<History> historyList) {
        this.historyList = historyList;
    }
    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(parent.getContext())
              .inflate(R.layout.itemplayer,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final  History history = historyList.get(position);
        holder.tvPemain.setText(String.valueOf(historyList.get(position).getNama()));
        holder.tvPemain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Main2Activity.class);
                intent.putExtra("posisi",position);
                context.startActivity(intent);
            }
        });
        Picasso.with(context).load(historyList.get(position).getGambar()).into(holder.imageView);
        Log.d("GAMBAR", "onBindViewHolder: "+historyList.get(position).getGambar());
    }

    @Override
    public int getItemCount() {
       if (historyList!=null){
        return historyList.size();}
        return 0;
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvPemain;
        ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            initView();
        }

        private void initView() {
        tvPemain = (TextView) itemView.findViewById(R.id.namePlayer);
        imageView = (ImageView) itemView.findViewById(R.id.imgPlayer);
        }
    }
}