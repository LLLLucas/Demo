package com.lucas.pojo;

public class Datetime {
    private Integer id;

    private String datetime;
    //自己加的属性
    private Integer weekid;
    

    public Integer getWeekid() {
		return weekid;
	}

	public void setWeekid(Integer weekid) {
		this.weekid = weekid;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime == null ? null : datetime.trim();
    }
}