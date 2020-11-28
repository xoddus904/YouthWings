package com.example.youthwings.server;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConnector {
    final static String URL = "http://studylog.shop:5001/";     // 서버 주소
    final static String TEST_URL = "http://192.168.0.8:5001/";     // 테스트 서버 주소 (사용하지 마삼)

    public static Retrofit createRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(TEST_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Retrofit createRetrofit(Interceptor interceptor) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.interceptors().add(interceptor);
        OkHttpClient client = builder.build();

        return new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

}
