package cn.edu.cs.database.activatemanage.entity;


import cn.edu.cs.database.activatemanage.annotation.MyClassInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import static cn.edu.cs.database.activatemanage.annotation.MyClassInfo.Status.未使用;

//用户登录检验(用户登录检验号int，用户号int(外码)，激活行为号 int (外码)，检验结果 bool，用户日志号 int(外码))
//User_login_check(ulc_number(int), u_number(int),  ab_number(int), check_result(varchar),
// ul_number(int)   )
//用户登录检验(用户登录检验号，用户号，激活信息号 ，检验结果 ，用户登录日期，用户日志号)
//User_login_detection(userlogin_num,user_num,ainfo_num,userlogin_result,
//userlogin_date, userlog_num)

/**
 * 用户登录检验类
 */
@MyClassInfo(status = 未使用)
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class User_login_detection {
    private int user_num;
    private int userlogin_num;
    private int ainfo_num;
    private String userlogin_result;
    private String userlogin_date;
    private String userlog_num;
}
