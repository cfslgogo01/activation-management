package cn.edu.cs.database.activatemanage.service;

import cn.edu.cs.database.activatemanage.dao.Activate_infoMapper;
import cn.edu.cs.database.activatemanage.entity.Activate_info;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Activate_infoService {


    @Autowired
    Activate_infoMapper activate_infoMapper;

    public int getCount() {
        return activate_infoMapper.getCount();
    }

    public int insert(Activate_info activate_info) {
        return activate_infoMapper.insert(activate_info);
    }
    public int insertOnce(int ainfo_num, int code_num, String activation_code, long valid_time_num, String is_work) {
        return activate_infoMapper.insertOnce(ainfo_num, code_num, activation_code, valid_time_num, is_work);
    }
    //修改有效时间valid_time_num 通过 激活信息号ainfo_num
    public int setvalid_time_numForActivate_infoByainfo_num(@Param("valid_time_num") long valid_time_num, @Param("ainfo_num") int ainfo_num) {
        return activate_infoMapper.setvalid_time_numForActivate_infoByainfo_num(valid_time_num, ainfo_num);
    }

    //修改有效情况is_work 通过 激活信息号ainfo_num
    public int setis_workForActivate_infoByainfo_num(@Param("is_work") String is_work, @Param("ainfo_num") int ainfo_num) {
        return activate_infoMapper.setis_workForActivate_infoByainfo_num(is_work, ainfo_num);
    }

    //修改开始时间start_time 通过 激活信息号ainfo_num
    public int setstart_timeForActivate_infoByainfo_num(@Param("start_time") String start_time, @Param("ainfo_num") int ainfo_num) {
        return activate_infoMapper.setstart_timeForActivate_infoByainfo_num(start_time, ainfo_num);
    }

    //修改开始时间数start_time_num 通过 激活信息号ainfo_num
    public int setstart_time_numForActivate_infoByainfo_num(@Param("start_time_num") long start_time_num, @Param("ainfo_num") int ainfo_num) {
        return activate_infoMapper.setstart_time_numForActivate_infoByainfo_num(start_time_num, ainfo_num);
    }

}
