package org.frank.microboot.vo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Data // 这就是Lombok注解，这个注解使用的是最频繁的
//@Builder
public class Message {
    private String title;
    private Date pubdate;
    private String content;    
}
