package cn.edu.cs.database.activatemanage.dao;

import cn.edu.cs.database.activatemanage.entity.Conadmin;
import org.springframework.stereotype.Repository;

/**
 * Conadmin类的Mapper接口类
 * 目前感觉只需要提供 插入即可
 */
@Repository
public interface ConadminMapper {
    int getCount();

    int insert(Conadmin conadmin);
//    int deleteById(int admin_num);
//    int updateBy??(Conadmin conadmin);
//    get的就先不写了！
}
