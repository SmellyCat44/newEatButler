package cn.edu.shu.xj.ser.mapper;

import cn.edu.shu.xj.ser.entity.RiderAccount;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RiderAccountMapper extends BaseMapper<RiderAccount> {
    @Select("select * from rider_account where rider_id=#{rider_id}")
    List<RiderAccount> riderBalanceDetail(@Param("rider_id") String riderId);
}
