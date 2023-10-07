package com.offcn.servlet;

import com.offcn.bean.Commodity;
import com.offcn.dao.CommodityDao;
import com.offcn.utils.BaseServlet;
import com.offcn.utils.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CommodityServlet")
public class CommodityServlet extends BaseServlet {
    CommodityDao commodityDao =new CommodityDao();
    //删除商品的方法
    protected void doDeleteCommodity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code=request.getParameter("cCode");
        String title=request.getParameter("cTitle");
        try{
            //调用dao层商品删除的方法
            commodityDao.DeleteCommodity(code);
            //商品修改成功跳转商品管理页面
            //进入商品管理页面之前先查询商品数据，再进入商品管理页面commodity_manager.jsp
            //把提示信息放到session域中
            request.getSession().setAttribute("message","【"+title+"】删除成功了!");
            response.sendRedirect(request.getContextPath()+"/CommodityServlet?way=doGetCommodityList&pageNo=1");
        }
        catch (Exception e){
            //商品添加失败跳转商品添加页面
            request.getSession().setAttribute("message","【"+title+"】删除失败了!");
            response.sendRedirect(request.getContextPath()+"/CommodityServlet?way=doGetCommodityList&pageNo=1");
        }
    }
    //根据商品名称查询商品的方法
    protected void doGetCommodityByTitle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title=request.getParameter("title");
        try{
            //调用dao层的根据商品名称查询商品方法
            int code=commodityDao.getCommodityByTitle(title);
            int titlePageNo=commodityDao.getTitlePageNo(code);
            request.getSession().setAttribute("message","【"+title+"】查询成功了!");
            response.sendRedirect(request.getContextPath()+"/CommodityServlet?way=doGetCommodityList&pageNo="+titlePageNo);
        }
        catch (Exception e){
            request.getSession().setAttribute("message","【"+title+"】不存在!");
            response.sendRedirect(request.getContextPath()+"/CommodityServlet?way=doGetCommodityList&pageNo=1");

        }


    }
    //修改商品信息的方法
    protected void doUpdateCommodity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code=request.getParameter("Code");
        String title=request.getParameter("Title");
        String category=request.getParameter("Category");
        String price=request.getParameter("Price");
        String stock=request.getParameter("Stock");
        try{
            //调用dao层商品修改的方法
            commodityDao.updateCommodity(code,title,category,price,stock);
            //商品修改成功跳转商品管理页面
            //进入商品管理页面之前先查询商品数据，再进入商品管理页面commodity_manager.jsp
            //把提示信息放到session域中
            request.getSession().setAttribute("message","【"+title+"】修改成功了!");
            response.sendRedirect(request.getContextPath()+"/CommodityServlet?way=doGetCommodityList&pageNo=1");
        }
        catch (Exception e){
            //商品添加失败跳转商品添加页面
            request.getSession().setAttribute("message","【"+title+"】修改失败了!");
            response.sendRedirect(request.getContextPath()+"/CommodityServlet?way=doGetCommodityById&Ccode="+code);
        }
    }

    //根据id查询商品，把查询到的商品展示商品修改页面
    protected void doGetCommodityById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code=request.getParameter("cCode");
        //调用dao层根据商品id查询商品方法
        Commodity commodity=commodityDao.getCommodityById(code);
        request.setAttribute("commodity",commodity);
        request.getRequestDispatcher("/commodity_update.jsp").forward(request,response);

    }
    //添加商品的方法
    protected void doAddCommodity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String title=request.getParameter("cTitle");
       String category=request.getParameter("cCategory");
       String price=request.getParameter("cPrice");
       String stock=request.getParameter("cStock");
       try{
           //调用dao层商品添加的方法
           commodityDao.addCommodity(title,category,price,stock);
           //商品添加成功跳转商品管理页面
           //进入商品管理页面之前先查询商品数据，再进入商品管理页面commodity_manager.jsp
           //把提示信息放到session域中
           request.getSession().setAttribute("message","【"+title+"】添加成功了!");
           response.sendRedirect(request.getContextPath()+"/CommodityServlet?way=doGetCommodityList&pageNo=1");
       }
       catch (Exception e){
           //商品添加失败跳转商品添加页面
           request.getSession().setAttribute("message","【"+title+"】添加失败了!");
           response.sendRedirect(request.getContextPath()+"/commodity_add.jsp");
       }
    }
    //商品分页查询的方法
    protected void doGetCommodityList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageNo=request.getParameter("pageNo");
        Page<Commodity> page=commodityDao.getCommodityList(pageNo);
        request.setAttribute("page",page);
        request.getRequestDispatcher("/commodity_manager.jsp").forward(request,response);
    }
}
