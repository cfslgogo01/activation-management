package cn.edu.cs.database.activatemanage.service;

import cn.edu.cs.database.activatemanage.dao.Generate_twoMapper;
import cn.edu.cs.database.activatemanage.entity.Generate_two;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Generate_twoService {
    @Autowired
    Generate_twoMapper generate_twoMapper;
    public int getCount() {
        return generate_twoMapper.getCount();
    }
    public int insert(Generate_two generate_two) {
        return generate_twoMapper.insert(generate_two);
    }
}
