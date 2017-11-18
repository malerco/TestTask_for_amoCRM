package ru.malerco.amocrm.login;


public interface LoginPresenter {
    void validateCredentials(String username, String password);

    void onDestroy();
}
