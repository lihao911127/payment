package com.gomefinance.promotion.dto;

import java.io.Serializable;

public class ActivityApiDto implements Serializable {

    private static final long serialVersionUID = 743442873754674987L;
    /**
     * 活动code
     */
    private String activityCode;
    /**
     * 活动名字
     */
    private String activityName;
    /**
     * 活动优先级
     */
    private String priority;
    /**
     * 活动标识 0-常规活动 1-促销活动
     */
    private String activityFlag;
    /**
     * 长亮促销代码
     */
    private String promotionCode;


    public String getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }

    public String getActivityCode() {
        return activityCode;
    }

    public void setActivityCode(String activityCode) {
        this.activityCode = activityCode == null ? null : activityCode.trim();
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
    }


    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority == null ? null : priority.trim();
    }


    public String getActivityFlag() {
        return activityFlag;
    }

    public void setActivityFlag(String activityFlag) {
        this.activityFlag = activityFlag == null ? null : activityFlag.trim();
    }

    @Override
    public String toString() {
        return "ActivityApiDto{" +
                "activityCode='" + activityCode + '\'' +
                ", activityName='" + activityName + '\'' +
                ", priority='" + priority + '\'' +
                ", activityFlag='" + activityFlag + '\'' +
                ", promotionCode='" + promotionCode + '\'' +
                '}';
    }
}