package org.example.spring.boot.beginning.banner;

import org.springframework.boot.Banner;
import org.springframework.core.env.Environment;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * 这个类必须继承于 Banner
 * */
public class UnimarketBanner implements Banner {   
    
    /**
     * 在此方法中输出字符串内容
     * */
    @Override
    public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
        List<String> banner = this.getBannerContent(); 
        out.println();
        for(String line:banner){
            out.println(line);
        }
        out.println(); // 输出一个换行
        out.flush(); // 强制清空缓存
    }
    
    // 读取字符串内容
    public List<String> getBannerContent() {
        List<String> banner = new ArrayList<>();
        URL resource = UnimarketBanner.class.getClassLoader().getResource("banner_del.txt");
        try {
            assert resource != null;
            File file = new File(resource.getFile());
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(isr);
            while(true){
                String line = reader.readLine();
                if(line == null){
                    break;
                }
                banner.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return banner;
    }
}
