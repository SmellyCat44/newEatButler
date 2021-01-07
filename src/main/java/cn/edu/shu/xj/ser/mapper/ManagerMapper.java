package cn.edu.shu.xj.ser.mapper;


import cn.edu.shu.xj.ser.entity.Manager;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface ManagerMapper extends BaseMapper<Manager> {
    @Select("select * from manager where manager_id =#{manager_id}")
    Manager findOneManager(@Param("manager_id") String managerId);
}
