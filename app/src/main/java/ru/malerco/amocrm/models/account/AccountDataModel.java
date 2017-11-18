package ru.malerco.amocrm.models.account;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccountDataModel {

    @SerializedName("response")
    @Expose
    private AccountResponse response;

    public AccountResponse getResponse() {
        return response;
    }

    public void setResponse(AccountResponse response) {
        this.response = response;
    }

}