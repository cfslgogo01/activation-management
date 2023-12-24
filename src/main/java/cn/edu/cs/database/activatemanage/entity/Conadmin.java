package cn.edu.cs.database.activatemanage.entity;

//普通管理员(管理员号(账号)int ，密码 int ，root号 int )
//Conadmin(admin_num int ，pwd varchar(32) ，rootnum int )

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Conadmin {
    private int admin_num;
    private String admin_pwd;
    private int root_num;
}
