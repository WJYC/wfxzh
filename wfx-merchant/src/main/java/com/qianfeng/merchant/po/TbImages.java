package com.qianfeng.merchant.po;


public class TbImages {

  private long imageId;
  private String imageUrl;
  private String imageMd5;
  private String fkId;
  private String imageType;

  public long getImageId() {
    return imageId;
  }

  public void setImageId(long imageId) {
    this.imageId = imageId;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getImageMd5() {
    return imageMd5;
  }

  public void setImageMd5(String imageMd5) {
    this.imageMd5 = imageMd5;
  }

  public String getFkId() {
    return fkId;
  }

  public void setFkId(String fkId) {
    this.fkId = fkId;
  }

  public String getImageType() {
    return imageType;
  }

  public void setImageType(String imageType) {
    this.imageType = imageType;
  }
}
