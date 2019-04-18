package cn.edu.nuc.ssm.entity.movie;

public class Seat {
    private String seatid;

    private String hallid;

    private String scheduleid;

    private String seatnum;

    private String time;

    private String colum1;

    private String colum2;

    private String colum3;

    private String colum4;

    private String colum5;

    public String getSeatid() {
        return seatid;
    }

    public void setSeatid(String seatid) {
        this.seatid = seatid == null ? null : seatid.trim();
    }

    public String getHallid() {
        return hallid;
    }

    public void setHallid(String hallid) {
        this.hallid = hallid == null ? null : hallid.trim();
    }

    public String getScheduleid() {
        return scheduleid;
    }

    public void setScheduleid(String scheduleid) {
        this.scheduleid = scheduleid == null ? null : scheduleid.trim();
    }

    public String getSeatnum() {
        return seatnum;
    }

    public void setSeatnum(String seatnum) {
        this.seatnum = seatnum == null ? null : seatnum.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
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