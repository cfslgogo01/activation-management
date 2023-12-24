package cn.edu.cs.database.activatemanage.entity;

//委托(root号 int，管理员号 int ，管理员日志编号 int )
//创建管理员的操作！
//Trust(rootuum int，admin_num int ，adminlog_num int )

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

//委托(委托号，超级管理员号，普通管理员号，管理员日志号)
//Trust(trust_num，root_num ，admin_num，adminlog_num )
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Trust {
    private int trust_num;
    private int root_num;
    private int admin_num;
    private int adminlog_num;
}
