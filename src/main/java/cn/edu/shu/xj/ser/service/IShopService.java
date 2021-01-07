package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.Shop;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IShopService extends IService<Shop> {
    public Shop findOneShopbyId(String shopId);
    public Shop findOneShopbyTel(String skpTel);
    public String findShopPwdbyId(String shopId);
    public String findShopPwdbyTel(String skpTel);
}
