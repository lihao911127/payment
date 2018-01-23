package com.gomefinance.promotion.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by zong on 2017/5/4.
 */
public class GoodsCheckApiDto implements Serializable {
    private static final long serialVersionUID = -3221912482455358272L;
    /**
     * 商品编码
     */
    private String goodsCode;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 件数
     */
    private Integer count;

    /**
     * 最大件数
     */
    private Integer maxCount;
    /**
     * 活动code
     */
    private String activityCode;
    /**
     * 活动名字
     */
    private String activityName;
    /**
     * 是否3C  Y -是3c  N - 不是3c
     */
    private String isThreeCorridors;
    /**
     * 二级品类
     */
    private String categoryCode;
    /**
     * 品牌编码
     */
    private String brandCode;

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(Integer maxCount) {
        this.maxCount = maxCount;
    }

    public String getActivityCode() {
        return activityCode;
    }

    public void setActivityCode(String activityCode) {
        this.activityCode = activityCode;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getIsThreeCorridors() {
        return isThreeCorridors;
    }

    public void setIsThreeCorridors(String isThreeCorridors) {
        this.isThreeCorridors = isThreeCorridors;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    @Override
    public String toString() {
        return "GoodsCheckApiDto{" +
                "goodsCode='" + goodsCode + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", count=" + count +
                ", maxCount=" + maxCount +
                ", activityCode='" + activityCode + '\'' +
                ", activityName='" + activityName + '\'' +
                ", isThreeCorridors='" + isThreeCorridors + '\'' +
                ", categoryCode='" + categoryCode + '\'' +
                ", brandCode='" + brandCode + '\'' +
                '}';
    }
}
