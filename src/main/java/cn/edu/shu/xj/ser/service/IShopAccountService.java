package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.Rider;
import cn.edu.shu.xj.ser.entity.ShopAccount;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IShopAccountService extends IService<ShopAccount> {
    public List<ShopAccount> shopBalanceDetail(String shopId);
}
