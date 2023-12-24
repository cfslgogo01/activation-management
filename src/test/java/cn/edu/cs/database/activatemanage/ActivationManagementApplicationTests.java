package cn.edu.cs.database.activatemanage;

import cn.edu.cs.database.activatemanage.Utils.JsonArrayToIntegerArray;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class ActivationManagementApplicationTests {
    @Autowired
    JsonArrayToIntegerArray jsonArrayToIntegerArray;
    @Test
    void contextLoads() {
//        ArrayList<Integer> integerArrayOnDataByKey = jsonArrayToIntegerArray.getIntegerArrayOnDataByKey(
////                "{\"data\":[{\"ainfo_num\":40,\"activation_num\":40,\"func_num\":2,\"func_name\":\"Saito Akina\"}]}",
//                "{\"data\":[{\"ainfo_num\":40,\"activation_num\":40,\"func_num\":2,\"func_name\":\"Saito Akina\"},{\"ainfo_num\":41,\"activation_num\":41,\"func_num\":54,\"func_name\":\"Arthur Wallace\"}]}",
//                "data",
//                "ainfo_num"
//        );
//        System.out.println(integerArrayOnDataByKey);
    }

}
