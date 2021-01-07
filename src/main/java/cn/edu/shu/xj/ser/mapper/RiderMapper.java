package cn.edu.shu.xj.ser.mapper;

import cn.edu.shu.xj.ser.entity.Rider;
import cn.edu.shu.xj.ser.entity.Shop;
import cn.edu.shu.xj.ser.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.api.R;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface RiderMapper extends BaseMapper<Rider> {
    @Select("select * from riders where rider_id =#{rider_id}")
    Rider findOneRiderbyId(@Param("rider_id") String riderId);

    @Select("select * from riders where rider_tel =#{rider_tel}")
    Rider findOneRiderbyTel(@Param("rider_tel") String riderTel);
}
