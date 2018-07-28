package com.example.demo.consumer.entity;

/**
 * @author ZERO
 * @version V1.0
 * @description 分页项类型
 * @package com.example.demo.consumer.entity
 * @date 2018 07-18 19:07
 */
public class PageEntity {

    /**
     * 页码
     */
    private Integer pageNum;
    /**
     * 页数
     */
    private Integer pageSize;
    /**
     * 总页数
     */
    private Integer pageCount;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }
}
