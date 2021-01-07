package cn.edu.shu.xj.ser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.servlet.http.HttpServletResponse;//

@MapperScan("cn.edu.shu.xj.ser.mapper")
@SpringBootApplication
public class SerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SerApplication.class, args);
    }
//        HttpServletResponse response;//
//        response.setHeader("Access-Control-Allow-Origin","http://39.102.32.5:8082");//
//        response.setHeader("Access-Control-Allow-Credentials","true");//
//        response.setHeader("Access-Control-Allow-Headers","Content-Type,X-Requested-With");//
}
