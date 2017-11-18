package ru.malerco.amocrm.main;

import java.util.List;

import ru.malerco.amocrm.models.leads.Lead;
import ru.malerco.amocrm.models.leads.LeadsAndStatusModel;


public interface MainView {
    void showProgress();

    void hideProgress();

    void onLoadError();

    void onSuccessLoad(LeadsAndStatusModel zipModel);
}
