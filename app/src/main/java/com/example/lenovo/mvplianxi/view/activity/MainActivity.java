package com.example.lenovo.mvplianxi.view.activity;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;

import com.example.lenovo.mvplianxi.R;
import com.example.lenovo.mvplianxi.modle.bean.Data;
import com.example.lenovo.mvplianxi.presenter.MainPresenter;
import com.example.lenovo.mvplianxi.view.adapter.Lvadap;
import com.example.lenovo.mvplianxi.view.adapter.Mainadapter;
import com.example.lenovo.mvplianxi.view.iview.IMainView;

import java.util.List;

public class MainActivity extends BaseActivity implements IMainView<Data>{

    private String url = "http://api.kkmh.com/v1/daily/comic_lists/0?since=0&gender=0&sa_event=eyJwcm9qZWN0Ijoia3VhaWthbl9hcHAiLCJ0aW1lIjoxNDg3ODI4ODU4NjAwLCJwcm9wZXJ0aWVzIjp7IkhvbWVwYWdlVGFiTmFtZSI6IueDremXqCIsIlZDb21tdW5pdHlUYWJOYW1lIjoi54Ot6ZeoIiwiJG9zX3ZlcnNpb24iOiI0LjIuMiIsIkdlbmRlclR5cGUiOiLlpbPniYgiLCJGcm9tSG9tZXBhZ2VUYWJOYW1lIjoi54Ot6ZeoIiwiJGxpYl92ZXJzaW9uIjoiMS42LjM0IiwiJG5ldHdvcmtfdHlwZSI6IldJRkkiLCIkd2lmaSI6dHJ1ZSwiJG1hbnVmYWN0dXJlciI6InNhbXN1bmciLCJGcm9tSG9tZXBhZ2VVcGRhdGVEYXRlIjowLCIkc2NyZWVuX2hlaWdodCI6NTc2LCJIb21lcGFnZVVwZGF0ZURhdGUiOjAsIlByb3BlcnR5RXZlbnQiOiJSZWFkSG9tZVBhZ2UiLCJGaW5kVGFiTmFtZSI6IuaOqOiNkCIsImFidGVzdF9ncm91cCI6NDYsIiRzY3JlZW5fd2lkdGgiOjEwMjQsIiRvcyI6IkFuZHJvaWQiLCJUcmlnZ2VyUGFnZSI6IkhvbWVQYWdlIiwiJGNhcnJpZXIiOiJDTUNDIiwiJG1vZGVsIjoiR1QtUDUyMTAiLCIkYXBwX3ZlcnNpb24iOiIzLjguMSJ9LCJ0eXBlIjoidHJhY2siLCJkaXN0aW5jdF9pZCI6IkE6OTA1MTA0Mjc2Mzc1NTEwOSIsIm9yaWdpbmFsX2lkIjoiQTo5MDUxMDQyNzYzNzU1MTA5IiwiZXZlbnQiOiJSZWFkSG9tZVBhZ2UifQ%3D%3D";
    private MainPresenter presenter;
    private ListView lv;
    private Lvadap lvadap;
    private RecyclerView rv;
    private Mainadapter mainadapter;
    @Override
    int setContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(){
        //lv = (ListView) findViewById(R.id.lv);
        rv = (RecyclerView) findViewById(R.id.rv);
    }
    @Override
    public void initData() {
        GridLayoutManager manager = new GridLayoutManager(this,3,GridLayoutManager.VERTICAL,false);
       // LinearLayoutManager manager = new LinearLayoutManager(this);
        rv.setLayoutManager(manager);
        presenter = new MainPresenter(this);
        mainadapter = new Mainadapter(this);
        rv.setAdapter(mainadapter);
        //lvadap = new Lvadap(this);
        //lv.setAdapter(lvadap);
        rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }
    @Override
    public void initDataFromServer() {
        presenter.loadDataFromServer(url,Data.class);
    }

    @Override
    public void successCallback(Data data) {
        List<Data.DataBean.ComicsBean> comics = data.getData().getComics();
        Log.e("TAG", "successCallback: "+comics.toString() );
        mainadapter.initDatalist(data);
       // mainadapter.notifyDataSetChanged();
        /*lvadap.initDatalist(comics);
        lvadap.notifyDataSetChanged();*/
    }

    @Override
    public void errCallback(String msg, int code) {
    }
}
