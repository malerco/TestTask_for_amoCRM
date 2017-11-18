package ru.malerco.amocrm.models.leads;

import java.util.List;

public class LeadsAndStatusModel {
    private List<Lead> leads;
    private List<LeadsStatus> leadsStatus;

    public LeadsAndStatusModel(List<Lead> leads, List<LeadsStatus> leadsStatus) {
        this.leads = leads;
        this.leadsStatus = leadsStatus;
    }

    public LeadsAndStatusModel() {
    }

    public List<Lead> getLeads() {
        return this.leads;
    }

    public void setLeads(List<Lead> leads) {
        this.leads = leads;
    }

    public List<LeadsStatus> getLeadsStatus() {
        return this.leadsStatus;
    }

    public void setLeadsStatus(List<LeadsStatus> leadsStatus) {
        this.leadsStatus = leadsStatus;
    }
}


