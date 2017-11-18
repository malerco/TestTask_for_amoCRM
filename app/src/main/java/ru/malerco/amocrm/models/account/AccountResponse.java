package ru.malerco.amocrm.models.account;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccountResponse {

    @SerializedName("account")
    @Expose
    private AccountInfoModel account;
    @SerializedName("server_time")
    @Expose
    private Integer serverTime;

    public AccountInfoModel getAccount() {
        return account;
    }

    public void setAccount(AccountInfoModel account) {
        this.account = account;
    }

    public Integer getServerTime() {
        return serverTime;
    }

    public void setServerTime(Integer serverTime) {
        this.serverTime = serverTime;
    }


}
