package com.itheima.domain;

public class PageBean {

    private Integer pageNum;//当前页码
    private Integer counts;//总记录数
    private Integer pages;//总页数
    private Integer pageSize;//每页显示的条目数
    private Integer pageStart;//每页起始位置

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageStart() {
        return pageStart;
    }

    public void setPageStart(Integer pageStart) {
        this.pageStart = pageStart;
    }
}
