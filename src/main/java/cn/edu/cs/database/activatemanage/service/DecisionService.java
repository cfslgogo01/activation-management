package cn.edu.cs.database.activatemanage.service;

import cn.edu.cs.database.activatemanage.dao.DecisionMapper;
import cn.edu.cs.database.activatemanage.entity.Decision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DecisionService {
    @Autowired
    DecisionMapper decisionMapper;
    public int getCount() {
        return decisionMapper.getCount();
    }
    public int insert(Decision decision) {
        return decisionMapper.insert(decision);
    }
}
