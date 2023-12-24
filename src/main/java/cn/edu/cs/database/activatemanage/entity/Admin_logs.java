package cn.edu.cs.database.activatemanage.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

//管理员日志(日志(唯一)编号  int ，日志类型(对应的是哪一项操作的记录)varchar(255)
// ，管理员号 int(外码)，管理员本次操作的结果 varchar(255)，日期 date)
//日期？存为时间戳的话，是不是需要每次都加进来呢？
//Admin_logs(adminlog_num  int ，log_content varchar(255) ,admin_num int，opresult varchar(255)，date date)
//管理员日志(管理员日志号，管理员日志类型，管理员号，管理员本次操作结果，操作时间)
//Admin_logs(adminlog_num ，adminlog_type ，admin_num ，adminlog_result ，adminlog_date)
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Admin_logs {
    private int adminlog_num;
    private String adminlog_type;
    private int admin_num;
    private String adminlog_result;//操作结果
    private String adminlog_date;//操作时间！
}
