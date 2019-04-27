package cn.edu.nuc.ssm.entity.movie;

import java.util.ArrayList;
import java.util.List;

public class Hall {
    private String hallid;

    private String hallheats;

    private String halldescription;

    private String hallsetnum;

    private String colum1;

    private String colum2;

    private String colum3;

    private String colum4;

    private String colum5;

    public String getHallid() {
        return hallid;
    }

    public void setHallid(String hallid) {
        this.hallid = hallid == null ? null : hallid.trim();
    }

    public String getHallheats() {
        return hallheats;
    }

    public void setHallheats(String hallheats) {
        this.hallheats = hallheats == null ? null : hallheats.trim();
    }

    public String getHalldescription() {
        return halldescription;
    }

    public void setHalldescription(String halldescription) {
        this.halldescription = halldescription == null ? null : halldescription.trim();
    }

    public String getHallsetnum() {
        return hallsetnum;
    }

    public void setHallsetnum(String hallsetnum) {
        this.hallsetnum = hallsetnum == null ? null : hallsetnum.trim();
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