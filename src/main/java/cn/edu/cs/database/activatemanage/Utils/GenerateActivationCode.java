package cn.edu.cs.database.activatemanage.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class GenerateActivationCode {
    @Autowired
    MyDateTime myDateTime;

    SecureRandom secureRandom;
    @Autowired
    MyMD5 myMD5;

    public GenerateActivationCode() {
        secureRandom = new SecureRandom();
    }

    public String getActivationCode() throws Exception {
        // 生成一个随机整数
        int randomNumber = secureRandom.nextInt();
        String str_txt = myDateTime.getDateTime() + String.valueOf(randomNumber);
        String enc_str_txt = myMD5.getMD5(str_txt);
        return enc_str_txt;
    }
}
