package cn.edu.shu.xj.ser.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("riders")
public class Rider {
    @TableId(value = "rider_id",type = IdType.INPUT) //type = IdType.INPUT,没有的话无法插入主键
    private String riderId;
    private String riderPwd;
    private String riderName;
//    private Date riderDate;
    private String riderRank;
    private Double riderBalance;
    private String riderTel;
}
