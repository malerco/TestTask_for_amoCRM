package ru.malerco.amocrm.models.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


import ru.malerco.amocrm.models.account.UserModel;

public class Response {

    @SerializedName("auth")
    @Expose
    private Boolean auth;
    @SerializedName("accounts")
    @Expose
    private List<AccountAuthModel> accounts = null;
    @SerializedName("user")
    @Expose
    private UserModel user;
    @SerializedName("server_time")
    @Expose
    private Integer serverTime;

    public Boolean getAuth() {
        return auth;
    }

    public void setAuth(Boolean auth) {
        this.auth = auth;
    }

    public List<AccountAuthModel> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountAuthModel> accounts) {
        this.accounts = accounts;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public Integer getServerTime() {
        return serverTime;
    }

    public void setServerTime(Integer serverTime) {
        this.serverTime = serverTime;
    }

}
