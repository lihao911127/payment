package com.chinaYouthHealth.payment.manager.common.excel;

/**
 * 字段配置
 *
 * @author wuchao
 */
public class FsConfig {
    /**
     * 表头名
     */
    private String titleName;

    /**
     * 字段名称
     */
    private String fsName;

    /**
     * 字段对应的
     */
    private Class fsClassType;

    /***
     * 是否必须填写
     */
    private boolean isNess;

    /**
     * 默认值
     */
    private String defaultValue;


    /**
     * 描述
     */
    private String desc;

    public FsConfig(String titleName, String fsName, Class fsClassType, boolean isNess, String defaultValue, String desc) {
        this.titleName = titleName;
        this.fsName = fsName;
        this.fsClassType = fsClassType;
        this.isNess = isNess;
        this.defaultValue = defaultValue;
        this.desc = desc;
    }


    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getFsName() {
        return fsName;
    }

    public void setFsName(String fsName) {
        this.fsName = fsName;
    }

    public Class getFsClassType() {
        return fsClassType;
    }

    public void setFsClassType(Class fsClassType) {
        this.fsClassType = fsClassType;
    }

    public boolean isNess() {
        return isNess;
    }

    public void setNess(boolean isNess) {
        this.isNess = isNess;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


}
