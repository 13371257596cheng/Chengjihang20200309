package com.bawei.chengjihang.uitils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.chengjihang.base.App;

import java.io.UnsupportedEncodingException;

public class Volleys {
    private RequestQueue queue;
    private Volleys(){
        queue= Volley.newRequestQueue(App.getContext());
    }
    private static class getUtil{
        private static Volleys volleys=new Volleys();
    }

    public static Volleys getVolley(){
        return getUtil.volleys;
    }
    public Boolean isWifi(Context context){
        ConnectivityManager cm= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info=cm.getActiveNetworkInfo();
        if (info!=null){
            return true;
        }
        return false;
    }
    //GET
    public void doGet(String url, final Callback callback){
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callback.getSuccess(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.Errey(error.getMessage());
            }
        });
        queue.add(stringRequest);
    }
    //doPost
    protected Response<String> parseNetWorkResponse(NetworkResponse response){
        String a;
        try {
            a=new String(response.data,"UTF-8");
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
            a=new String(response.data);
        }
        return Response.success(a, HttpHeaderParser.parseCacheHeaders(response));

    }


    public interface Callback{
        void getSuccess(String json);
        void Errey(String str);
    }

}
