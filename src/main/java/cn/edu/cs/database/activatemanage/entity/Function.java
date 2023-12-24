package cn.edu.cs.database.activatemanage.entity;

//功能(功能号 int ，功能名 varchar(255) ，是否免费 varchar)
//Function(f_number(int) , f_name varchar(255) ,is_free(varchar))

import cn.edu.cs.database.activatemanage.annotation.MyClassInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import static cn.edu.cs.database.activatemanage.annotation.MyClassInfo.Status.未使用;

//功能(功能号 ，功能名 ，是否免费)
//Function(func_num，func_name ，is_free)
@MyClassInfo(status = 未使用)
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Function {
    private int func_num;
    private String func_name;
    private String is_free;
}
