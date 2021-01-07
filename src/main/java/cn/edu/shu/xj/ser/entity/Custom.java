package cn.edu.shu.xj.ser.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("custom")
public class Custom {
    private Integer id;
    private String name;
    private String location;
    private String contact;
}
