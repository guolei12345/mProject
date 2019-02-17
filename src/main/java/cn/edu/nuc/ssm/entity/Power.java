package cn.edu.nuc.ssm.entity;

import java.util.Objects;

public class Power {
    private String powerid;

    private String prapoerid;

    private String powername;

    private String url;

    private String ischeck;

    private String description;

    private String status;

    private String type;

    private String colum1;

    private String colum2;

    private String colum3;

    private String colum4;

    private String colum5;
    private Power parPower;

    public Power getParPower() {
        return parPower;
    }

    public void setParPower(Power parPower) {
        this.parPower = parPower;
    }

    public String getPowerid() {
        return powerid;
    }

    public void setPowerid(String powerid) {
        this.powerid = powerid == null ? null : powerid.trim();
    }

    public String getPrapoerid() {
        return prapoerid;
    }

    public void setPrapoerid(String prapoerid) {
        this.prapoerid = prapoerid == null ? null : prapoerid.trim();
    }

    public String getPowername() {
        return powername;
    }

    public void setPowername(String powername) {
        this.powername = powername == null ? null : powername.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getIscheck() {
        return ischeck;
    }

    public void setIscheck(String ischeck) {
        this.ischeck = ischeck == null ? null : ischeck.trim();
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Power power = (Power) o;
        return powerid.equals(power.powerid);
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getColum1() {
        return colum1;
    }

    public void setColum1(String colum1) {
        this.colum1 = colum1 == null ? null : colum1.trim();
    }

    public String getColum2() {
        return colum2;
    }

    public void setColum2(String colum2) {
        this.colum2 = colum2 == null ? null : colum2.trim();
    }

    public String getColum3() {
        return colum3;
    }

    public void setColum3(String colum3) {
        this.colum3 = colum3 == null ? null : colum3.trim();
    }

    public String getColum4() {
        return colum4;
    }

    public void setColum4(String colum4) {
        this.colum4 = colum4 == null ? null : colum4.trim();
    }

    public String getColum5() {
        return colum5;
    }

    public void setColum5(String colum5) {
        this.colum5 = colum5 == null ? null : colum5.trim();
    }

    @Override
    public String toString() {
        return "Power{" +
                "powerid='" + powerid + '\'' +
                ", prapoerid='" + prapoerid + '\'' +
                ", powername='" + powername + '\'' +
                ", url='" + url + '\'' +
                ", ischeck='" + ischeck + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", colum1='" + colum1 + '\'' +
                ", colum2='" + colum2 + '\'' +
                ", colum3='" + colum3 + '\'' +
                ", colum4='" + colum4 + '\'' +
                ", colum5='" + colum5 + '\'' +
                '}';
    }
}