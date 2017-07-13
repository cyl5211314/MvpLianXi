package com.example.lenovo.mvplianxi.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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
 * 创建时间：2017/7/10 19:56
 */

public class Lvadap extends BaseAdapter{
    private Context context;
    private List<Data.DataBean.ComicsBean> list=new ArrayList<>();

    private View view;

    public void initDatalist(List<Data.DataBean.ComicsBean> data){
        if (list!=null&&data.size()>0){
            list.addAll(data);
            Log.e("TAG", "initDatalist: "+data.toString() );
        }
    }
    public Lvadap(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder lv = null;
        if (convertView==null){
            lv=new ViewHolder();
            convertView = convertView.inflate(context, R.layout.rv,null);
            lv.tv1= (TextView) convertView.findViewById(R.id.tv1);
            lv.im = (ImageView) convertView.findViewById(R.id.im);
            convertView.setTag(lv);
        }else{
            lv= (ViewHolder) convertView.getTag();
        }
        lv.tv1.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getCover_image_url()).into(lv.im);
        return convertView;
    }
    class ViewHolder {
        TextView tv1;
        ImageView im;
    }
}
