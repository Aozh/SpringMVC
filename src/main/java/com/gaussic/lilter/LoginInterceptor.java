package com.gaussic.lilter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.gaussic.model.UserEntity;
import com.gaussic.repository.UserRepository;
import com.gaussic.model.UserEntity;
import com.gaussic.repository.UserRepository;
//import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.sql.*;
import java.sql.DriverManager;
import java.util.List;

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
            if (rs.getString(1).equals("xiaoming"))
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
    public void postHandle(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}



