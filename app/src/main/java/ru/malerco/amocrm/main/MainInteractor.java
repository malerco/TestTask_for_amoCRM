package ru.malerco.amocrm.main;


import java.util.List;


import ru.malerco.amocrm.models.leads.Lead;
import ru.malerco.amocrm.models.leads.LeadsAndStatusModel;


public interface MainInteractor {
    interface OnMainFinishedListener {
        void onLoadError(String error);

        void onSuccess(LeadsAndStatusModel zipModel);
    }

    void onStartLoad(OnMainFinishedListener listener);
}
