package com.bobcfc.financial_Loan.entity;

/**
 * @author wangchunyu
 * @create 2020-03-22 2:11
 */
public class Page {
    private int current=1;//当前页码
    private int limit=5;//显示上限
    private int rows;//数据的总数（用于计算总页数）
    private String path;//查询路径（用于复用分页链接）

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if(current>=1){
            this.current = current;
        }

    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if(limit>=1&&limit<=100){
            this.limit = limit;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if(rows>=0){
            this.rows = rows;
        }

    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    //获取当前页的起始行
    public int getOffset(){
        //current*limit-limit
        return (current-1)*limit;
    }

    //用来获取总的页数
    public int getTotal(){
        //rows/limit+1
        if(rows%limit==0){
            return rows/limit;
        }else{
            return rows/limit +1;
        }
    }

    //获取起始页码
    public  int getFrom(){
        int from=current-2;
        return from<1?1:from;
    }
     //获取结束页码
    public int getTo(){
        int to=current+2;
        int total=getTotal();
        return to>total?total:to;
    }
}
