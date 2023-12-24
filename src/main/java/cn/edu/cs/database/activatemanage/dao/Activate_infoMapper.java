package cn.edu.cs.database.activatemanage.dao;

import cn.edu.cs.database.activatemanage.entity.Activate_info;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Activate_info激活信息
 * 需要进行插入、修改
 */
@Repository
public interface Activate_infoMapper {
    int getCount();

    int insert(Activate_info activate_info);

    int insertOnce(int ainfo_num,//激活信息号
                   int code_num,//激活码号
                   String activation_code,//激活码
                   long valid_time_num,//有效时间
                   String is_work);

    int insertOnceDefault(int ainfo_num,//激活信息号
                   int code_num,//激活码号
                   String activation_code,//激活码
                   long valid_time_num,//有效时间
                   String is_work);

    int setvalid_time_numForActivate_infoByainfo_num(@Param("valid_time_num")

                                                             long valid_time_num,
                                                     @Param("ainfo_num")
                                                             int ainfo_num);

    //修改有效情况is_work 通过 激活信息号ainfo_num
    int setis_workForActivate_infoByainfo_num(@Param("is_work") String is_work, @Param("ainfo_num") int ainfo_num);

    //修改开始时间start_time 通过 激活信息号ainfo_num
    int setstart_timeForActivate_infoByainfo_num(@Param("start_time") String start_time, @Param("ainfo_num") int ainfo_num);

    //修改开始时间数start_time_num 通过 激活信息号ainfo_num
    int setstart_time_numForActivate_infoByainfo_num(@Param("start_time_num") long start_time_num, @Param("ainfo_num") int ainfo_num);

}
