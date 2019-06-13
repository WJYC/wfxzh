package com.qianfeng.vip.po;

public class OrderInfo {

    private String orderId;
    private String buyerPhone;
    private String goodId;
    private String orderTime;
    private String channelId;
    private String state;
    private String buyNum;
    private String province;
    private String city;
    private String area;
    private String buyerReamrk;
    private String payType;
    private String buyerName;
    private String skuId;
    private String address;

    public OrderInfo() {
    }

    public OrderInfo(String orderId, String buyerPhone, String goodId, String orderTime, String channelId, String state, String buyNum, String province, String city, String area, String buyerReamrk, String payType, String buyerName, String skuId, String address) {
        this.orderId = orderId;
        this.buyerPhone = buyerPhone;
        this.goodId = goodId;
        this.orderTime = orderTime;
        this.channelId = channelId;
        this.state = state;
        this.buyNum = buyNum;
        this.province = province;
        this.city = city;
        this.area = area;
        this.buyerReamrk = buyerReamrk;
        this.payType = payType;
        this.buyerName = buyerName;
        this.skuId = skuId;
        this.address = address;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(String buyNum) {
        this.buyNum = buyNum;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBuyerReamrk() {
        return buyerReamrk;
    }

    public void setBuyerReamrk(String buyerReamrk) {
        this.buyerReamrk = buyerReamrk;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
