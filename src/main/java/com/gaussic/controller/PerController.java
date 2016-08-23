package com.gaussic.controller;
import com.gaussic.model.BlogEntity;
import com.gaussic.model.PermissionEntity;
import com.gaussic.repository.BlogRepository;
import com.gaussic.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
/**
 * Created by zhaoli8 on 2016/8/22.
 */
//public class PerController {
//    @Autowired
//    PermissionRepository permission;
//
//    // 查看所有博文
//    @RequestMapping(value = "/admin/addPermission", method = RequestMethod.GET)
//    public String showBlogs(ModelMap modelMap) {
//        List<PermissionEntity> permissionList = permission.findAll();
//        modelMap.addAttribute("permissionList", permissionList);
//
//        return "admin/addM";
//
//    }
//}
