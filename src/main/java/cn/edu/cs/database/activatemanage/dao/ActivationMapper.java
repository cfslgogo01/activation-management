package cn.edu.cs.database.activatemanage.dao;

import cn.edu.cs.database.activatemanage.entity.Activation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivationMapper {
    int getCount();

    int insert(Activation activation);

    int setuserlog_numByactivation_num(@Param("activation_num") int activation_num, @Param("userlog_num") int userlog_num);
}
