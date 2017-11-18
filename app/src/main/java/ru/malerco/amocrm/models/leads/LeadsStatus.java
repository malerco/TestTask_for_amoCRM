package ru.malerco.amocrm.models.leads;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LeadsStatus {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("pipeline_id")
    @Expose
    private Integer pipelineId;
    @SerializedName("sort")
    @Expose
    private String sort;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("editable")
    @Expose
    private String editable;

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

    public Integer getPipelineId() {
        return pipelineId;
    }

    public void setPipelineId(Integer pipelineId) {
        this.pipelineId = pipelineId;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEditable() {
        return editable;
    }

    public void setEditable(String editable) {
        this.editable = editable;
    }

}
