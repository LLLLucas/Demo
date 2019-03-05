package com.lucas.pojo;

public class Yuyue {
    private Integer id;

    private Integer roomid;

    private Integer timeid;

    private Integer dateid;

    private Integer userid;

    private String reason;

    private String zhuangtai;
    //自己定义的属性
    private String roomname;
    private String time;
    private String username;

    
    public String getRoomname() {
		return roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public Integer getTimeid() {
        return timeid;
    }

    public void setTimeid(Integer timeid) {
        this.timeid = timeid;
    }

    public Integer getDateid() {
        return dateid;
    }

    public void setDateid(Integer dateid) {
        this.dateid = dateid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getZhuangtai() {
        return zhuangtai;
    }

    public void setZhuangtai(String zhuangtai) {
        this.zhuangtai = zhuangtai == null ? null : zhuangtai.trim();
    }
}