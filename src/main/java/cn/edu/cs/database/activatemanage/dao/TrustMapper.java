package cn.edu.cs.database.activatemanage.dao;

import cn.edu.cs.database.activatemanage.entity.Trust;
import org.springframework.stereotype.Repository;

/**
 * Trust类的Mapper接口类
 * 目前感觉只需要提供 insert
 */
@Repository
public interface TrustMapper {
    int getCount();

    int insert(Trust trust);
}
