package cn.edu.nuc.ssm.entity;

import java.util.List;

public class PageInfo<T> {
    //当前第几页
    private int current = 1;
    //共多少条数据
    private int count;
    //每页多少条数据
    private int offset = 10;
    //共多少页
    private int total;
    //当前页的起始坐标
    private int start;
    //对象集合
    private List<T> list;

    /**
     * @param
     */
    public PageInfo(int current) {
        this.current = current;
    }

    /**
     *
     */
    public PageInfo() {}

    public int getCurrent() {
        return current;
    }


    public void setCurrent(int current) {
        this.current = current;
    }


    public int getCount() {
        return count;
    }


    public void setCount(int count) {
        this.count = count;


        this.setTotal(
                this.count / this.offset
                        + ((this.count % this.offset) > 0 ? 1 : 0)
        );
    }


    public int getOffset() {
        return offset;
    }


    public void setOffset(int offset) {
        if( offset > 0 )
            this.offset = offset;
    }


    public int getTotal() {
        return total;
    }


    public void setTotal(int total) {
        this.total = total;
    }


    public int getStart() {
        this.start = (this.current - 1) * this.offset;
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }


    public List<T> getList() {
        return list;
    }


    public void setList(List<T> list) {
        this.list = list;
    }


    @Override
    public String toString() {
        return "PageInfo [current=" + current + ", count=" + count + ", offset=" + offset + ", total=" + total
                + ", start=" + start + ", list=" + list + "]";
    }

}
