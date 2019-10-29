package lx.entity;

public class PageUtil {
    //接收页码
    private Integer page=1; //默认第一页
    //页大小
    private Integer rows;


    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
