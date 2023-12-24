package cn.edu.cs.database.activatemanage.dao.server;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Root/Admin 查询用户激活情况
 */
@Repository
public interface QueryUserAcivationDAO {

    //查询用户权限！其中主键为activation_num激活号（吧？）
    @MapKey("activation_num")
    List<Map> getUserAcivationByuser_num(@Param("user_num") int user_num);

    //查询一个用户对某个功能是否激活！
    @MapKey("activation_num")
    List<Map> getUserAcivationByuser_numAndfunc_num(@Param("user_num") int user_num,@Param("func_num") int func_num);
}
