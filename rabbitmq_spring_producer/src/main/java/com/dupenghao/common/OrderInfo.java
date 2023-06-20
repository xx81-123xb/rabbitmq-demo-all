package com.dupenghao.common;

import java.io.Serializable;

/**
 * Created by 杜鹏豪 on 2023/6/7.
 */
public class OrderInfo implements Serializable {
    private String itemId;
    private String userId;
    private int num;
    //描述
    private String desc;

    private static final long serialVersionUID = 100L;

    public OrderInfo() {
    }

    public OrderInfo(String itemId, String userId, int num, String desc) {
        this.itemId = itemId;
        this.userId = userId;
        this.num = num;
        this.desc = desc;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
