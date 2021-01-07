package cn.edu.shu.xj.ser.controller;


import cn.edu.shu.xj.ser.entity.ProductType;
import cn.edu.shu.xj.ser.service.IProductTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "商品类别模块")
@RestController
@RequestMapping("/producttype")
@CrossOrigin
public class ProductTypeController {

    @Autowired
    IProductTypeService producttypeService;

    @ApiOperation(value = "商家添加/修改商品类别")
    @PostMapping("/save")
    public boolean save(@RequestBody ProductType producttype){
        return producttypeService.saveOrUpdate(producttype);
    }

    @ApiOperation(value = "商家删除商品类别")
    @PostMapping("/remove/bytypeId")
    public boolean remove(@RequestParam(value = "type_id") String typeId){
        return producttypeService.removeById(typeId);
    }

    @ApiOperation(value = "商品分类全列表")
    @GetMapping("/list/byshopId")
    public List<ProductType> list(@RequestParam(value = "shop_id") String shopId){
        return producttypeService.producttypelist(shopId);
    }
}
