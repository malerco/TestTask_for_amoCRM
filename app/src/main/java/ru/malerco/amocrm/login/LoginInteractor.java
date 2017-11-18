package ru.malerco.amocrm.login;


public interface LoginInteractor {

    interface OnLoginFinishedListener {
        void onUsernameError();

        void onPasswordError();

        void loginError(String error);

        void onSuccess();
    }

    void login(String username, String password, OnLoginFinishedListener listener);

}
