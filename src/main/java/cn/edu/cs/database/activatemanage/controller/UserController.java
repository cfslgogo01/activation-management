package cn.edu.cs.database.activatemanage.controller;

import cn.edu.cs.database.activatemanage.Utils.GenerateActivationCode;
import cn.edu.cs.database.activatemanage.Utils.JsonArrayToIntegerArray;
import cn.edu.cs.database.activatemanage.Utils.MyDateTime;
import cn.edu.cs.database.activatemanage.common.enums.MyResponseStatus;
import cn.edu.cs.database.activatemanage.entity.User_logs;
import cn.edu.cs.database.activatemanage.service.*;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Api(value = "user接口", tags = {"user操作接口"})
/**
 * 激活
 * 登录
 * 检验
 * 查询
 */

public class UserController {

    @Autowired
    MyDateTime myDateTime;
    @Autowired
    GenerateActivationCode generateActivationCode;
    @Autowired
    JsonArrayToIntegerArray jsonArrayToIntegerArray;
    @Autowired
    ConadminService conadminService;
    @Autowired
    TrustService trustService;
    @Autowired
    Admin_logsService admin_logsService;

    @Autowired
    QueryUserAcivation queryUserAcivation;
    @Autowired
    Activation_codeService activation_codeService;
    @Autowired
    Generate_oneService generate_oneService;
    @Autowired
    Generate_twoService generate_twoService;
    @Autowired
    ActivationService activationService;
    @Autowired
    Activate_infoService activate_infoService;
    @Autowired
    InitiateService initiateService;
    @Autowired
    ChangeService changeService;
    @Autowired
    User_logsService user_logsService;
    @Autowired
    QueryActivationCodeStatus queryActivationCodeStatus;
    @Autowired
    QuerySecondAuthorization querySecondAuthorization;
    @Autowired
    QueryFunctionCanBeActivated queryFunctionCanBeActivated;

    @GetMapping("/queryFunctionCanBeActivated")
    @ApiOperation(value = "用户查询当前激活码还可以激活什么功能", notes = "用户查询当前激活码还可以激活什么功能")
    @Transactional
    public String queryFunctionCanBeActivated(
            @ApiParam(value = "user号", required = true) @RequestParam int user_num,
            @ApiParam(value = "激活码", required = true) @RequestParam String activation_code
    ) {
        return JSON.toJSONString(queryFunctionCanBeActivated.getFunctionCanBeActivatedByuser_numAndcode_num(
                user_num,
                activation_code
        ));
    }

    @GetMapping("/activateFuncsByactivation_code")
    @ApiOperation(value = "用户通过选择进行功能激活", notes = "用户激活某些功能")
    @Transactional
    public String activateFuncsByactivation_code(
            @ApiParam(value = "user号", required = true) @RequestParam int user_num,
            @ApiParam(value = "激活号和激活信息号", required = true) @RequestParam String activation_info
//            @ApiParam(value = "激活号", required = true) @RequestParam String activation_nums,
//            @ApiParam(value = "激活信息号", required = true) @RequestParam String ainfo_nums
    ) {
//        getObjectArray

        ArrayList<Integer> ainfo_num_Array = jsonArrayToIntegerArray.getIntegerArrayOnDataByKey(activation_info,"data","ainfo_num");
        ArrayList<Integer> activation_num_Array = jsonArrayToIntegerArray.getIntegerArrayOnDataByKey(activation_info,"data","activation_num");
        int userlog_num = user_logsService.getCount() + 1;
        if(ainfo_num_Array.size()!=activation_num_Array.size()){
            //如果不同则错了，返回错的！
            return MyResponseStatus.fail.toString();
        }
        for (int i = 0; i < ainfo_num_Array.size(); i++) {
            int ainfo_num = ainfo_num_Array.get(i);
            int activation_num = activation_num_Array.get(i);
            activate_infoService.setstart_time_numForActivate_infoByainfo_num(
                    myDateTime.getDateTime_num(),
                    ainfo_num
            );
            activationService.setuserlog_numByactivation_num(activation_num, userlog_num);
            user_logsService.insert(
                    new User_logs(
                            userlog_num,
                            "用户激活功能",
                            user_num,
                            "用户" + String.valueOf(user_num) + "激活了" + String.valueOf(ainfo_num) + "的功能",
                            myDateTime.getDateTime()
                    )
            );
            userlog_num++;
        }
        return MyResponseStatus.ok.toString();
    }

    @GetMapping("/queryUser_logs")
    @ApiOperation(value = "查询自己的日志", notes = "普通用户只能查自己的日志！")
    @Transactional
    public String queryUser_logs(
            int user_num
    ) {
        return JSON.toJSONString(user_logsService.getUser_logsByuser_num(user_num));
    }

    @GetMapping("/userlogin_detection")
    @ApiOperation(value = "用户的登录检验", notes = "查询一个用户对某个功能是否激活！！")
    @Transactional
    public String userlogin_detection(
            int user_num,
            int func_num
    ) {
        List<Map> userAcivationByuser_numAndfunc_num = queryUserAcivation.getUserAcivationByuser_numAndfunc_num(user_num, func_num);
        int userlog_num = user_logsService.getCount() + 1;

        if (userAcivationByuser_numAndfunc_num.size() >= 0) {

            for (int i = 0; i < userAcivationByuser_numAndfunc_num.size(); i++) {
                if (((String) userAcivationByuser_numAndfunc_num.get(i).get("is_free")).equals(new String("true"))) {
                    user_logsService.insert(
                            new User_logs(
                                    userlog_num,
                                    "用户登录检验",
                                    user_num,
                                    "登录成功",
                                    myDateTime.getDateTime()
                            )
                    );
                    return MyResponseStatus.ok.toString();
                }
                try {
                    long expiration_time_num = (long) userAcivationByuser_numAndfunc_num.get(i).get("expiration_time_num");
                    if (expiration_time_num > myDateTime.getDateTime_num()) {
                        user_logsService.insert(
                                new User_logs(
                                        userlog_num,
                                        "用户登录检验",
                                        user_num,
                                        "登录成功",
                                        myDateTime.getDateTime()
                                )
                        );
                        return MyResponseStatus.ok.toString();
                    }
                } catch (Exception e) {
                    System.out.println(e);
                    continue;
                }
            }

        }
        user_logsService.insert(
                new User_logs(
                        userlog_num,
                        "用户登录检验",
                        user_num,
                        "用户登录检验失败",
                        myDateTime.getDateTime()
                )
        );
        return MyResponseStatus.fail.toString();


    }

    @GetMapping("/queryUserAcivation")
    @ApiOperation(value = "用户查询自己的激活信息", notes = "用户查询自己的激活信息")
    @Transactional
    public String queryUserAcivation(@ApiParam(value = "user号", required = true) @RequestParam int user_num
    ) {
        List<Map> maps = queryUserAcivation.getUserAcivationByuser_num(user_num);
        return JSON.toJSONString(maps);
    }
}
