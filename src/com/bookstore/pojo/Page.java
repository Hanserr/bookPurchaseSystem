package com.bookstore.pojo;

import java.util.List;

public class Page<T> {
    public static final Integer PAGE_SIZE = 4;
    //page页码
    private Integer PageNo;
    //page总页数
    private Integer PageTotal;
    //page每页大小
    private Integer PageSize;
    //商品总数
    private  Integer PageTotalCount;
    private List<T>items;
    private String url;

    public Page(Integer pageNo, Integer pageTotal, Integer pageSize, Integer pageTotalCount, List<T> items) {
        PageNo = pageNo;
        PageTotal = pageTotal;
        PageSize = pageSize;
        PageTotalCount = pageTotalCount;
        this.items = items;
    }
    public Page(){};

    @Override
    public String toString() {
        return "Page{" +
                "PageNo=" + PageNo +
                ", PageTotal=" + PageTotal +
                ", PageSize=" + PageSize +
                ", PageTotalCount=" + PageTotalCount +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }

    public Integer getPageNo() {
        return PageNo;
    }

    public void setPageNo(Integer pageNo) {
        PageNo = pageNo;
    }

    public Integer getPageTotal() {
        return PageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        PageTotal = pageTotal;
    }

    public Integer getPageSize() {
        return PageSize;
    }

    public void setPageSize(Integer pageSize) {
        PageSize = pageSize;
    }

    public Integer getPageTotalCount() {
        return PageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        PageTotalCount = pageTotalCount;
    }

    public List<T> getItems() {
        return (List<T>) items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
