package com.citi.springboot.cros.controller;

import org.json.simple.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.citi.springboot.cros.entity.RequestLoginBean;

@RestController
@RequestMapping(value = "/index", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CrosController {
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/loginbypost2", method = {RequestMethod.POST, RequestMethod.GET })
	public String loginByPost2(RequestLoginBean loginBean) {
		JSONObject result = new JSONObject();
		result.put("username", loginBean.getUsername());
		result.put("password", loginBean.getPassword());
		return result.toJSONString();
	}
}
