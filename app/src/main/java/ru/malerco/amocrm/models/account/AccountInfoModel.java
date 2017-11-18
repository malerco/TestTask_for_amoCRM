package ru.malerco.amocrm.models.account;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import ru.malerco.amocrm.models.leads.LeadsStatus;


public class AccountInfoModel {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("subdomain")
    @Expose
    private String subdomain;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("paid_from")
    @Expose
    private Boolean paidFrom;
    @SerializedName("paid_till")
    @Expose
    private Boolean paidTill;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("language")
    @Expose
    private String language;

    @SerializedName("leads_statuses")
    @Expose
    private List<LeadsStatus> leadsStatuses = null;


    public List<LeadsStatus> getLeadsStatuses() {
        return this.leadsStatuses;
    }

    public void setLeadsStatuses(List<LeadsStatus> leadsStatuses) {
        this.leadsStatuses = leadsStatuses;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubdomain() {
        return subdomain;
    }

    public void setSubdomain(String subdomain) {
        this.subdomain = subdomain;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Boolean getPaidFrom() {
        return paidFrom;
    }

    public void setPaidFrom(Boolean paidFrom) {
        this.paidFrom = paidFrom;
    }

    public Boolean getPaidTill() {
        return paidTill;
    }

    public void setPaidTill(Boolean paidTill) {
        this.paidTill = paidTill;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
