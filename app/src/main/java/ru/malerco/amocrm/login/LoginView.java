package ru.malerco.amocrm.login;

public interface LoginView {
    void showProgress();

    void hideProgress();

    void setEmailError();

    void setLoginError(String error);

    void setPasswordError();

    void navigateToHome();
}
