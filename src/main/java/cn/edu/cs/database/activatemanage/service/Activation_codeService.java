package cn.edu.cs.database.activatemanage.service;

import cn.edu.cs.database.activatemanage.dao.Activation_codeMapper;
import cn.edu.cs.database.activatemanage.entity.Activation_code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Activation_codeService {
    @Autowired
    Activation_codeMapper activation_codeMapper;

    public int getCount() {
        return activation_codeMapper.getCount();
    }

    public int insert(Activation_code activation_code) {
        return activation_codeMapper.insert(activation_code);
    }
}
