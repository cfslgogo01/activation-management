package cn.edu.cs.database.activatemanage.entity;

//生成2(管理员号 int，激活码号 int ，管理员日志编号 int )
//Createtwo(admin_num int，actioncno int ，adminlog_num int )

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

//生成激活码2(生成号2，普通管理员号 ，激活码号 ，管理员日志号 )
//Generate_two(generate2_num,admin_num ，code_num ，adminlog_num  )
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Generate_two {
    private int generate2_num;
    private int admin_num;
    private int code_num;//**这个码错了
    private int adminlog_num;//**

}
