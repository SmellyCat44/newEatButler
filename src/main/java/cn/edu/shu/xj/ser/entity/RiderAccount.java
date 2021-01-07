package cn.edu.shu.xj.ser.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("rider_account")
public class RiderAccount {
    @TableId(value = "o_id",type = IdType.INPUT)
    private Integer oId;
    private String riderId;
    private Double rIncome;
    private Date rAccTime;
    private String rCmmt;
}
