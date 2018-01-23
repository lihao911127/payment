package com.chinaYouthHealth.payment.manager.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.gomefinance.promotion.dto.ActivityApiDto;
import com.chinaYouthHealth.payment.manager.util.ExcelHelper;
import com.chinaYouthHealth.payment.manager.util.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cf.fen.sm.base.response.ResponseMessage;

import com.github.pagehelper.PageInfo;
import com.gomefinance.fen.sa.service.fen.ShopService;
import com.gomefinance.fen.sa.service.organization.vo.DeptVO;
import com.gomefinance.fen.sa.util.page.Page;
import com.gomefinance.promotion.manager.PromotionManagerApplication;
import org.springframework.util.CollectionUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PromotionManagerApplication.class)
public class TActivityStoresServiceTest {

    private static final Logger log = LoggerFactory.getLogger(TActivityStoresServiceTest.class);

    @Autowired
    private TActivityStoresService tActivityStoresService;
    @Autowired
    private TBrandService tBrandService;

    @Autowired
    private TGoodsClassService tGoodsClassService;

    @Autowired
    ShopService shopService;


    @Test
    public void listBrandsAndGoodsClass() {

        /*TGoodsClassSearchDto tGoodsClassSearchDto = new TGoodsClassSearchDto();
        tGoodsClassSearchDto.setClassLevel("2");
        tGoodsClassSearchDto.setClassCode("C01");
        List<TGoodsClassDto> result = tGoodsClassService.queryTGoodsClassList(tGoodsClassSearchDto);
*/
        TGoodsClassDto tGoodsClassDto = new TGoodsClassDto();
        tGoodsClassDto.setClassName("销售");
        tGoodsClassDto.setCurpageNum(0);
        tGoodsClassDto.setCurpageSize(0);
        PageInfo<TGoodsClassDto> classDtoPageInfo = tGoodsClassService.queryGoodsClassByName(tGoodsClassDto);
        log.info("goodClassSize:" + classDtoPageInfo.getList().size());
    }

