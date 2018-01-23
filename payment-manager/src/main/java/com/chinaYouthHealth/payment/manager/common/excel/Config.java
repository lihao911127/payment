package com.chinaYouthHealth.payment.manager.common.excel;

import java.util.List;

/**
 * 配置信息
 *
 * @author wuchao
 */
public class Config {

    /**
     * 对一个的类名，只允许对应一个实体类
     */
    private Class objClass;

    private List<FsConfig> fsConfig;

    /**
     * 表头从第几行开始，excel第一行从0开始
     */
    private int titleStartRow = 0;

    /**
     * excel名称
     */
    private String excelName;

    /**
     * 模板存储的位置
     */
    private String excelPath;


    public Config(Class objClass, List<FsConfig> fsConfig, int titleStartRow, String excelName, String excelPath) {
        this.objClass = objClass;
        this.fsConfig = fsConfig;
        this.titleStartRow = titleStartRow;
        this.excelPath = excelPath;
    }

    public Config(Class objClass, List<FsConfig> fsConfig, String excelName, String excelPath) {
        this.objClass = objClass;
        this.fsConfig = fsConfig;
        this.excelPath = excelPath;
        this.excelName = excelName;
    }

    public Config() {

    }

    public Class getObjClass() {
        return objClass;
    }

    public void setObjClass(Class objClass) {
        this.objClass = objClass;
    }

    public List<FsConfig> getFsConfig() {
        return fsConfig;
    }

    public void setFsConfig(List<FsConfig> fsConfig) {
        this.fsConfig = fsConfig;
    }

    public int getTitleStartRow() {
        return titleStartRow;
    }

    public void setTitleStartRow(int titleStartRow) {
        this.titleStartRow = titleStartRow;
    }

    public String getExcelName() {
        return excelName;
    }

    public void setExcelName(String excelName) {
        this.excelName = excelName;
    }

    public String getExcelPath() {
        return excelPath;
    }

    public void setExcelPath(String excelPath) {
        this.excelPath = excelPath;
    }


}
