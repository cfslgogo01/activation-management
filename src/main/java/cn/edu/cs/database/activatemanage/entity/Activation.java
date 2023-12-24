package cn.edu.cs.database.activatemanage.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

//激活(激活号int，激活码号 int(外码)，激活行为号 int(外码) ，用户号int (外码)，功能号 int(外码) ，用户日志号 int(外码))
//记录一次用户的激活绑定信息！但是不包括激活时间啥的，因为放到了激活行为那里
//Activation(a_number(int),code_number(int)   ,ab_number(int)， u_number int ,  f_number int , ul_number int )
//激活(激活号，用户号，激活码号，功能号，激活信息号，用户日志号)
//Activation(activation_num，user_num, code_num ，func_num , ainfo_num， userlog_num )
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Activation {
    private int activation_num;//激活号
    private int user_num;//用户号
    private int code_num;//激活码号
    private int func_num;//功能号
    private int ainfo_num;//激活信息号
    private int userlog_num;//用户日志号
}
