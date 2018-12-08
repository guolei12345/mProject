package cn.edu.nuc.ssm.entity;

public class Account {
    private Integer aid;

    private String email;

    private String nickName;

    private String password;

    private Integer follow;

    private Integer fans;

    private Integer weibo;

    private String pic;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getFollow() {
        return follow;
    }

    public void setFollow(Integer follow) {
        this.follow = follow;
    }

    public Integer getFans() {
        return fans;
    }

    public void setFans(Integer fans) {
        this.fans = fans;
    }

    public Integer getWeibo() {
        return weibo;
    }

    public void setWeibo(Integer weibo) {
        this.weibo = weibo;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

	@Override
	public String toString() {
		return "Account [aid=" + aid + ", email=" + email + ", nickName=" + nickName + ", password=" + password
				+ ", follow=" + follow + ", fans=" + fans + ", weibo=" + weibo + ", pic=" + pic + "]";
	}
    
    
}