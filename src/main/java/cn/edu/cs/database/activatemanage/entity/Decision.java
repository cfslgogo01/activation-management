package cn.edu.cs.database.activatemanage.entity;

//决定(管理员日志号int，RootNum int，修改号int，决定号 int)
//适用于root用户的那个操作！！
//Decision(adminlog_num int，rootnum int，c_num int，decision_num int)

//决定(决定号 ，超级管理员号，修改号，管理员日志号)
//Decision(decision_num  ，root_num ，change_num ， adminlog_num )

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Decision {
    private int decision_num;//决定号
    private int root_num;
    private int change_num;//**修改号，改变了！！
    private int adminlog_num;
}
