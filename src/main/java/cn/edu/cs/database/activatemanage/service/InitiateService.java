package cn.edu.cs.database.activatemanage.service;

import cn.edu.cs.database.activatemanage.dao.InitiateMapper;
import cn.edu.cs.database.activatemanage.entity.Initiate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitiateService {


    @Autowired
    InitiateMapper initiateMapper;

    public int getCount() {
        return initiateMapper.getCount();
    }

    public int setadmin_num_twoForInitiateByinitiate_num(int admin_num_two, int initiate_num) {
        return initiateMapper.setadmin_num_twoForInitiateByinitiate_num(admin_num_two, initiate_num);
    }

    public int insert(Initiate initiate) {
        return initiateMapper.insert(initiate);
    }

    public int insertOnceAdminInitiate(int initiate_num, int admin_num_one, int change_num, int adminlog_num) {
        return initiateMapper.insertOnceAdminInitiate(initiate_num, admin_num_one, change_num, adminlog_num);
    }
}