    /**
     * 绑定活动
     */
    @Test
    public void add() {
        try {
            TActivityStores tActivityStore = new TActivityStores();
            tActivityStore.setActivityCode("111");
            tActivityStore.setIsAllStore("N");
            tActivityStore.setMechantFlag("1");
            tActivityStore.setMerchantCode("123");
            tActivityStore.setMerchantName("测试");
            tActivityStore.setStoreCode("12314");
            tActivityStore.setStoreName("哈哈哈哈");
            //tActivityStoresService.insertActivityStores(tActivityStoresDto);

//          tActivityStoresService.insertActivityStores(tActivityStore);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 解除活动绑定
     */
    @Test
    public void delete() {
        List<String> storeCodes = new ArrayList<String>();
        storeCodes.add("md2");
        tActivityStoresService.deleteActivityStores("MYF2017000001", storeCodes);
    }

    @Test
    public void binding() {
        tActivityStoresService.bindingStores(new String[]{"S056"}, "MYF2017005565");
    }

    /**
     * 测试分页查询活动方法
     */
    @Test
    public void queryListByPage() {
        /**
         * 活动门店
         */
        List<ActivityApiDto> tActivityStores = tActivityStoresService.findTActivityList("");
        log.info("test=======queryListByPage======" + tActivityStores.size());
    }

    /**
     * 查询活动商店
     */
    @Test
    public void queryActivityStoresByPageTest() {
        TActivityStoresSearchDto tActivityStoresSearchDto = new TActivityStoresSearchDto();
        tActivityStoresSearchDto.setActivityCode("MYF2017005577");
        tActivityStoresSearchDto.setBinding("0");
        tActivityStoresSearchDto.setCurpageNum(2);
        tActivityStoresSearchDto.setCurpageSize(5);
        tActivityStoresSearchDto.setMechantFlag("1");
        //tActivityStoresSearchDto.setOrgCode("601010101");
        PageInfo<TActivityStoresDto> page = tActivityStoresService.queryActivityStoresByPage(tActivityStoresSearchDto);
        log.info("total===" + JsonUtils.toJson(page));
        log.info("查询结果" + JsonUtils.toJson(ResultDto.OK(new ResultDto(ResultDto.CODE_SUCCESS, "查询成功", page.getPageNum(),
                page.getPages(), page.getPageSize(), page.getList(), page.getTotal()))));
    }

    /**
     * 测试分页查询活动方法
     */
    @Test
    public void dubooOrgInfoTest() {
        try {
            List<OrgInfoDto> orgInfoDto = tActivityStoresService.getOrgInfoDto();
            System.out.println(orgInfoDto.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void dubboStoreQueryLocal() {
        TActivityStoresSearchDto tActivityStoresSearchDto = new TActivityStoresSearchDto();
        tActivityStoresSearchDto.setBinding("0");
        tActivityStoresSearchDto.setActivityCode("123");
        tActivityStoresSearchDto.setMechantFlag("1");
        PageInfo<TActivityStoresDto> pageInfo = tActivityStoresService.queryActivityStoresByPage(tActivityStoresSearchDto);
        System.out.println(pageInfo.getList());
    }

    @Test
    public void dubboStoreQuery() {
        Map<String, String> m = new HashMap<String, String>();
        //m.put("deptName", "");//门店名称
        //m.put("deptNo", "");//门店编码
        //m.put("salesName", "");//商户名称
        //m.put("salesOrg", "");//商户编码
        m.put("orgType", "2");//商户性质
        //m.put("deptName", "");//门店名称
        m.put("pageSize", "10");//每页条数
        m.put("curPageSize", "1");//当前第几页
        //m.put("orgCode", "");//组织机构号
        m.put("deptNoNotContains", "S056");

        /**
         deptName     门店名称
         deptNo       门店编码
         salesName    商户名称
         salesOrg     商户编码
         orgType      商户性质
         pageSize     每页多少条
         curPageSize  当前第几页
         **/
        ResponseMessage rs = shopService.getMerchantShopInfo(m);
        Page page = rs.getData();
        int total = page.getTotalPageNumber();
        List<DeptVO> depts = page.getList();
        System.out.println(rs);
    }


    //    /**
//     * 当调用 intern 方法时，如果池已经包含一个等于此 String 对象的字符串（该对象由 equals(Object) 方法确定）
//     * ，则返回池中的字符串。否则，将此 String 对象添加到池中，并且返回此 String 对象的引用，同时会改变调用者的。 
//     * 没有str常量池没有，创建对象复制给常量
//     * 
//     * @param args
//     */
    @Test
    public void testMain() {
        String s2 = new StringBuffer("word").toString();
        //System.out.println(s2==s2.intern());

        String s1 = new StringBuilder("he").append("llo").toString();
        String s3 = s1.intern();
        String s4 = "hello";
        String s5 = new String("hello");
        System.out.println(s3 == s1);
        System.out.println(s4 == s1);
        System.out.println(s3 == s4);
        System.out.println(s3 == s5);

        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        /**常量池中本来就有"java"这个String
         其实jvm从启动，到执行main里面的第一条代码，要经历很多的，比如加载rt.jar里面所有的Class，加载一个class肯定要执行static{}中内容，况且rt.jar中的jdk的类里面有很多xxx.startWith("java")或者其他用到"java"的代码，jvm启动的时候直接按照常量加载进来了丢到internmap里面了
         作者：cao
         链接：https://www.zhihu.com/question/32672669/answer/87514393
         来源：知乎
         著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         */
        String str2 = new StringBuilder("jav").append("a").toString();
        System.out.println(str2.intern() == str2);

        String ss1 = new String("kvill");
        System.out.println(ss1 == ss1.intern());
        byte[] b = new String("java").getBytes();
        System.out.println(b);
    }

    /**
     * 导入商品
     */
    @Test
    public void importGoods() {
        //
        try {
            String ss = "A0XK ";
            ss = ss.trim();
            System.out.println(ss);
            List<String> result = ExcelHelper.exportListFromExcel(new File("d:/门店.xlsx"), 0);
            result = result.stream().filter(s -> StringUtils.isNotBlank(s)).collect(Collectors.toList());
            List<String> res = Lists.newArrayList();
            result.forEach(s -> res.add(s.trim()));
            log.info("文件信息" + JsonUtils.toJson(result));
            String[] storeCodes = new String[result.size()];
            result.toArray(storeCodes);
            tActivityStoresService.bindingStores(storeCodes, "MYF2017005577");
        } catch (IOException e) {
            log.info("导入商品失败");
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.getMessage());
        }
    }

}
