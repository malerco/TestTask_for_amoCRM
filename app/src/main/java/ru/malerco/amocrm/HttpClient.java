package ru.malerco.amocrm;

import android.app.Application;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import ru.malerco.amocrm.models.CookieSaver;

public class HttpClient {
    private static OkHttpClient instance;

    private HttpClient (){
    }

    public static OkHttpClient getInstance(){
        if (instance == null){
            instance = provideOkHttpClient();
        }
        return instance;
    }

    static OkHttpClient provideOkHttpClient() {
        return new OkHttpClient
                .Builder()
                .cookieJar(new CookieSaver())
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .build();
    }

}
