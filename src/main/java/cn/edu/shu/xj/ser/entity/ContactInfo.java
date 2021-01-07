package cn.edu.shu.xj.ser.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("contact_info")
public class ContactInfo {
    private Integer id;
    private String contactName;
    private String phone;
    private String age;
    private String code;
}
