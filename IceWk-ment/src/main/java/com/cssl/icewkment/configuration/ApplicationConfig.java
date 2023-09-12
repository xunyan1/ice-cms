package com.cssl.icewkment.configuration;

import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class ApplicationConfig {
    /**
     * 获取项目所在的文件夹
     * @return
     */
    public String getResPhysicalPath(){
        ApplicationHome home = new ApplicationHome(getClass());
        File jarFile = home.getSource();
        //项目部署的目录
        if(jarFile != null){
            String path = jarFile.getParentFile().getPath();
            return path;
        }
        return null;
    }
}
