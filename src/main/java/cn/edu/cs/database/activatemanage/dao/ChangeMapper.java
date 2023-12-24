package cn.edu.cs.database.activatemanage.dao;

import cn.edu.cs.database.activatemanage.entity.Change;
import org.springframework.stereotype.Repository;

/**
 * Change 修改 类的Mapper接口类
 * 提供插入方法
 */
@Repository
public interface ChangeMapper {
    int getCount();

    //插入一个 修改 Change
    int insert(Change change);
}
