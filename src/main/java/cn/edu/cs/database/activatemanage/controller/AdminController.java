package cn.edu.cs.database.activatemanage.controller;

import cn.edu.cs.database.activatemanage.Utils.GenerateActivationCode;
import cn.edu.cs.database.activatemanage.Utils.JsonArrayToIntegerArray;
import cn.edu.cs.database.activatemanage.Utils.MyDateTime;
import cn.edu.cs.database.activatemanage.common.enums.MyResponseStatus;
import cn.edu.cs.database.activatemanage.entity.*;
import cn.edu.cs.database.activatemanage.service.*;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
@Api(value = "admin接口", tags = {"admin操作接口"})
public class AdminController {
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
    FunctionService functionService;
    @Autowired
    QueryActivationCodeStatus queryActivationCodeStatus;
    @Autowired
    QuerySecondAuthorization querySecondAuthorization;

    @GetMapping("/generateActivationcode")
    @ApiOperation(value = "生成单个激活码", notes = "管理员为用户user_num生成激活码")
    @Transactional
    public String generateActivationcode(
            @ApiParam(value = "user号", required = true) @RequestParam int user_num,
            @ApiParam(value = "Func号", required = true) @RequestParam int func_num,
            @ApiParam(value = "有效时间数", required = true) @RequestParam long vaild_time_num,
            @ApiParam(value = "管理员号", required = true) @RequestParam int admin_num
    ) {
        String func_nums = "{\"data\":[" + String.valueOf(func_num) + "]}";
        return generateActivationcodeToFuncs(user_num,
                func_nums,
                vaild_time_num,
                admin_num
        );

    }

    @GetMapping("/generateActivationcodeToFuncs")
    @ApiOperation(value = "为多个功能生成激活码", notes = "管理员为用户user_num生成多个功能的激活码")
    @Transactional
    public String generateActivationcodeToFuncs(
            @ApiParam(value = "user号", required = true) @RequestParam int user_num,
            @ApiParam(value = "Func号", required = true) @RequestParam String func_nums,
            @ApiParam(value = "有效时间数", required = true) @RequestParam long vaild_time_num,
            @ApiParam(value = "管理员号", required = true) @RequestParam int admin_num
    ) {
        int code_num = activation_codeService.getCount() + 1;
        int count_generate_one = generate_twoService.getCount() + 1;
        int adminlog_num = admin_logsService.getCount() + 1;
        int activation_num = activationService.getCount() + 1;
        int ainfo_num = activate_infoService.getCount() + 1;
        String activationCode =null;
        try {
            activationCode = generateActivationCode.getActivationCode();
            //激活码表
            activation_codeService.insert(
                    new Activation_code(
                            code_num,
                            activationCode
                    ));
            //生成二
            generate_twoService.insert(new Generate_two(count_generate_one,
                    admin_num,
                    code_num,
                    adminlog_num
            ));
            ArrayList<Integer> funcArray = jsonArrayToIntegerArray.getIntegerArray(func_nums);
            for (int i = 0; i < funcArray.size(); i++) {
                int func_num = funcArray.get(i);
                //激活
                activationService.insert(new Activation(
                        activation_num,
                        user_num,
                        code_num,
                        func_num,
                        ainfo_num,
                        0
                ));
                //激活信息
                activate_infoService.insertOnce(
                        ainfo_num,
                        code_num,
                        activationCode,
                        vaild_time_num,
                        "true"
                );
                //管理员日志
                admin_logsService.insert(new Admin_logs(
                        adminlog_num
                        , "管理员生成激活码",
                        admin_num,
                        "管理员" + String.valueOf(admin_num) + "为用户" + String.valueOf(user_num) + "生成激活码" + activationCode + "对应功能" + String.valueOf(func_num),
                        myDateTime.getDateTime()
                ));
                activation_num++;
                ainfo_num++;
                adminlog_num++;
            }

        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return MyResponseStatus.fail.toString();
        }
        return activationCode;

    }

    @GetMapping("/queryUserAcivation")
    @ApiOperation(value = "管理员查询用户激活信息", notes = "查询用户所有拥有的激活信息，可能没有激活过，也可能已经激活了，\n可能是免费的，也可能是收费的，不管那个，只管有过类似的激活信息就算！")
    @Transactional
    public String queryUserAcivation(@ApiParam(value = "user号", required = true) @RequestParam int user_num
    ) {
        List<Map> maps = queryUserAcivation.getUserAcivationByuser_num(user_num);
        return JSON.toJSONString(maps);
    }

    @GetMapping("/querySecondAuthorization")
    @ApiOperation(value = "管理员查询需要第二认证的", notes = "管理员去查看需要认证的，只查询，不修改！")
    @Transactional
    public String querySecondAuthorization() {
        List<Map> maps = querySecondAuthorization.getSecondAuthorization();
        return JSON.toJSONString(maps);
    }

