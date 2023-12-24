package cn.edu.cs.database.activatemanage.entity;

//发起(管理员号一int，管理员号二int，修改号int，管理员日志号 int,发起号 int)
//Initiate(admin_numone int，admin_numtwo  int，changenum int，adminlognum int,
//initiatenum  int)

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

//发起(发起号 ，管理员号一，管理员号二，修改号，管理员日志号 )
//Initiate(initiate_num ，admin_num_one ，admin_num_two ，change_num ，adminlog_num )
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Initiate {
    private int initiate_num;
    private int admin_num_one;//**
    private int admin_num_two;//**
    private int change_num;//**
    private int adminlog_num;//**
}
