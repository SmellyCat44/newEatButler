package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.Rider;
import cn.edu.shu.xj.ser.entity.Shop;
import cn.edu.shu.xj.ser.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IRiderService extends IService<Rider> {

    public Rider findOneRiderbyId(String riderId);
    public Rider findOneRiderbyTel(String riderTel);
}
