package org.zhouhy.springboot.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;



@ConfigurationProperties(prefix = "imook.security")
public class SecurityProperties {

    private BrowserProperties browser;

    private CodeProperties code;

    public CodeProperties getCode() {
        return code;
    }

    public void setCode(CodeProperties code) {
        this.code = code;
    }

    private String username;

    public BrowserProperties getBrowser() {
        return browser;
    }


    public void setBrowser(BrowserProperties browserProperties) {
        this.browser = browserProperties;
    }

    public String getName() {
        return username;
    }

    //当你注入的时候set方法必须和后面配置文件的内容对应
    public void setName(String name) {
        this.username = name;
    }
}
