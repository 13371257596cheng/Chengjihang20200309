package com.bawei.chengjihang.model;

import com.bawei.chengjihang.contret.IHomeContert;
import com.bawei.chengjihang.uitils.Volleys;

public class HomeModel implements IHomeContert.IModel {
    @Override
    public void getJson(String url, final Callback callback) {
        Volleys.getVolley().doGet(url, new Volleys.Callback() {
            @Override
            public void getSuccess(String json) {
                callback.getSuccess(json);
            }

            @Override
            public void Errey(String str) {
                callback.getError(str);
            }
        });

    }
}
