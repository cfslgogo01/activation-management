package cn.edu.cs.database.activatemanage.dao;

import cn.edu.cs.database.activatemanage.entity.Generate_one;
import org.springframework.stereotype.Repository;

@Repository
public interface Generate_oneMapper {
    int getCount();

    int insert(Generate_one generate_one);
}
