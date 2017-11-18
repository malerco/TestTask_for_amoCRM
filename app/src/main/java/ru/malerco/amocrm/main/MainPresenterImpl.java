package ru.malerco.amocrm.main;

import java.util.List;

import ru.malerco.amocrm.login.LoginInteractor;
import ru.malerco.amocrm.login.LoginInteractorImpl;
import ru.malerco.amocrm.login.LoginView;
import ru.malerco.amocrm.models.leads.Lead;
import ru.malerco.amocrm.models.leads.LeadsAndStatusModel;



public class MainPresenterImpl implements MainPresenter, MainInteractor.OnMainFinishedListener{

    private MainView mainView;
    private MainInteractor mainInteractor;

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
        this.mainInteractor = new MainInteractorImpl();
    }

    @Override
    public void onLoadError(String error) {
        if (mainView != null){
            mainView.onLoadError();
            mainView.hideProgress();
        }
    }

    @Override
    public void onSuccess(LeadsAndStatusModel zipModel) {
        if (mainView != null) {
            mainView.onSuccessLoad(zipModel);
            mainView.hideProgress();
        }
    }

    @Override
    public void onLoad() {
        if (mainView != null) {
            mainView.showProgress();
        }
        mainInteractor.onStartLoad(this);

    }

    @Override
    public void onDestroy() {
        mainView = null;
    }
}
