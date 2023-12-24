package cn.edu.cs.database.activatemanage.dao;

import cn.edu.cs.database.activatemanage.entity.Generate_two;
import org.springframework.stereotype.Repository;

@Repository
public interface Generate_twoMapper {
    int getCount();

    int insert(Generate_two generate_two);
}
