package cn.edu.shu.xj.ser.mapper;

import cn.edu.shu.xj.ser.entity.Address;
import cn.edu.shu.xj.ser.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AddressMapper extends BaseMapper<Address> {
    @Select("select * from addrinfo where user_id =#{user_id}")
    List<Address> userlist(@Param("user_id") String userId);
}
