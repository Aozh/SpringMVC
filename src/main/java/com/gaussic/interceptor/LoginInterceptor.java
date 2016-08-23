package com.gaussic.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import com.mysql.jdbc.Connection;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.sql.*;
import java.sql.DriverManager;

import static java.lang.System.out;
import static java.lang.System.setOut;

/**
 * Created by zhaoli8 on 2016/8/15.
 */
public class LoginInterceptor implements HandlerInterceptor {
    private  int judge=0;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String requestURI = httpServletRequest.getRequestURI();
        String requestUrl = httpServletRequest.getRequestURL().toString();

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
        if(requestURI.indexOf("show")>0)
            judge=0;
        {
            while (rs.next()) {

                System.out.println("pipeichenggong");
                String m=rs.getString(1);
                System.out.println(m);
                if (rs.getString(1).equals("xiaoming"))
                {
                    System.out.println(rs.getString(1));
                    this.judge=1;
                }
            }

        }
//        if(requestURI.indexOf("update")>0)
//            judge=0;
//        {
//            while (rs.next()) {
//
//                System.out.println("pipeichenggong");
//                String m=rs.getString(1);
//                System.out.println(m);
//                if (rs.getString(1).equals("xiaoming"))
//                {
//                    System.out.println(rs.getString(1));
//                    this.judge=1;
//                }
//            }
//
//        }
        con.close();
        if(this.judge==1){
            out.println("Interceptor.......");

            return true;
        }
        httpServletRequest.getRequestDispatcher("/admin/users").forward(httpServletRequest, httpServletResponse);
        return false;
    }


    @Override
    public void postHandle(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}



