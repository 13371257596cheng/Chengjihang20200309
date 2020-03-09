package com.bawei.chengjihang.contret;

import com.bawei.chengjihang.base.IBaseView;

public interface IHomeContert {
    interface  IView extends IBaseView{
        void getSuccess(String json);
        void getError(String str);
        void getSousuo(String json);
    }
    interface IPresenter{
        void initJson(String url);
        void initSousuo(String url);
    }
    interface IModel{
        void getJson(String url,Callback callback);
        interface Callback{
            void getSuccess(String json);
            void getError(String str);
        }
    }
}
