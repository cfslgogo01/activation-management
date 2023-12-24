package cn.edu.cs.database.activatemanage.service;

import cn.edu.cs.database.activatemanage.dao.ConadminMapper;
import cn.edu.cs.database.activatemanage.entity.Conadmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 普通管理员服务类
 */
@Service
public class ConadminService {
    @Autowired
    ConadminMapper conadminMapper;
    public int getCount() {
        return conadminMapper.getCount();
    }
    public int insert(Conadmin conadmin) {
        return conadminMapper.insert(conadmin);
    }
}
