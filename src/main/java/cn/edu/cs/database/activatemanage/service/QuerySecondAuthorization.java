package cn.edu.cs.database.activatemanage.service;

import cn.edu.cs.database.activatemanage.dao.server.QuerySecondAuthorizationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Root/Admin 查询需要第二次授权 的服务类！
 */
@Service
public class QuerySecondAuthorization {
    @Autowired
    QuerySecondAuthorizationDAO querySecondAuthorizationDAO;

    public List<Map> getSecondAuthorization() {
        return querySecondAuthorizationDAO.getSecondAuthorization();
    }
}
