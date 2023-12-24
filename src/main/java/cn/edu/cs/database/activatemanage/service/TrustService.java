package cn.edu.cs.database.activatemanage.service;

import cn.edu.cs.database.activatemanage.dao.TrustMapper;
import cn.edu.cs.database.activatemanage.entity.Trust;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrustService {
    @Autowired
    TrustMapper trustMapper;
    public int getCount() {
        return trustMapper.getCount();
    }
    public int insert(Trust trust) {
        return trustMapper.insert(trust);
    }
}
