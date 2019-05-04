package cn.edu.nuc.ssm.entity.movie;

import cn.edu.nuc.ssm.entity.power.User;

public class UserSchedule {
    private String id;

    private String userid;

    private String scheduleid;

    private String setnum;
//    支付状态
    private String colum1 = "0";

    private String colum2;

    private String colum3;

    private String colum4;

    private String colum5;

    private Schedule schedule;

    private User user;

    private Movie movie;

    private Hall hall;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getScheduleid() {
        return scheduleid;
    }

    public void setScheduleid(String scheduleid) {
        this.scheduleid = scheduleid == null ? null : scheduleid.trim();
    }

    public String getSetnum() {
        return setnum;
    }

    public void setSetnum(String setnum) {
        this.setnum = setnum == null ? null : setnum.trim();
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