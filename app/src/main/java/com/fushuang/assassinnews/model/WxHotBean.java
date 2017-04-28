package com.fushuang.assassinnews.model;

import java.util.List;

/**
 * Created by fushuang on 2017/4/25.
 */

public class WxHotBean {

    private int code;
    private String msg;
    private List<WXItemBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<WXItemBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<WXItemBean> newslist) {
        this.newslist = newslist;
    }

}
