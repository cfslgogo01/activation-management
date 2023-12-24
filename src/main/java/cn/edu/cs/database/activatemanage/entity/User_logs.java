package cn.edu.cs.database.activatemanage.entity;
//用户日志((用户日志号(唯一) int，用户日志类型(对应的是哪一项操作的记录)char ，用户号 int(外码)，操作结果 char ，操作时间date)
//是不是加上对应的那个 操作号 比较好？
//User_log(ul_number(int), ul_type(varchar), u_number(int) , operation_result(varchar), operation_time(datetime))

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

//用户日志((用户日志号，用户日志类型(对应的是哪一项操作的记录) ，用户号 ，用户本次操作结果 ，操作时间)
//User_logs(userlog_num,userlog_type,user_num,userlog_result,userlog_date)

/**
 * 用户日志类
 */
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class User_logs {
    private int userlog_num;//这个好！
    private String userlog_type;
    private int user_num;
    private String userlog_result;
    private String userlog_date;
}
