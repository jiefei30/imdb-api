package com.marchsoft.config;

import org.springframework.stereotype.Repository;

/**
 * @author DELL
 * @date 2020/6/15 21:49
 */
@Repository
public class ParamConfig {

   //tomcat服务器或是nginx服务器或是其他服务器设置的静态资源访问地址
    private String img_path = "D:\\Software\\apache-tomcat-8.5.43\\images\\";

    public String getImgPath(){
        return img_path;
    }

}
