package com.gaussic.lilter;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

import static java.lang.System.out;

/**
 * Created by zhaoli8 on 2016/8/15.
 */
public class LoginInterceptor1 implements HandlerInterceptor {
    private  int judge=0;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String requestURI = httpServletRequest.getRequestURI();

        Connection con = null;
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/springdemo", "root", "root"); //链接本地MYSQL
        System.out.println("sql connectted");
        Statement stmt;
        stmt = con.createStatement();

        int ret_id;
        String sql = "select * from vip where pin<624";
        ResultSet rs = stmt.executeQuery(sql);
        ResultSetMetaData rsmd = rs.getMetaData();
        System.out.println("querying SELECT * FROM XXX");
        int columnsNumber = rsmd.getColumnCount();
        while (rs.next()) {
            if (rs.getString(1).equals("xinxibu"))
            {
                System.out.println(rs.getString(1));
                this.judge=1;
            }
        }
        con.close();
        if(this.judge==1){
            out.println("Interceptor.......");
            return true;
        }
        httpServletRequest.getRequestDispatcher("/admin/users").forward(httpServletRequest, httpServletResponse);
        return false;
    }


    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}



