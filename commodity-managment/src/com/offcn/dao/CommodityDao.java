package com.offcn.dao;

import com.offcn.bean.Commodity;
import com.offcn.utils.BaseDao;
import com.offcn.utils.Page;

import java.util.List;

public class CommodityDao extends BaseDao<Commodity> {
    //dao层商品查询的方法
    public Page<Commodity> getCommodityList(String pageNo) {
        int pno = 1;
        Page<Commodity> page = new Page<>();
        try {
            //把当前页转为int类型，如果转变失败默认页码为1
            pno = Integer.parseInt(pageNo);
        } catch (Exception e) {
        }
        //设置当前页码
        page.setPageNo(pno);
        //设置每页显示的数据
        page.setPageSize(4);
        //查询总数据量
        int commodityCount = getCommodityCount();
        page.setTotalRecord(commodityCount);
        //查询当前页的数据
        String sql = "select *from commodity limit ?,?";
        List<Commodity> commodityList = getBeanList(sql, (page.getPageNo() - 1) * page.getPageSize(), page.getPageSize());
        page.setList(commodityList);
        return page;
    }
    //dao层获取总数据的方法
    public int getCommodityCount() {
        String sql = "select count(*) from commodity";
        Long signleValue = (Long) getSingleValue(sql);
        return signleValue.intValue();
    }
    //dao层添加商品的方法
    public void addCommodity(String title,String category, String price, String stock) {
        double cPrice = Double.parseDouble(price);
        int cStock = Integer.parseInt(stock);
        String sql = "insert into commodity (title,category,price,stock) values(?,?,?,?)";
        update(sql, title,category,cPrice, cStock);
    }

    //dao层根据商品编码查询商品的方法
    public Commodity getCommodityById(String commodityCode) {
        String sql = "select *from commodity where code=?";
        Commodity commodity=getBean(sql,commodityCode);
        return commodity;
    }
   //dao层修改商品方法
    public void updateCommodity(String code, String title, String category, String price, String stock) {
        int cCode = Integer.parseInt(code);
        double cPrice = Double.parseDouble(price);
        int cStock = Integer.parseInt(stock);
        String sql = "update commodity set title=?,category=?,price=?,stock=? where code=?";
        update(sql, title,category, cPrice, cStock,cCode);
    }
    //dao层根据商品名称查询商品的方法
    public int getCommodityByTitle(String title) {
        String sql="select *from commodity where title=?";
        Commodity commodity=getBean(sql,title);
        return commodity.getCode();
    }
    //dao层获取查询商品的页码的方法
    public int getTitlePageNo(int code) {
        int titlePageNo;
        if(code%4==0){
            titlePageNo=(code/4);
        }
        else{
            titlePageNo=(code/4)+1;
        }
        return titlePageNo;
    }
    //dao层删除商品的方法
    public void DeleteCommodity(String commodityCode) {
        int code=Integer.parseInt(commodityCode);
        String sql="delete from commodity where code=?";
        update(sql,code);
    }
    public static void main(String[] args) {
        CommodityDao commodityDao= new CommodityDao();
        Page<Commodity> page = commodityDao.getCommodityList("10");
        System.out.println("总数据量:" + page.getTotalRecord());
        System.out.println("总页数:" + page.getTotalPageNo());
        System.out.println("当前页:" + page.getPageNo());
        System.out.println("每页显示的数据量:" + page.getPageSize());
        System.out.println("--------当前页的数据--------");
        for (Commodity commodity : page.getList()) {
            System.out.println(commodity);
            //bookDao.addBook("java从入门到精通","20.0","TomCat","1000","200");

        }
        //commodityDao.addCommodity("java实训","TomCat","1000","200"); 4
        //commodityDao.DeleteCommodity("7");
        int id=commodityDao.getCommodityByTitle("英语");
        System.out.println("java实训id"+id);
        System.out.println("java实训当前页"+commodityDao.getTitlePageNo(id));
        //commodityDao.DeleteCommodity("17");
    }
}