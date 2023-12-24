package cn.edu.cs.database.activatemanage.dao;

import cn.edu.cs.database.activatemanage.entity.Activation_code;
import org.springframework.stereotype.Repository;

@Repository
public interface Activation_codeMapper {
    int getCount();

    int insert(Activation_code activation_code);
}
