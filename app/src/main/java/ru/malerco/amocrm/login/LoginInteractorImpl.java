package ru.malerco.amocrm.login;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.malerco.amocrm.ApiClient;
import ru.malerco.amocrm.HttpClient;

import ru.malerco.amocrm.models.account.AccountDataModel;
import ru.malerco.amocrm.models.auth.AuthModel;



public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public void login(final String email, final String hash,  final OnLoginFinishedListener listener) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean error = false;
                if (TextUtils.isEmpty(email) || !email.contains("@") || !email.contains(".")){
                    listener.onUsernameError();
                    error = true;
                    return;
                }
                if (TextUtils.isEmpty(hash)){
                    listener.onPasswordError();
                    error = true;
                    return;
                }

                ApiClient.getInstance()
                        .signIn(email, hash, "json")
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .map(AuthModel::getResponse)
                        .subscribe(auth -> listener.onSuccess(),
                                throwable -> listener.loginError("Failed to login"));

            }
        }, 1000);
    }


}
