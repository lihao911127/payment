package com.gomefinance.promotion.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductApiDto implements Serializable {
    private static final long serialVersionUID = -3339163268116897040L;
    /**
     * 产品代码
     */
    private String productCode;
    /**
     * 产品名字
     */
    private String productName;
    /**
     * 活动代码
     */
    private String activityCode;
//    /**
//     * 上线
//     */
//    private BigDecimal toplimit;
//    /**
//     * 下线
//     */
//    private BigDecimal lowlimit;
//    /**
//     * 订单件数
//     */
//    private Integer orderCount;
//    /**
//     * 订单金额
//     */
//    private BigDecimal orderAmount;
//    /**
//     * 费率
//     */
//    private BigDecimal rate;
    /***
     * "促销费率"
     */
    private String promotionRate;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getActivityCode() {
        return activityCode;
    }

    public void setActivityCode(String activityCode) {
        this.activityCode = activityCode == null ? null : activityCode.trim();
    }

    public String getPromotionRate() {
        return promotionRate;
    }

    public void setPromotionRate(String promotionRate) {
        this.promotionRate = promotionRate;
    }

    @Override
    public int hashCode() {
        return this.getProductCode().hashCode();
    }

    @Override
    public String toString() {
        return "ProductApiDto{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", activityCode='" + activityCode + '\'' +
                ", promotionRate=" + promotionRate +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ProductApiDto) {
            ProductApiDto dto = (ProductApiDto) obj;
            if (this.getProductCode().equals(dto.getProductCode())
                    && this.getProductName().equals(dto.getProductName())
                    && this.getActivityCode().equals(dto.getActivityCode())) {
                return true;
            }
        }
        return false;
    }

}