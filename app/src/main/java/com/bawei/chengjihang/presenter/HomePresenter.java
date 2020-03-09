package com.bawei.chengjihang.presenter;

import android.util.Log;

import com.bawei.chengjihang.base.BasePresenter;
import com.bawei.chengjihang.base.IBaseView;
import com.bawei.chengjihang.contret.IHomeContert;
import com.bawei.chengjihang.model.HomeModel;

public class HomePresenter extends BasePresenter implements IHomeContert.IPresenter {

    private HomeModel model;

    public HomePresenter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void getModel() {
        model = new HomeModel();
    }

    @Override
    public void initJson(String url) {
        model.getJson(url, new IHomeContert.IModel.Callback() {
            @Override
            public void getSuccess(String json) {
                IBaseView view=getView();
                if (view!=null&&view instanceof IHomeContert.IView){
                    Log.i("xxx",""+json);
                    IHomeContert.IView iView= (IHomeContert.IView) view;
                    iView.getSuccess(json);
                }
            }

            @Override
            public void getError(String str) {
                IBaseView view=getView();
                if (view!=null&&view instanceof IHomeContert.IView){
                    IHomeContert.IView iView= (IHomeContert.IView) view;
                    iView.getError(str);
                }
            }
        });



    }

    @Override
    public void initSousuo(String url) {
        Log.i("ooo","P层");

        model.getJson(url, new IHomeContert.IModel.Callback() {
            @Override
            public void getSuccess(String json) {
                IBaseView view=getView();
                if (view!=null&&view instanceof IHomeContert.IView){
                    Log.i("xxx",""+json);
                    IHomeContert.IView iView= (IHomeContert.IView) view;
                    iView.getSuccess(json);
                }
            }

            @Override
            public void getError(String str) {

            }
        });
    }
}
