package cn.edu.cs.database.activatemanage.dao;

import cn.edu.cs.database.activatemanage.entity.Decision;
import cn.edu.cs.database.activatemanage.entity.Function;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FunctionMapper {

    List<Function> getAll();

    List<Function>getAllnotFreeFuncs();

}
