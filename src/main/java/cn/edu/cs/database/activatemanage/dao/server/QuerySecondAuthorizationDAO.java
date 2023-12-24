package cn.edu.cs.database.activatemanage.dao.server;

import org.apache.ibatis.annotations.MapKey;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Root/Admin 查询需要第二次授权
 */
@Repository
public interface QuerySecondAuthorizationDAO {
    //查询需要第二次授权的信息，其中主键为initiate_num发起号
    @MapKey("initiate_num")
    List<Map> getSecondAuthorization();
}
