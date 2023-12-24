package cn.edu.cs.database.activatemanage.entity;

//对应关系和修改合并
//修改(修改号int，修改类型号int(指明是哪种操作 是“有效时间”还是“功能当前是否仍然有效”)
//，旧值date，新值date，激活行为号int(外码))
//Change(c_number(int),c_type_number(int), old_value(varchar), new_value(varchar),   ab_number(int))
//修改(修改号，修改类型号(指明是哪种操作 是“有效时间”还是“功能当前是否仍然有效”) ，旧值，新值，激活信息号)
//Change(change_num，c_type_num， old_value, new_value, ainfo_num,)

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Change {
    private int change_num;//修改 号
    private int c_type_num;//修改类型号
    private String old_value;//旧值
    private String new_value;//新值
    private int ainfo_num;//激活行为号
    public class change_type_num{
//        valid_time_num(1),
//        FAILURE(2);
        public static final int  type_num_valid_time_num=1;
        public static final int  type_num_is_work=2;
//        change_type_num(int i) {
//        }
    };

}

