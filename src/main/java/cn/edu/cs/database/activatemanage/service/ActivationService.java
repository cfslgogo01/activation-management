package cn.edu.cs.database.activatemanage.service;

import cn.edu.cs.database.activatemanage.dao.ActivationMapper;
import cn.edu.cs.database.activatemanage.entity.Activation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivationService {
    @Autowired
    ActivationMapper activationMapper;

    public int getCount() {
        return activationMapper.getCount();
    }

    public int insert(Activation activation) {
        return activationMapper.insert(activation);
    }

    public int setuserlog_numByactivation_num(int activation_num, int userlog_num) {
        return activationMapper.setuserlog_numByactivation_num(activation_num, userlog_num);
    }

}
