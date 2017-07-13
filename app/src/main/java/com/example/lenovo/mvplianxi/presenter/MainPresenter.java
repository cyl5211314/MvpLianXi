package com.example.lenovo.mvplianxi.presenter;

import com.example.lenovo.mvplianxi.modle.net.NetDataCallback;
import com.example.lenovo.mvplianxi.modle.net.OkHttpUtils;
import com.example.lenovo.mvplianxi.view.iview.IMainView;

/**
 * 类描述：
 * 创建人：lenovo
 * 创建时间：2017/7/10 16:30
 */

public class MainPresenter <T>{
    private final OkHttpUtils httpUtils;
    private IMainView miMainView;

    public MainPresenter(IMainView iMainView) {
        this.miMainView = iMainView;
        httpUtils = new OkHttpUtils();
    }

    public void loadDataFromServer(String url,Class<T> t) {
    httpUtils.initData(url, new NetDataCallback<T>(){

        @Override
        public void callback(T o) {
            miMainView.successCallback(o);
        }
        @Override
        public void err(int errCode, String errMsg) {
            miMainView.errCallback(errMsg,500);
        }
    },t);
    }
}
