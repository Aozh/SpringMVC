package com.gaussic.repository;


import com.gaussic.model.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhaoli8 on 2016/8/22.
 */
@Repository
public interface PermissionRepository extends JpaRepository<PermissionEntity, Integer >{

//@Modifying      // 说明该方法是修改操作
//@Transactional  // 说明该方法是事务性操作
//// 定义查询
//// @Param注解用于提取参数
//@Query("update PermissionEntity us set us.pin=:pin, us.add=:add, us.show=:show, us.delete=:delete where us.pin=:pin")
//public void updateUser(@Param("pin") String pin, @Param("add") int add,
//@Param("show") String show, @Param("delete") String delete);
        }
