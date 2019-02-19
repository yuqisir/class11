package com.itheima.domain;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Product implements Serializable{

  private String id;
  private String productNum;
  private String productName;
  private String cityName;
  private Date departureTime;
  private String departureTimeStr;//处理出行时间
  private Integer productPrice;
  private String productDesc;
  private Integer productStatus;
  private String productStatusStr;//处理订单状态 0 关闭 1 开启

  public String getDepartureTimeStr() {
    if(departureTime!=null){
      departureTimeStr=new SimpleDateFormat("yyyy-MM-dd").format(departureTime);
    }
    return departureTimeStr;
  }

  public void setDepartureTimeStr(String departureTimeStr) {
    this.departureTimeStr = departureTimeStr;
  }

  public String getProductStatusStr() {
    if(productStatus!=null){
      if(productStatus==0){
        productStatusStr="关闭";
      }else if(productStatus==1){
        productStatusStr="开启";
      }
    }
    return productStatusStr;
  }

  public void setProductStatusStr(String productStatusStr) {
    this.productStatusStr = productStatusStr;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getProductNum() {
    return productNum;
  }

  public void setProductNum(String productNum) {
    this.productNum = productNum;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  public Date getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(Date departureTime) {
    this.departureTime = departureTime;
  }

  public Integer getProductPrice() {
    return productPrice;
  }

  public void setProductPrice(Integer productPrice) {
    this.productPrice = productPrice;
  }

  public String getProductDesc() {
    return productDesc;
  }

  public void setProductDesc(String productDesc) {
    this.productDesc = productDesc;
  }

  public Integer getProductStatus() {
    return productStatus;
  }

  public void setProductStatus(Integer productStatus) {
    this.productStatus = productStatus;
  }
}
