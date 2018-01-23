package com.gomefinance.promotion.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by zong on 2017/5/4.
 */
public class GoodsActivityCheckApiDto implements Serializable {
    private static final long serialVersionUID = -7426933880094446998L;
    /**
     * 商品编码
     */
    private String goodsCode;

    /**
     * 二级品类编码
     */
    private String categoryCode;

    /**
     * 是否3C
     */
    private String isThreeCorridors;
    /**
     * 品牌code
     */
    private String brandCode;

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }


    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
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

    @Override
    public String toString() {
        return "GoodsActivityCheckApiDto{" +
                "goodsCode='" + goodsCode + '\'' +
                ", categoryCode='" + categoryCode + '\'' +
                ", isThreeCorridors='" + isThreeCorridors + '\'' +
                ", brandCode='" + brandCode + '\'' +
                '}';
    }
}
