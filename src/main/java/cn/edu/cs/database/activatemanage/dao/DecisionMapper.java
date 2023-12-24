package cn.edu.cs.database.activatemanage.dao;

import cn.edu.cs.database.activatemanage.entity.Decision;
import org.springframework.stereotype.Repository;

/**
 * Decision 决定 类的Mapper接口类
 * 提供插入方法
 */
@Repository
public interface DecisionMapper {
    int getCount();

    //插入一个 决定 decision
    int insert(Decision decision);
}
