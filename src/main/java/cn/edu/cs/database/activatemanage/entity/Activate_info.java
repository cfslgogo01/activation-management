package cn.edu.cs.database.activatemanage.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

//激活行为：激活行为(激活行为号 int ，开始时间 date，有效时间date，到期时间date，是否有效bool )
//以后每次管理员对激活码的修改都是通过这个来修改的
//感觉是不是加上激活码号和激活码比较号？虽然冗余，但是就不用连接了（在修改和查询的时候？）
//感觉还得加上用户id和功能号，这样就不需要和 激活 进行连接了！
//Activate_behavior(ab_number(int),start_time(datetime), valid_time(datetime), expiration_time(datetime)
// ,is_work(varchar))
//激活信息(激活信息号  ，激活码号，激活码，开始时间数，开始时间 ，有效时间数，到期时间数，到期时间，是否有效 )
//Activate_info(info_num,code_num,activation_code,
// start_time_num ,start_time ,valid_time_num , expiration_time_num ,expiration_time ,is_work)
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Activate_info {
    
    private int ainfo_num;//激活信息号
    private int code_num;//激活码号
    private String activation_code;//激活码
    private long start_time_num;//开始时间**
    private int start_time;//
    private long valid_time_num;//到期时间**
    private long expiration_time_num;//到期时间**
    private String expiration_time;//是否有效！
    private String is_work;//是否有效！


}
