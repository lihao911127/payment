package com.gomefinance.promotion.api;

import com.gomefinance.promotion.dto.*;
import com.gomefinance.promotion.exception.APIServiceException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface PromotionAPIService {

    /**
     * 根据商户类型和门店code获取活动信息
     * @param map 中字段（
     *      merchantType 1：内部商户，2：外部商户
     *      creditCardType 是否绑定信用卡
     *      storeCode 门店code）
     * @return
     * @throws APIServiceException
     */
    List<ActivityApiDto> findActivityList(Map<String,String> map) throws APIServiceException;

    /**
     * 根据商户类型和活动code获取分期列表
     *
     * @param type 1：内部商户，2：外部商户
     * @param activityCode
     * @param storeCode
     * @return
     * @throws APIServiceException
     */
    List<ProductApiDto> findActivityProductSet(String type, String activityCode,String storeCode) throws APIServiceException;

    /**
     * 根据产品代码查询分期信息
     *
     * @param activityCode
     * @param productCode
     * @return
     * @throws APIServiceException
     */
    List<ProductDetailApiDto> findProductDetailList(String activityCode, String productCode) throws APIServiceException;

    /**
     * 根据商户类型、活动代码和sku查询商品
     *
     * @param type 0：内部商户，1：外部商户
     * @param activityCode
     * @param sku
     * @param amount 商品总价，暂时不用
     * @return
     * @throws APIServiceException
     */
    GoodsApiDto findGoods(String type, String activityCode, String sku, BigDecimal amount)throws APIServiceException;
    /**
     * 校验商品数量
     *
     * @param activityGoodsApiDto 需要校验的活动商品信息
     * @return
     * @throws APIServiceException
     */
    GoodsCheckApiDto checkGoodsCount(ActivityGoodsApiDto activityGoodsApiDto)throws APIServiceException;
    /**
     * @Author: pengDing
     * @Date: 2017/9/5
     * @method: checkGoodsJoinActivity 校验商品是否参加活动
     * @param activityCode
     * @param goodsCheckApiDtoList
     * @retrun: java.util.Map<java.lang.String,java.lang.Object>;现有key为errorMessage;正常返回null
     */
    Map<String,Object> checkGoodsJoinActivity(String activityCode,List<GoodsActivityCheckApiDto> goodsCheckApiDtoList);

    /**
     * 获取商品的活动数量
     *
     * @param activityGoodsApiDto 需要校验的活动商品信息
     * @return
     * @throws APIServiceException
     */
    List<GoodsCheckApiDto> findGoodsActivityCount(ActivityGoodsApiDto activityGoodsApiDto)throws APIServiceException;

}
