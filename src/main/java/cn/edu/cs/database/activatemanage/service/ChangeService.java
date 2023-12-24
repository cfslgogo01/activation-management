package cn.edu.cs.database.activatemanage.service;

import cn.edu.cs.database.activatemanage.dao.ChangeMapper;
import cn.edu.cs.database.activatemanage.entity.Change;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChangeService {
    @Autowired
    ChangeMapper changeMapper;
    public int getCount() {
        return changeMapper.getCount();
    }
    public int insert(Change change) {
        return changeMapper.insert(change);
    }
}
