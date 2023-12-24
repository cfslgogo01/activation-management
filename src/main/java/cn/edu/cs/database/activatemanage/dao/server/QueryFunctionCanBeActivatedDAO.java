package cn.edu.cs.database.activatemanage.dao.server;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 查询可以激活的功能
 */
@Repository
public interface QueryFunctionCanBeActivatedDAO {
    //查询可以激活的功能通过用户号和激活码！主码为ainfo_num，因为一个激活码可以对应多个功能，一个功能也可能被多个激活码激活！
    @MapKey("ainfo_num")
    List<Map> getFunctionCanBeActivatedByuser_numAndcode_num(@Param("user_num") int user_num, @Param("activation_code") String activation_code);
}
