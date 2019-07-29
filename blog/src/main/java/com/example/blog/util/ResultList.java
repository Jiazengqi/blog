package com.example.blog.util;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Map;

public class ResultList {

    private String status="200";

    private String msg;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object obj;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List list;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map map;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
