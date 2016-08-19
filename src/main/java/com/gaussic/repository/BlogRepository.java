package com.gaussic.repository;

import com.gaussic.model.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by zhaoli8 on 2016/8/15.
 */
@Repository
public interface BlogRepository extends JpaRepository<BlogEntity, Integer> {
}
