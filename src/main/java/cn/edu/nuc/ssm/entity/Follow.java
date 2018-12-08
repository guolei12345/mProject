package cn.edu.nuc.ssm.entity;

import java.util.Date;

public class Follow {
    private Integer fid;

    private Integer aid;

    private Integer followAid;

    private Date ftime;

    private Boolean mutualConcern;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getFollowAid() {
        return followAid;
    }

    public void setFollowAid(Integer followAid) {
        this.followAid = followAid;
    }

    public Date getFtime() {
        return ftime;
    }

    public void setFtime(Date ftime) {
        this.ftime = ftime;
    }

    public Boolean getMutualConcern() {
        return mutualConcern;
    }

    public void setMutualConcern(Boolean mutualConcern) {
        this.mutualConcern = mutualConcern;
    }
}