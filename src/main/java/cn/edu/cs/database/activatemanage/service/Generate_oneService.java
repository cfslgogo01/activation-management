package cn.edu.cs.database.activatemanage.service;

import cn.edu.cs.database.activatemanage.dao.Generate_oneMapper;
import cn.edu.cs.database.activatemanage.entity.Generate_one;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Generate_oneService {
    @Autowired
    Generate_oneMapper generate_oneMapper;
    public int getCount() {
        return generate_oneMapper.getCount();
    }
    public int insert(Generate_one generate_one) {
        return generate_oneMapper.insert(generate_one);
    }
}
