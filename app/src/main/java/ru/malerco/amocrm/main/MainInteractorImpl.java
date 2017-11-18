package ru.malerco.amocrm.main;

import android.os.Handler;
import android.text.TextUtils;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ru.malerco.amocrm.ApiClient;

import ru.malerco.amocrm.models.account.AccountDataModel;
import ru.malerco.amocrm.models.auth.AuthModel;
import ru.malerco.amocrm.models.leads.LeadsAndStatusModel;
import ru.malerco.amocrm.models.leads.LeadsModel;


public class MainInteractorImpl implements MainInteractor {
    @Override
    public void onStartLoad(OnMainFinishedListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean error = false;
                Observable.zip(ApiClient.getInstance().getLeads(), ApiClient.getInstance().getCurrentAccountData(),
                        (lead, account) ->  new LeadsAndStatusModel(lead.getResponse().getLeads(), account.getResponse().getAccount().getLeadsStatuses()))
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(zipModel -> listener.onSuccess(zipModel),
                                throwable -> listener.onLoadError("Loading error"));

            }
        }, 1000);
    }
}
