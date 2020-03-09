package com.bawei.chengjihang.base;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends IBaseView> {
    private WeakReference<V> vWeakReference;

    public BasePresenter(V v){
        vWeakReference=new WeakReference<>(v);
        getModel();
    }

    protected abstract void getModel();
    public V getView(){
        if (vWeakReference!=null){
            return vWeakReference.get();
        }
        return null;
    }
}
