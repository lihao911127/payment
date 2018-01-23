package com.chinaYouthHealth.payment.manager.util;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 页面分页工具类
 * @author wuchao
 *
 */
public class PageInfoUtil<T,S> {
    
    private static final Logger log = LoggerFactory.getLogger(PageInfoUtil.class);
    
    private int curPage;
    private int pageSize;
     public abstract class QueryHandler<M,E>{
        public M mapper;
        public E example;
        public QueryHandler(M mapper,E example){
            this.mapper = mapper;
            this.example = example;
        }
        public abstract List<S> queryList();
        
    }
    
    public PageInfoUtil(int curPage,int pageSize){
        this.curPage = curPage;
        this.pageSize = pageSize;
    }
    
    /**
     * 
     * @param dtoClass
     * @param curPage
     * @param pageSize
     * @param query
     * @return
     */
    public PageInfo<T> convertToDto(Class<T> dtoClass,QueryHandler query){
        PageHelper.startPage(curPage, pageSize);
        List<S> result = query.queryList();
        PageInfo<S> goodsPage = new PageInfo<S>(result);
        List<T> ls = new ArrayList<T>();
        for(S val:goodsPage.getList()){
            try {
                T source = dtoClass.newInstance();
                BeanUtils.copyProperties(val, source);
                ls.add(source);
            } catch (InstantiationException e) {
                log.error(e.getMessage());
            } catch (IllegalAccessException e) {
                log.error(e.getMessage());
            }
        }
        return this.getPageInfo(goodsPage.getTotal(), ls);
    }
    
    /**
     * 
     * @param total
     * @param curPage
     * @param pageSize
     * @param results
     * @return
     */
    public PageInfo<T> getPageInfo(long total,List<T> results){
        PageInfo<T> pageInfo = new PageInfo<T>();
        pageInfo.setList(results);
        pageInfo.setPageSize(results.size());//当前页的记录数
        pageInfo.setTotal(total);//总记录条数
        pageInfo.setPageNum(curPage);//当前页数
        long pages=total/pageSize;
        if(total%pageSize!=0){
            pages++;
        }
        pageInfo.setPages(Integer.parseInt(pages+""));//总页数
        return pageInfo;
    }
    /**
     * 
     * @param total
     * @param curPage
     * @param pageSize
     * @param results
     * @return
     */
    public PageInfo<T> getPageInfo(int total,List<T> results){
        PageInfo<T> pageInfo = new PageInfo<T>();
        pageInfo.setList(results);
        pageInfo.setPageSize(results.size());//当前页的记录数
        pageInfo.setTotal(total);//总记录条数
        pageInfo.setPageNum(curPage);//当前页数
        int pages=total/pageSize;
        if(total%pageSize!=0){
            pages++;
        }
        pageInfo.setPages(pages);//总页数
        return pageInfo;
    }
    /**
     * 内存分页，查询所有分页
     * @param total 总记录数
     * @param curPage 当前页
     * @param pageSize 分页大小
     * @param results 
     * @return
     */
    public PageInfo<T> getPageInfoFromMem(List<T> results){
        int total = results.size();
        PageInfo<T> pageInfo = new PageInfo<T>();
        List<T> subResult = this.getSubResultList(total, results);
        pageInfo.setList(subResult);
        pageInfo.setPageSize(subResult.size());//当前页的记录数
        pageInfo.setTotal(total);//总记录条数
        pageInfo.setPageNum(curPage);//当前页数
        int pages=total/pageSize;
        if(total%pageSize!=0){
            pages++;
        }
        pageInfo.setPages(pages);//总页数
        return pageInfo;
    }
    
    /**
     * 根据总记录条数、当前页面，分页大小计算当前页数据大小
     * @param total
     * @param curPage
     * @param pageSize
     * @return
     */
    private List<T> getSubResultList(int total,List<T> results){
        int resultStart = (curPage-1)*pageSize;
        int resultEnd = resultStart+pageSize;
        if(resultEnd>total){
            resultEnd =total;
        }
        List<T> subResult = results.subList(resultStart, resultEnd);
        return subResult;
    }
    
    
}
