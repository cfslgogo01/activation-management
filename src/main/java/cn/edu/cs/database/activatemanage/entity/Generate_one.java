package cn.edu.cs.database.activatemanage.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

//生成1(管理员日志号 int ，root号 int，激活码号 int)
//Createone(adminlog_num int ，rootnum int，a_number int)
//生成激活码1(生成号1，超级管理员号，激活码号，管理员日志号)
//Generate_one(generate1_num,root_num ，code_num ，adminlog_num )
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Generate_one {
    private int generate1_num;
    private int root_num;
    private int code_num;//激活码号
    private int adminlog_num;
}
