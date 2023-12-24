package cn.edu.cs.database.activatemanage.entity;

//Root(root号 int ，密码 varchar(255)(20) )
//Root(rootnum int ，pwd varchar(32) )

import cn.edu.cs.database.activatemanage.annotation.MyClassInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import static cn.edu.cs.database.activatemanage.annotation.MyClassInfo.Status.未使用;

//超级管理员(超级管理员号，密码)
//Root(root_num，root_pwd)
@MyClassInfo(status = 未使用)
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
    private int root_num;
    private String root_pwd;//
}
