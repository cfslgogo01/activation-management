package cn.edu.cs.database.activatemanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@MapperScan("cn.edu.cs.database.activatemanage.dao")
@EntityScan("cn.edu.cs.database.activatemanage.entity")
@SpringBootApplication
public class ActivationManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivationManagementApplication.class, args);
        System.out.println("ψ(｀∇´)ψ  后端启动成功  (≧∇≦)ﾉ \n" +
               "   #     #                 ##              #          #     #                   #    \n" +
                        "   #     #         ########        #   #   #   #      #      #           #      #    \n" +
                        "   #    # #             #           ##  ## #  ##     #   #########   ######     #    \n" +
                        "   #    # #             #     #      #   # # #       #   #       #   #   #      #    \n" +
                        "###### #   #     ###############  #        #        #   #       #    #   ##########  \n" +
                        "   #  #     #         # # #        #      # #      #####             #   #      #    \n" +
                        "   # # ##### ##      #  #  ##      #     #   ###      #  #########   #   #      #    \n" +
                        "   ###             ##   #    ###      # #  #  #      #       #       #####  #   #    \n" +
                        "  ##        #    ##  #######  #      #     #        #      # # #     #   #   #  #    \n" +
                        "## #  ########       #     #        #   #  #  #    ######  # ####    #   #   #  #    \n" +
                        "   #  #     #        #     #      ###    # # ##     #      # #       #   #      #    \n" +
                        "   #  #     #        #######        #     # #             #  #       #   #      #    \n" +
                        "   #  #     #        #     #        #     #  #        ### ## #       #####      #    \n" +
                        "   #  #     #        #     #        #    #   #     ###   #  ##  ##   #   #   #  #    \n" +
                        " # #  #######        #######        #   #     ###   #   #     ###             # #    \n" +
                        "  #   #     #        #     #        # ##       #                               #     \n"
                );
    }

}
