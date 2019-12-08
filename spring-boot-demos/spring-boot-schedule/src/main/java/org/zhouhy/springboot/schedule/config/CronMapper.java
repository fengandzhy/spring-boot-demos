package org.zhouhy.springboot.schedule.config;

import org.springframework.stereotype.Component;

@Component
public class CronMapper {
	
	public String getCorn() {
		System.out.println("abcdefg");
		return "0/5 * * * * ?";
	}
	
}
