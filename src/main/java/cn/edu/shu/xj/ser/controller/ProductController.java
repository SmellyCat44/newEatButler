package cn.edu.shu.xj.ser.controller;

import cn.edu.shu.xj.ser.entity.Product;
import cn.edu.shu.xj.ser.entity.OrderDetail;
import cn.edu.shu.xj.ser.service.IAddressService;
import cn.edu.shu.xj.ser.service.IOrderDetailService;
import cn.edu.shu.xj.ser.service.IProductService;
import cn.edu.shu.xj.ser.service.impl.OrderDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "商品模块")
@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {

    @Autowired
    IProductService productService;

    @Autowired
    IOrderDetailService orderDetailService;

    @ApiOperation(value = "商家添加/修改商品")
    @PostMapping("/save")
    public boolean save(@RequestBody Product product){
        return productService.saveOrUpdate(product);
    }

    @ApiOperation(value = "商家通过商品ID调取单个商品信息")//修改单个商品信息时使用
    @GetMapping("/detail")
    public Product productdetail(@RequestParam(value = "p_id",required = false) String productId){
        return productService.productdetailbyId(productId);
    }

    @ApiOperation(value = "商家删除商品")
    @PostMapping("/remove/byproductId")
    public boolean remove(@RequestParam(value = "p_id") String productId){
        return productService.removeById(productId);
    }

    @ApiOperation(value = "商品全列表")
    @GetMapping("/list/byshopId")
    public List<Product> list(@RequestParam(value = "shop_id") String shopId) {
        return productService.productlist(shopId);
    }

    //用户加购物车
    @ApiOperation(value = "用户加购物车")
    @PostMapping("/detail/add")
    public boolean findPrice(@RequestParam(value = "p_id") Integer productId,@RequestParam(value = "amt")Integer amt){
        Double finalPrice;
        finalPrice=productService.findPrice(productId);
        finalPrice*=amt;
        return orderDetailService.add(productId,amt,finalPrice);
    }

    //用户修改购物车
    @ApiOperation(value = "用户修改购物车")
    @PostMapping("/user/save")
    public int modifyamt(@RequestParam(value = "o_id")Integer orderId,@RequestParam(value = "amt")Integer amt) {
        Integer pd;
        pd=orderDetailService.getpd(orderId);
        Double fp;
        fp=productService.findPrice(pd);
        fp*=amt;
        orderDetailService.modifyamt(orderId,amt,fp);
        return 1;//修改成功返回1
    }

}