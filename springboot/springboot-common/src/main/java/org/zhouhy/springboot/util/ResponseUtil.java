package org.zhouhy.springboot.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.zhouhy.springboot.enums.ResultStatus;
import org.zhouhy.springboot.result.Result;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
public class ResponseUtil {
    
    public static PrintWriter getPrintWriter(HttpServletResponse response){
        PrintWriter out = null;
        try {
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
        } catch (IOException e) {
            log.error("PrintWriter is exception", e);
        }
        return out;
    }

    public static void print (PrintWriter out, String data){        
        out.print(data);
        out.flush();
        out.close();
    }    
}
