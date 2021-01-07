package cn.edu.shu.xj.ser.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.awt.*;

@Data
@TableName("producttype")
public class ProductType {
    @TableId(value = "type_id",type = IdType.INPUT)
    private Integer typeId;
    private String shopId;
    private String typeName;
}
