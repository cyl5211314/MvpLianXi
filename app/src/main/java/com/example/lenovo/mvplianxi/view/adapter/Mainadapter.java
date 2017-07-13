package com.example.lenovo.mvplianxi.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.mvplianxi.R;
import com.example.lenovo.mvplianxi.modle.bean.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：
 * 创建人：lenovo
 * 创建时间：2017/7/10 17:22
 */

public class Mainadapter extends RecyclerView.Adapter<Mainadapter.ViewHolder>{
    private Context context;
    private List<Data.DataBean.ComicsBean> list=new ArrayList<>();
    private View view;
    private ViewHolder viewHolder;

    public Mainadapter(Context context) {
        this.context = context;
    }

    public void initDatalist(Data data){
        List<Data.DataBean.ComicsBean> comics = data.getData().getComics();
        if (list!=null&&comics.size()>0){
            list.addAll(data.getData().getComics());
            notifyDataSetChanged();
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.rv2,null);
        viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv1.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getCover_image_url()).into(holder.pv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv1;
        private ImageView pv;
        public ViewHolder(View itemView) {
            super(itemView);
            tv1 = (TextView) itemView.findViewById(R.id.tv2);
            pv = (ImageView) itemView.findViewById(R.id.pv);
        }
    }
}
