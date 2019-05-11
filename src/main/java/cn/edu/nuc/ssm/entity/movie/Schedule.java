package cn.edu.nuc.ssm.entity.movie;

import cn.edu.nuc.ssm.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class Schedule {
    private String scheduleid;

    private String moveid;

    private String hallid;

    private String price;

    private String time;

    private String colum1;

    private String colum2;

    private String colum3;

    private String colum4;

    private String colum5;

    private Movie movie;

    private Hall hall;

    private List<HallSet> hallSetList;

    public List<HallSet> getHallSetList() {
        return hallSetList;
    }

    public void setHallSetList(List<HallSet> hallSetList) {
        this.hallSetList = hallSetList;
    }

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
        List<HallSet> hallSetList = new ArrayList<>();
        try{
            String[] hasSelect;
            if(StringUtil.isNotEmpty(colum3)){
                hasSelect = colum3.split("-");
            }else {
                hasSelect = new String[1];
            }
            Integer num = Integer.parseInt(hall.getHallsetnum());
            for(int i = 1;i<num+1;i++){
                HallSet hallSet = new HallSet();
                hallSet.setNum(String.valueOf(i));
                boolean isSelect = false;
                if(StringUtil.isNotEmpty(colum3)){
                    for (String select : hasSelect){
                        if(select.equals(hallSet.getNum())){
                            isSelect = true;break;
                        }
                    }
                }
                hallSet.setIsSelect(isSelect);
                hallSetList.add(hallSet);
            }
            int sumNum = 1;
            for(int i=1;i<=num;i++){
                if(i*i>=num){
                    num = i;
                    break;
                }
                this.colum4 = String.valueOf(sumNum);
            }
        }catch (Exception e){
            //e.
        }
        this.hallSetList = hallSetList;
    }

    public String getScheduleid() {
        return scheduleid;
    }

    public void setScheduleid(String scheduleid) {
        this.scheduleid = scheduleid == null ? null : scheduleid.trim();
    }

    public String getMoveid() {
        return moveid;
    }

    public void setMoveid(String moveid) {
        this.moveid = moveid == null ? null : moveid.trim();
    }

    public String getHallid() {
        return hallid;
    }

    public void setHallid(String hallid) {
        this.hallid = hallid == null ? null : hallid.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
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
        return colum3 == null ? "" : colum3.trim();
    }

    public void setColum3(String colum3) {
        this.colum3 = colum3 == null ? "" : colum3.trim();
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