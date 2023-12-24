package cn.edu.cs.database.activatemanage.service;

import cn.edu.cs.database.activatemanage.dao.FunctionMapper;
import cn.edu.cs.database.activatemanage.entity.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FunctionService {
    @Autowired
    FunctionMapper functionMapper;
    public List<Function> getAll() {
        return functionMapper.getAll();
    }

    public List<Function> getAllnotFreeFuncs() {
        return functionMapper.getAllnotFreeFuncs();
    }
}
