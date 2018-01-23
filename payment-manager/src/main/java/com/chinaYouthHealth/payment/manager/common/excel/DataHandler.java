package com.chinaYouthHealth.payment.manager.common.excel;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gomefinance.promotion.exception.RuntimeServiceException;

/**
 * 数据处理类
 *
 * @author wuchao
 */
@Service
public class DataHandler {
    private static final Logger log = LoggerFactory.getLogger(DataHandler.class);

    @Value("${download.template.path}")
    private String tempatePath;

    /**
     * 返回
     *
     * @param code
     * @param results
     * @param rowHandler
     * @return
     */
    public List<Object> importData(String code, List<String> results, RowHandler rowHandler) {
        List<Object> list = new ArrayList<Object>();
        //获取配置信息
        Config config = ConfigRegister.getConfig(code);

        /**
         * 结果
         */
        Map<Integer, FsConfig> colFsName = new HashMap<Integer, FsConfig>();
        Map<String, FsConfig> excelTitles = new HashMap<String, FsConfig>();
        for (FsConfig fsConfig : config.getFsConfig()) {
            excelTitles.put(fsConfig.getTitleName(), fsConfig);
        }
        for (int i = 0; i < results.size(); i++) {
            String[] contents = results.get(i).split("\\|");
            /**
             * "商品代码","商品名称","品牌代码","品类代码","是否3C","首付比例","件数"
             */
            if (i < config.getTitleStartRow()) {
                continue;
            }
            if (i == config.getTitleStartRow()) {//处理表头
                int col = 0;
                for (String content : contents) {
                    FsConfig fsConfig = excelTitles.get(content.trim());
                    //将每列对应的字段放入
                    colFsName.put(col, fsConfig);
                    col++;
                }
            } else {
                int col = 0;
                Object obj = null;
                try {
                    obj = config.getObjClass().newInstance();
                } catch (InstantiationException e) {
                    log.error(e.getMessage());
                    throw new RuntimeServiceException("初始化失败" + e.getMessage());
                } catch (IllegalAccessException e) {
                    log.error(e.getMessage());
                    throw new RuntimeServiceException("初始化失败" + e.getMessage());
                }
                list.add(obj);
                rowHandler.before(obj);
                for (String value : contents) {
                    FsConfig fsConfig = colFsName.get(col);
                    if (fsConfig == null) {
                        continue;
                    }
                    setValue(obj, fsConfig, value.trim());
                    col++;
                }
                rowHandler.after(obj);
            }
        }
        return list;
    }

    /**
     * 给对象赋值
     *
     * @param tGoods 商品对象
     * @param fsName 字段名
     * @param value  值
     */
    private void setValue(Object object, FsConfig fsConfig, String value) {
        if (value == null || "".equals(value)) {
            if (fsConfig.isNess()) {
                throw new RuntimeServiceException(fsConfig.getTitleName() + "必填");
            } else {
                return;
            }
        }
        Object val = new Object();
        try {
            if (fsConfig.getFsClassType().equals(Integer.class)) {
                val = Integer.valueOf(getIntStr(value));
            } else if (BigDecimal.class.equals(fsConfig.getFsClassType())) {
                val = new BigDecimal(value);
            } else if (fsConfig.getFsClassType().equals(Long.class)) {
                val = Long.valueOf(getIntStr(value));
            } else if (fsConfig.getFsClassType().equals(Double.class)) {
                val = Double.valueOf(value);
            } else {
                if (value != null && String.valueOf(value).endsWith(".0")) {
                    val = getIntStr(String.valueOf(value));
                } else {
                    val = value;
                }
            }
        } catch (Exception e) {

        }
        if (val == null && fsConfig.isNess()) {
            throw new RuntimeServiceException(fsConfig.getTitleName() + "必填");
        }
        try {
            BeanUtils.setProperty(object, fsConfig.getFsName(), val);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeServiceException(fsConfig.getTitleName() + "赋值异常" + e.getMessage());
        }
    }

    /**
     * 获取整型长度
     *
     * @param val
     * @return
     */
    private static String getIntStr(String val) {
        if (val == null || "".equals(val)) {
            return "0";
        }
        if (val.lastIndexOf(".") > 0) {
            val = val.substring(0, val.indexOf("."));
        }
        return val;
    }

    /**
     * 下载文件
     *
     * @param request
     * @param response
     * @param code
     */
    public void downloadFile(HttpServletRequest request, HttpServletResponse response, String code) {
        Config config = ConfigRegister.getConfig(code);
        if (config == null) {
            throw new RuntimeServiceException("不能找到模板编号");
        }
        //
        String path = config.getExcelPath();
        //获取系统的路径class路径
        //path = Class.class.getClass().getResource("/").getPath()+path;
        path = tempatePath + path;
        download(response, path);
    }


    private static void download(HttpServletResponse res, String path) {
        File file = null;
        try {
            file = new File(path);
        } catch (Exception e) {
            throw new RuntimeServiceException("不能找到文件:" + path);
        }
        res.reset();
        res.setContentType("application/x-download");
        res.addHeader("Content-Disposition", "attachment;filename=" + file.getName());
        java.io.OutputStream outp = null;
        try {
            outp = res.getOutputStream();
            outp.write(readFileImage(path));
            outp.flush();
        } catch (Exception e) {
            System.out.println("Error!");
            log.error(e.getMessage());
        } finally {
            if (outp != null) {
                try {
                    outp.close();
                } catch (IOException e) {
                    log.error(e.getMessage());
                }
            }

        }
    }


    /**
     * 读取文件，返回字节
     *
     * @param filename
     * @return
     * @throws IOException
     */
    private static byte[] readFileImage(String filename) throws IOException {
        BufferedInputStream bufferedInputStream = null;
        FileInputStream fileInputStream = null;
        byte[] bytes = null;
        try {
            fileInputStream = new FileInputStream(filename);
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            int len = bufferedInputStream.available();
            bytes = new byte[len];
            int r = bufferedInputStream.read(bytes);
            if (len != r) {
                bytes = null;
                throw new IOException("读取文件不正确");
            }
        } finally {
            try {
                if (bufferedInputStream != null)
                    bufferedInputStream.close();
            } catch (Exception e) {
            }
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (Exception e) {

            }
        }
        return bytes;
    }
}
