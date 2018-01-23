package com.gomefinance.promotion.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @auther Administrator
 * @date 2017/8/28
 */
public class ActivityGoodsApiDto implements Serializable{
    private static final long serialVersionUID = -944142243689207833L;
    /**
     * 活动code
     */
    private String activityCode;
    /**
     * 活动名字
     */
    private String activityName;
    /**
     * 商户类型：1：内部商户，2：外部商户
     */
    private String type;
    /**
     * 商品信息
     */
    List<GoodsCheckApiDto> goodsCheckApiDtoList;

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

    public List<GoodsCheckApiDto> getGoodsCheckApiDtoList() {
        return goodsCheckApiDtoList;
    }

    public void setGoodsCheckApiDtoList(List<GoodsCheckApiDto> goodsCheckApiDtoList) {
        this.goodsCheckApiDtoList = goodsCheckApiDtoList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ActivityGoodsApiDto{" +
                "activityCode='" + activityCode + '\'' +
                ", activityName='" + activityName + '\'' +
                ", type='" + type + '\'' +
                ", goodsCheckApiDtoList=" + goodsCheckApiDtoList +
                '}';
    }
}
