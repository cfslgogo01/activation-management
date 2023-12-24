package cn.edu.cs.database.activatemanage.entity;

import cn.edu.cs.database.activatemanage.annotation.MyClassInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import static cn.edu.cs.database.activatemanage.annotation.MyClassInfo.Status.未使用;

//用户(用户号 int，密码 varchar(32) )
//User(u_number(int), u_password(varchar(32))
//用户( 用户号，密码 )
//User( user_num, user_pwd)

/**
 * 用户类
 * 当前未使用
 */
@MyClassInfo(status = 未使用)
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private int user_num;
    private String user_pwd;
}
