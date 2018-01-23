package com.chinaYouthHealth.payment.manager.common.excel;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 配置文件注册中心
 *
 * @author wuchao
 */
@Service
public class ConfigRegister {

    /**
     * 001
     */
    static Map<String, Config> info = new HashMap<String, Config>();

    static {
        register();
    }

    /**
     * 注册信息
     */
    public static void register() {
        //注册品类 ->1
        List<FsConfig> fsConfigs = new ArrayList<FsConfig>();
        fsConfigs.add(new FsConfig("品类代码", "categoryCode", String.class, true, "", ""));
        fsConfigs.add(new FsConfig("品类名称", "categoryName", String.class, false, "", ""));
        fsConfigs.add(new FsConfig("件数", "count", Integer.class, false, "", ""));
        Config config = new Config(TGoods.class, fsConfigs, "", "template/tgoods_1.xlsx");
        initInfo("1", config);
        //注册品牌 ->2
        fsConfigs = new ArrayList<FsConfig>();
        fsConfigs.add(new FsConfig("品牌代码", "brandCode", String.class, true, "", ""));
        fsConfigs.add(new FsConfig("品类名称", "brandName", String.class, false, "", ""));
        fsConfigs.add(new FsConfig("件数", "count", Integer.class, false, "", ""));
        config = new Config(TGoods.class, fsConfigs, "", "template/tgoods_2.xlsx");
        initInfo("2", config);
        //注册品牌+品类 ->3
        fsConfigs = new ArrayList<FsConfig>();
        fsConfigs.add(new FsConfig("品类代码", "categoryCode", String.class, true, "", ""));
        fsConfigs.add(new FsConfig("品类名称", "categoryName", String.class, false, "", ""));
        fsConfigs.add(new FsConfig("品牌代码", "brandCode", String.class, true, "", ""));
        fsConfigs.add(new FsConfig("品类名称", "brandName", String.class, false, "", ""));
        fsConfigs.add(new FsConfig("件数", "count", Integer.class, false, "", ""));
        config = new Config(TGoods.class, fsConfigs, "", "template/tgoods_3.xlsx");
        initInfo("3", config);
        //注册sku ->4
        fsConfigs = new ArrayList<FsConfig>();
        fsConfigs.add(new FsConfig("商品代码", "goodsCode", String.class, true, "", ""));
        fsConfigs.add(new FsConfig("商品名称", "goodsName", String.class, false, "", ""));
        fsConfigs.add(new FsConfig("件数", "count", Integer.class, false, "", ""));
        config = new Config(TGoods.class, fsConfigs, "", "template/tgoods_4.xlsx");
        initInfo("4", config);
        //注册3C/非3C ->5
        fsConfigs = new ArrayList<FsConfig>();
        fsConfigs.add(new FsConfig("是否3C", "isThreeCorridors", String.class, true, "", ""));
        fsConfigs.add(new FsConfig("件数", "count", Integer.class, false, "", ""));
        config = new Config(TGoods.class, fsConfigs, "", "template/tgoods_5.xlsx");
        initInfo("5", config);

    }

    private static void initInfo(String code, Config config) {
        if (info.containsKey(code)) {
            throw new RuntimeException("Excel注册中心中存在相同的code");
        } else {
            info.put(code, config);
        }
    }

    /**
     * @param code
     * @return
     */
    public static Config getConfig(String code) {
        return info.get(code);
    }
}
