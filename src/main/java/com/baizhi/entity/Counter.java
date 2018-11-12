package com.baizhi.entity;

public class Counter {
    private String id;
    private String title;
    private  String total;
    private  String recordDate;
    private String user_id;
    private String course_id;

    public Counter() {
    }

    public Counter(String id, String title, String total, String recordDate, String user_id, String course_id) {
        this.id = id;
        this.title = title;
        this.total = total;
        this.recordDate = recordDate;
        this.user_id = user_id;
        this.course_id = course_id;
    }

    public Counter(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", total='" + total + '\'' +
                ", recordDate='" + recordDate + '\'' +
                ", user_id='" + user_id + '\'' +
                ", course_id='" + course_id + '\'' +
                '}';
    }
}
