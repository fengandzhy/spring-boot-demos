package org.zhouhy.springboot.begin.controller;

import org.springframework.web.bind.annotation.*;
import org.zhouhy.springboot.begin.entity.User;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ReqeustController {

    private Map<String,Object> params = new HashMap<>();

    @RequestMapping(value="/{city_id}/{user_id}",method = RequestMethod.GET)
    public Object findUser(@PathVariable("city_id") String cityId,@PathVariable("user_id") String userId){
        params.clear();
        params.put("cityId",cityId);
        params.put("userId",userId);

        return params;
    }


    /**
     * http://localhost:8080/v1/page_user1?from=1&to=2
     * */
    @RequestMapping(value="/v1/page_user1",method = RequestMethod.GET)
    public Object pageUser(String from,String to){
        params.clear();

        params.put("from",from);
        params.put("to",to);

        return params;
    }


    /**
     * 功能描述：bean对象传参
     * 注意：1、注意需要指定http头为 content-type为application/json
     * 		2、使用body传输数据
     * @param user
     * @return
     */
    @RequestMapping(value="/v1/save_user",method = RequestMethod.POST)
    public Object saveUser(@RequestBody User user){
        params.clear();
        params.put("user",user);
        return params;
    }


    /**
     * 功能描述：测试获取http头信息
     * @param accessToken
     * @param id
     * @return
     */
    @RequestMapping(value="/v1/validate_user",method = RequestMethod.GET)
    public Object validateUser(@RequestHeader("access_token") String accessToken,String id){
        params.clear();
        params.put("access_token",accessToken);
        params.put("id",id);
        return params;
    }
}