    @GetMapping("/agreeOthersInitiate")
    @ApiOperation(value = "管理员同意其他人的发起", notes = "会把旧值改为新值，并写上自己的admin_num")
    @Transactional
    public String agreeOthersInitiate(
            @ApiParam(value = "管理员号", required = true) @RequestParam int admin_num,
            @ApiParam(value = "initiate发起号", required = true) @RequestParam int initiate_num,
            @ApiParam(value = "修改种类号1为时间，2为is(字符串形式)", required = true) @RequestParam int c_type_num,
            @ApiParam(value = "旧的值", required = true) @RequestParam String old_value,
            @ApiParam(value = "新的值", required = true) @RequestParam String new_value,
            @ApiParam(value = "激活信息号", required = true) @RequestParam int ainfo_num
    ) {
        int adminlog_num = admin_logsService.getCount() + 1;
        initiateService.setadmin_num_twoForInitiateByinitiate_num(
                admin_num,
                initiate_num
        );
        admin_logsService.insert(
                new Admin_logs(
                        adminlog_num,
                        "管理员同意了一条 发起",
                        admin_num,
                        "将" + String.valueOf(old_value) + "修改为了" + String.valueOf(new_value),
                        myDateTime.getDateTime()
                ));
        switch (c_type_num) {
            case Change.change_type_num.type_num_valid_time_num: {
                activate_infoService.setvalid_time_numForActivate_infoByainfo_num(
                        Long.parseLong(new_value),
                        ainfo_num
                );
                break;
            }
            case Change.change_type_num.type_num_is_work: {
                activate_infoService.setis_workForActivate_infoByainfo_num(
                        new_value,
                        ainfo_num
                );
                break;
            }
        }

        return MyResponseStatus.ok.toString();
    }

    @GetMapping("/queryConAdminLogs")
    @ApiOperation(value = "管理员去查询管理员身份的管理员日志", notes = "管理员只能查看普通管理员的操作日志，不能查看root的")
    @Transactional
    public String queryConAdminLogs(
    ) {
        return JSON.toJSONString(admin_logsService.getConAdminLogs());
    }

    @GetMapping("/queryUser_logs")
    @ApiOperation(value = "root查询所有用户的日志", notes = "root查询所有用户的日志！")
    @Transactional
    public String queryUser_logs(

    ) {
        return JSON.toJSONString(user_logsService.getAll());
    }

    @GetMapping("/queryActivationCodeStatusByactivation_code")
    @ApiOperation(value = "查询 《激活码》状况", notes = "管理员为查询某个用户的 某个激活码 的状况")
    @Transactional
    public String queryActivationCodeStatusByactivation_code(
//            @ApiParam(value = "user号", required = true) @RequestParam int user_num,
            @ApiParam(value = "激活码", required = true) @RequestParam String activation_code
    ) {
        return JSON.toJSONString(
                queryActivationCodeStatus.getActivationCodeStatusByactivation_code(
                        activation_code
                ));
    }

    @GetMapping("/queryActivationCodeStatusByuser_num")
    @ApiOperation(value = "查询《用户》 的激活码状况", notes = "管理员为查询某个 用户 的某个激活码的状况")
    @Transactional
    public String queryActivationCodeStatusByuser_num(
//            @ApiParam(value = "user号", required = true) @RequestParam int user_num,
            @ApiParam(value = "user号", required = true) @RequestParam int user_num
    ) {
        return JSON.toJSONString(
                queryActivationCodeStatus.getActivationCodeStatusByuser_num(
                        user_num
                ));
    }

    @GetMapping("/initiateChange")
    @ApiOperation(value = "管理员进行一次发起", notes = "管理员进行发起，需要把新值和旧值都告诉我")
    @Transactional
    public String initiateChange(
            @ApiParam(value = "管理员号", required = true) @RequestParam int admin_num,
            @ApiParam(value = "修改change种类号", required = true) @RequestParam int c_type_num,
            @ApiParam(value = "旧值", required = true) @RequestParam String old_value,
            @ApiParam(value = "新值", required = true) @RequestParam String new_value,
            @ApiParam(value = "激活信息号", required = true) @RequestParam int ainfo_num
    ) {
        int initiage_num = initiateService.getCount() + 1;
        int change_num = changeService.getCount() + 1;
        int adminlog_num = admin_logsService.getCount() + 1;
        initiateService.insertOnceAdminInitiate(
                initiage_num,
                admin_num,
                change_num,
                adminlog_num
        );
        changeService.insert(
                new Change(
                        change_num,
                        c_type_num,
                        old_value,
                        new_value,
                        ainfo_num
                )
        );
        admin_logsService.insert(
                new Admin_logs(
                        adminlog_num,
                        "管理员发起一条修改",
                        admin_num,
                        "对" + String.valueOf(ainfo_num) + "进行" + String.valueOf(c_type_num) + "操作将" + old_value +
                                "修改为" + new_value,
                        myDateTime.getDateTime()
                )
        );
        return MyResponseStatus.ok.toString();

    }
    @GetMapping("/queryAllnotFreeFuncs")
    @ApiOperation(value = "管理员查询所有不免费的功能", notes = "管理员查询所有不免费的功能")
    @Transactional
    public String queryAllnotFreeFuncs(){
        return JSON.toJSONString(functionService.getAllnotFreeFuncs());
    }

    @GetMapping("/queryAllFuncs")
    @ApiOperation(value = "管理员查询的功能", notes = "管理员查询功能")
    @Transactional
    public String queryAllFuncs(){
        return JSON.toJSONString(functionService.getAll());
    }
}
