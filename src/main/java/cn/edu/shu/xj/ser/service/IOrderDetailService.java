package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.OrderDetail;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IOrderDetailService extends IService<OrderDetail> {
    public boolean add(Integer productId, Integer amt,Double finalPrice);

    public int modifyamt(Integer orderId, Integer amt,Double finalPrice);

    public int getpd(Integer orderId);

    public boolean createorder(Integer orderId);

    public boolean xiadan(String userId,Integer addressId,Integer orderId);

    public OrderDetail findproduct(Integer orderId, Integer productId);

    public int insertCart(Integer orderId,Integer productId,Double finalPrice);

    public int addCart(Integer orderId,Integer productId,Double finalPrice);

    public int deleteOneProduct(Integer orderId,Integer productId,Double finalPrice);

    public int deleteAllProduct(Integer orderId,Integer productId);

    public List<OrderDetail> userCart(Integer orderId);
}
