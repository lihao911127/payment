package com.gomefinance.promotion.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductDetailApiDto implements Serializable {
    private static final long serialVersionUID = -3633306429662737002L;
    /**
     * 分期期数
     */
    private String periods;
    /**
     * 首付比例
     */
    private BigDecimal downPaymentRatio;
    /**
     * 分期金额上限
     */
    private BigDecimal toplimit;
    /**
     * 分期金额下限
     */
    private BigDecimal lowlimit;
    /**
     * 商品总价下限
     */
    private BigDecimal minAmount;
    /**
     * 商品总价上限
     */
    private BigDecimal maxAmount;
    /**
     * 数量
     */
    private Integer orderCount;

    public String getPeriods() {
        return periods;
    }

    public void setPeriods(String periods) {
        this.periods = periods;
    }

    public BigDecimal getDownPaymentRatio() {
        return downPaymentRatio;
    }

    public void setDownPaymentRatio(BigDecimal downPaymentRatio) {
        this.downPaymentRatio = downPaymentRatio;
    }

    public BigDecimal getToplimit() {
        return toplimit;
    }

    public void setToplimit(BigDecimal toplimit) {
        this.toplimit = toplimit;
    }

    public BigDecimal getLowlimit() {
        return lowlimit;
    }

    public void setLowlimit(BigDecimal lowlimit) {
        this.lowlimit = lowlimit;
    }

    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    @Override
    public String toString() {
        return "ProductDetailApiDto{" +
                "periods='" + periods + '\'' +
                ", downPaymentRatio=" + downPaymentRatio +
                ", toplimit=" + toplimit +
                ", lowlimit=" + lowlimit +
                ", minAmount=" + minAmount +
                ", maxAmount=" + maxAmount +
                ", orderCount=" + orderCount +
                '}';
    }
}