package com.baizhi.entity;

public class FileParm {
    private String oldName;
    private String url;

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public FileParm(String oldName, String url) {
        this.oldName = oldName;
        this.url = url;
    }

    public FileParm() {
    }

    @Override
    public String toString() {
        return "FileParm{" +
                "oldName='" + oldName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
