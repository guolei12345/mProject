package cn.edu.nuc.ssm.entity.movie;

public class Pic {
    private String picid;

    private String picurl;

    private String colum1;

    private String colum2;

    private String colum3;

    private String colum4;

    private String colum5;

    public String getPicid() {
        return picid;
    }

    public void setPicid(String picid) {
        this.picid = picid == null ? null : picid.trim();
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl == null ? null : picurl.trim();
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
}