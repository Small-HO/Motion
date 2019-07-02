package com.shaoyuan.net.processor;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.shaoyuan.net.interfaces.ICallback;
import com.shaoyuan.net.interfaces.IHttpProcessor;

import java.util.Map;

/**
 * Created by small-ho on 2019/7/2 11:17
 * title：Volley网络框架
 */
public class VolleyProcessor implements IHttpProcessor {

    private static final String Tag = "VolleyProcessor";
    private static RequestQueue mRequestQueue = null;

    public VolleyProcessor(Context context) {mRequestQueue = Volley.newRequestQueue(context); }

    @Override
    public void post(String url, Map<String, Object> params, final ICallback callback) {
        StringRequest request =  new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callback.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onFailure(error.toString());
            }
        });
        mRequestQueue.add(request);
    }

    @Override
    public void get(String url, Map<String, Object> params, final ICallback callback) {
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callback.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onFailure(error.toString());
            }
        });
        mRequestQueue.add(request);
    }
}
