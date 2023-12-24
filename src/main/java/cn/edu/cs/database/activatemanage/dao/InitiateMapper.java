package cn.edu.cs.database.activatemanage.dao;

import cn.edu.cs.database.activatemanage.entity.Initiate;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Initiate 发起
 * 需要更新
 */
@Repository
public interface InitiateMapper {
    int getCount();

    int setadmin_num_twoForInitiateByinitiate_num(@Param("admin_num_two") int admin_num_two, @Param("initiate_num") int initiate_num);

    //插入一条 Initiate 发起
    int insert(Initiate initiate);

    int insertOnceAdminInitiate(@Param("initiate_num")int initiate_num,
                                @Param("admin_num_one")int admin_num_one,
//                                @Param("admin_num_two")int admin_num_two,
                                @Param("change_num")int change_num,
                                @Param("adminlog_num")int adminlog_num);
}
