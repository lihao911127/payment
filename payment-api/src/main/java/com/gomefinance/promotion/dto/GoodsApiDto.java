package com.gomefinance.promotion.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by zong on 2017/5/4.
 */
public class GoodsApiDto implements Serializable {
    private static final long serialVersionUID = 6974137865724950092L;
    /**
     * 商品编码
     */
    private String goodsCode;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 二级品类编码
     */
    private String categoryCode;
    /**
     * 件数
     */
    private Integer count;
    /**
     * 首付比例
     */
    private BigDecimal downPaymentRatio;
    /**
     * 是否3C
     */
    private String isThreeCorridors;
    /**
     * 品牌code
     */
    private String brandCode;

    /**
     * 二级品类名称
     */
    private String categoryName;

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

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getDownPaymentRatio() {
        return downPaymentRatio;
    }

    public void setDownPaymentRatio(BigDecimal downPaymentRatio) {
        this.downPaymentRatio = downPaymentRatio;
    }

    public String getIsThreeCorridors() {
        return isThreeCorridors;
    }

    public void setIsThreeCorridors(String isThreeCorridors) {
        this.isThreeCorridors = isThreeCorridors;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "GoodsApiDto{" +
                "goodsCode='" + goodsCode + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", categoryCode='" + categoryCode + '\'' +
                ", count=" + count +
                ", downPaymentRatio=" + downPaymentRatio +
                ", isThreeCorridors='" + isThreeCorridors + '\'' +
                ", brandCode='" + brandCode + '\'' +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
