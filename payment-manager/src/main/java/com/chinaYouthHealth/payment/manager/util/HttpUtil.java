package com.chinaYouthHealth.payment.manager.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * HTTP请求工具类
 * Created by Zong on 2017/5/2.
 */
public class HttpUtil {

    private static final Log logger = LogFactory.getLog(HttpUtil.class);

    /**
     * 发送get请求
     */
    public static void get(String urlStr) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            // 创建httpget
            HttpGet httpget = new HttpGet(urlStr);
            logger.info("executing request " + httpget.getURI());
            // 执行get请求
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                // 获取响应实体
                HttpEntity entity = response.getEntity();
                logger.info("--------------------------------------");
                // 打印响应状态
                logger.info(response.getStatusLine());
                if (entity != null) {
                    // 打印响应内容长度
                    logger.info("Response content length: " + entity.getContentLength());
                    // 打印响应内容
                    logger.info("Response content: " + EntityUtils.toString(entity));
                }
                logger.info("------------------------------------");
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            logger.error("http请求失败，抛出异常ClientProtocolException：" + e);
        } catch (IOException e) {
            logger.error("http请求失败：" + e);
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                logger.error("httpclient关闭失败：" + e);
            }
        }
    }

    /**
     * 发送post请求
     */
    public static String post(String urlStr, List<NameValuePair> formparams) {
        // 创建默认的httpClient实例
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建httppost
        HttpPost httppost = new HttpPost(urlStr);
        // 创建参数队列 --> formparams

        String result = null;
        UrlEncodedFormEntity uefEntity;
        try {
            // 向POST请求中添加消息实体
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
            httppost.setEntity(uefEntity);
            logger.info("executing request " + httppost.getURI());
            // 执行post请求
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                // 获取响应实体
                HttpEntity entity = response.getEntity();
                // 打印响应状态
                logger.info(response.getStatusLine());
                if (entity != null) {
                    // 打印响应内容
                    result = EntityUtils.toString(entity, "UTF-8");
                    logger.info("--------------------------------------");
                    logger.info("Response content: " + result);
                    logger.info("--------------------------------------");
                }
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            logger.error("http请求失败，抛出异常ClientProtocolException：" + e);
        } catch (UnsupportedEncodingException e1) {
            logger.error("http请求失败，抛出异常UnsupportedEncodingException：" + e1);
        } catch (IOException e) {
            logger.error("http请求失败：" + e);
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                logger.error("httpclient关闭失败：" + e);
            }
        }
        return result;
    }

    public static String postWithJSON(String url, String json) {

        String result = null;
        // 创建默认的httpClient实例
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            // 创建httppost
            HttpPost httppost = new HttpPost(url);
            httppost.addHeader("Content-type", "application/json; charset=utf-8");
            logger.info("请求uri = " + httppost.getURI());

            // 向POST请求中添加消息实体
            StringEntity se = new StringEntity(json, "UTF-8");
            httppost.setEntity(se);
            logger.info("请求参数： " + json);

            // 执行post请求
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                // 获取响应实体
                HttpEntity entity = response.getEntity();
//                // 打印响应状态
//                System.out.println(response.getStatusLine());
                result = EntityUtils.toString(entity, "UTF-8");
                if (entity != null) {
                    // 打印响应内容
                    logger.info("--------------------------------------");
                    logger.info("返回结果: " + result);
                    logger.info("--------------------------------------");
                }
            } finally {
                response.close();
            }
        } catch (Exception e) {
            logger.error("executing postWithJSON error: " + e);
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                logger.error("executing postWithJSON error: " + e);
            }
        }
        return result;
    }
}
