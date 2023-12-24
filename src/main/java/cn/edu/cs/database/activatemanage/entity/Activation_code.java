package cn.edu.cs.database.activatemanage.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

//激活码(激活码号int，激活码 varchar(255) )
//Activation_code(code_number(int), activation_code (varchar(255))
//激活码(激活码号，激活码)
//Activation_code( code_num, activation_code)
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Activation_code {
    private int code_num;
    private String activation_code;
}
