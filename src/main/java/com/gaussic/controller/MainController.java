package com.gaussic.controller;

import com.gaussic.model.PermissionEntity;
import com.gaussic.model.UserEntity;
import com.gaussic.repository.PermissionRepository;
import com.gaussic.repository.UserRepository;
import com.sun.xml.internal.ws.api.server.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import com.gaussic.model.UserEntity;
/**
 * Created by zhaoli8 on 2016/8/15.
 */

@Controller
public class MainController {

    // 自动装配数据库接口，不需要再写原始的Connection来操作数据库
    @Autowired
    UserRepository userRepository;
    @Autowired
    PermissionRepository permission;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

        @RequestMapping(value="/admin/users/addPermission",method = RequestMethod.GET)
    public String addPermission(ModelMap modelMap ){

        List<PermissionEntity> permissionList = permission.findAll();
       modelMap.addAttribute("permissionList", permissionList);

        return "admin/addM";
    }
    @RequestMapping(value="/admin/users/addPermission1",method = RequestMethod.POST)
    public String addPermission1(@RequestParam("cbox") int[] per, ModelMap modelMap,HttpServletRequest request){

       // httpServletRequest.getParameterValues();
       List<PermissionEntity> permissionList = permission.findAll();
        //request.getParameterValues();


         modelMap.addAttribute("permissionList", permissionList);

        return "admin/addM1";
    }
//    @RequestMapping(value = "/admin/users/addM1", method = RequestMethod.POST)
//    public String savePerssion(@ModelAttribute("user") PermissionEntity permission) {
//
//
//      permission.saveAndFlush(permission);
//
//
//        return "redirect:/admin/addM";
//    }
       @RequestMapping(value="/admin/users",method=RequestMethod.GET)
       public  String getUsers(ModelMap modelMap){
           List<UserEntity> userList=userRepository.findAll();
           modelMap.addAttribute("userList", userList);
           return "admin/users";
       }

    @RequestMapping(value = "/admin/users/add", method = RequestMethod.GET)
    public String addUser() {
        // 转到 admin/addUser.jsp页面
        return "admin/addUser";
    }

    // post请求，处理添加用户请求，并重定向到用户管理页面
    @RequestMapping(value = "/admin/users/addP", method = RequestMethod.POST)
    public String addUserPost(@ModelAttribute("user") UserEntity userEntity) {

        userRepository.saveAndFlush(userEntity);

        // 重定向到用户管理页面，方法为 redirect:url
        return "redirect:/admin/users";
    }
    // 查看用户详情
// @PathVariable可以收集url中的变量，需匹配的变量用{}括起来
// 例如：访问 localhost:8080/admin/users/show/1 ，将匹配 id = 1
    @RequestMapping(value = "/admin/users/show/{id}", method = RequestMethod.GET)
    public String showUser(@PathVariable("id") Integer userId, ModelMap modelMap) {

        // 找到userId所表示的用户
        UserEntity userEntity = userRepository.findOne(userId);
       // System.out.println(userEntity.getId());
        // 传递给请求页面
        String mname=userEntity.getNickname();
        modelMap.addAttribute("user", userEntity);
        return "admin/userDetail";
    }
    // 更新用户信息 页面
    @RequestMapping(value = "/admin/users/update/{id}", method = RequestMethod.GET)
    public String updateUser(@PathVariable("id") Integer userId, ModelMap modelMap) {

        // 找到userId所表示的用户
        UserEntity userEntity = userRepository.findOne(userId);

        // 传递给请求页面
        modelMap.addAttribute("user", userEntity);
        return "admin/updateUser";
    }

    // 更新用户信息 操作
    @RequestMapping(value = "/admin/users/updateP", method = RequestMethod.POST)
    public String updateUserPost(@ModelAttribute("userP") UserEntity user) {

        // 更新用户信息
        userRepository.updateUser(user.getNickname(), user.getFirstName(),
                user.getLastName(), user.getPassword(), user.getId());
        userRepository.flush(); // 刷新缓冲区
        return "redirect:/admin/users";
    }
    // 删除用户
    @RequestMapping(value = "/admin/users/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") Integer userId) {

        // 删除id为userId的用户
        userRepository.delete(userId);
        // 立即刷新
        userRepository.flush();
        return "redirect:/admin/users";
    }
}
