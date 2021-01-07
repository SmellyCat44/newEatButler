package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.ShopAccount;
import cn.edu.shu.xj.ser.mapper.ShopAccountMapper;
import cn.edu.shu.xj.ser.service.IShopAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopAccountService extends ServiceImpl<ShopAccountMapper, ShopAccount> implements IShopAccountService {
    @Autowired
    ShopAccountMapper shopAccountMapper;
    public List<ShopAccount> shopBalanceDetail(String shopId){
        return shopAccountMapper.shopBalanceDetail(shopId);
    }
}
