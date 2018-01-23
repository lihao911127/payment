package com.chinaYouthHealth.payment.manager.common.excel;

import com.gomefinance.promotion.exception.RuntimeServiceException;

/**
 * 行处理接口
 *
 * @author wuchao
 */
public interface RowHandler {

    public void before(Object o) throws RuntimeServiceException;

    public void after(Object o) throws RuntimeServiceException;
}
