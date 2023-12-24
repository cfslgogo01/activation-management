package cn.edu.cs.database.activatemanage.entity;

import cn.edu.cs.database.activatemanage.annotation.MyClassInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import static cn.edu.cs.database.activatemanage.annotation.MyClassInfo.Status.未使用;

//管理员登录检验(日期，登录编号，管理员号 int，激活行为号 int ，检验结果 bool，管理员日志号 int)
//选择了激活行为号，？呃呃呃，可以是可以，但是激活行为号里面冗余太少了，感觉多一些比较好？！！
//管理员检验不需要激活行为！！！ab_number int ，
//Admin_login_detection(date，adminlogin_num，admin_num int，result bool，adminlog_num int)
//管理员登录检验(管理员登录检验号，管理员号，检验结果，管理员登录日期，管理员日志号)
//Admin_login_detection(adminlogin_num，admin_num，adminlogin_result，adminlogin_date，adminlog_num)
@MyClassInfo(status = 未使用)
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Admin_login_detection {
    private int adminlogin_num;//登录编号
    private int admin_num;//管理员号
    private String adminlogin_result;
    private String login_date;
    private int adminlog_num;//管理员日志号

}
