package cn.edu.cs.database.activatemanage.dao.server;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 查询激活码状态信息
 * 查询激活码使用情况
 */
@Repository
public interface QueryActivationCodeStatusDAO {
    //查询激活了的激活码状态信息通过用户号和激活码
    @MapKey("ainfo_num")
    List<Map> getActivatedActivationCodeStatusByuser_numAndactivation_code(@Param("user_num") int user_num, @Param("activation_code") String activation_code);

    @MapKey("ainfo_num")
    List<Map> getActivationCodeStatusByactivation_code(@Param("activation_code") String activation_code);

    @MapKey("ainfo_num")
    List<Map> getActivationCodeStatusByuser_num(@Param("user_num") int user_num);

}
