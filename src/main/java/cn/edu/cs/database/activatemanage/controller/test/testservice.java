package cn.edu.cs.database.activatemanage.controller.test;


import cn.edu.cs.database.activatemanage.entity.Conadmin;
import cn.edu.cs.database.activatemanage.service.ConadminService;
import cn.edu.cs.database.activatemanage.service.QueryUserAcivation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class testservice {
    @Autowired
    ConadminService conadminService;
    @Autowired
    QueryUserAcivation queryUserAcivation;

    @RequestMapping("/testConadminService/{admin_num}/{admin_pwd}/{root_num}")
    public String testConadminService(@PathVariable int admin_num, @PathVariable String admin_pwd, @PathVariable int root_num) {
        Conadmin conadmin = new Conadmin(admin_num, admin_pwd, root_num);
        conadminService.insert(conadmin);
        return "testConadminService";
    }

    @RequestMapping("/QueryUserAcivation/{user_num}")
    public String testQueryUserAcivation(@PathVariable int user_num) {
        List<Map> res = queryUserAcivation.getUserAcivationByuser_num(user_num);
        for (Map node :
                res) {
            System.out.println(node);
        }
        return "QueryUserAcivation";
    }
}
