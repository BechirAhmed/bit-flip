package com.epicodus.bitflip.services;

import com.epicodus.bitflip.Constants;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by DroAlvarez on 12/1/16.
 */

public class WalmartService {

    public static void findItems(String search, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.API_BASE_URL + Constants.SEARCH_URL_ADDON).newBuilder();
        urlBuilder.addQueryParameter(Constants.SEARCH_QUERY_PARAMETER, search);
        urlBuilder.addQueryParameter(Constants.FORMAT_QUERY_PARAMETER, Constants.FORMAT_QUERY_ANSWER);
        urlBuilder.addQueryParameter(Constants.API_KEY_QUERY_PARAMETER, Constants.API_KEY);
        String url = urlBuilder.build().toString();

        Request request= new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}
