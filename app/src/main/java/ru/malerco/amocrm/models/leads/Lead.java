package ru.malerco.amocrm.models.leads;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Lead {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("date_create")
    @Expose
    private Integer dateCreate;
    @SerializedName("created_user_id")
    @Expose
    private String createdUserId;
    @SerializedName("last_modified")
    @Expose
    private Integer lastModified;
    @SerializedName("account_id")
    @Expose
    private String accountId;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("responsible_user_id")
    @Expose
    private String responsibleUserId;
    @SerializedName("linked_company_id")
    @Expose
    private String linkedCompanyId;
    @SerializedName("group_id")
    @Expose
    private Integer groupId;
    @SerializedName("pipeline_id")
    @Expose
    private Integer pipelineId;
    @SerializedName("date_close")
    @Expose
    private Integer dateClose;
    @SerializedName("closest_task")
    @Expose
    private Integer closestTask;
    @SerializedName("deleted")
    @Expose
    private Integer deleted;
    @SerializedName("tags")
    @Expose
    private List<Object> tags = null;
    @SerializedName("status_id")
    @Expose
    private String statusId;
    @SerializedName("custom_fields")
    @Expose
    private List<Object> customFields = null;

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

    public Integer getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Integer dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(String createdUserId) {
        this.createdUserId = createdUserId;
    }

    public Integer getLastModified() {
        return lastModified;
    }

    public void setLastModified(Integer lastModified) {
        this.lastModified = lastModified;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getResponsibleUserId() {
        return responsibleUserId;
    }

    public void setResponsibleUserId(String responsibleUserId) {
        this.responsibleUserId = responsibleUserId;
    }

    public String getLinkedCompanyId() {
        return linkedCompanyId;
    }

    public void setLinkedCompanyId(String linkedCompanyId) {
        this.linkedCompanyId = linkedCompanyId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getPipelineId() {
        return pipelineId;
    }

    public void setPipelineId(Integer pipelineId) {
        this.pipelineId = pipelineId;
    }

    public Integer getDateClose() {
        return dateClose;
    }

    public void setDateClose(Integer dateClose) {
        this.dateClose = dateClose;
    }

    public Integer getClosestTask() {
        return closestTask;
    }

    public void setClosestTask(Integer closestTask) {
        this.closestTask = closestTask;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public List<Object> getTags() {
        return tags;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public List<Object> getCustomFields() {
        return customFields;
    }

    public void setCustomFields(List<Object> customFields) {
        this.customFields = customFields;
    }

}
