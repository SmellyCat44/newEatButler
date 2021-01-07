package cn.edu.shu.xj.ser.mapper;


import cn.edu.shu.xj.ser.entity.Custom;
import cn.edu.shu.xj.ser.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface CustomMapper extends BaseMapper<Custom> {

}
