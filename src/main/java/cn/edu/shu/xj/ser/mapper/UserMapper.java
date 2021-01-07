package cn.edu.shu.xj.ser.mapper;

import cn.edu.shu.xj.ser.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from users where user_id =#{user_id}")
    User findOneUserbyId(@Param("user_id") String userId);

    @Select("select * from users where user_tel =#{user_tel}")
    User findOneUserbyTel(@Param("user_tel") String userTel);
}
