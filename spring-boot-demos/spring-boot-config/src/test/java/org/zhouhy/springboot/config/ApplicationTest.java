package org.zhouhy.springboot.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zhouhy.springboot.config.entity.User;
import org.zhouhy.springboot.config.entity.User1;
import org.zhouhy.springboot.config.entity.User2;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
	
	@Autowired
	private User user;
	
	@Autowired
	private User1 user1;
	
	@Autowired
	private User2 user2;
	
	@Test
	public void test() {
		System.out.println(user);
		System.out.println(user1);
		System.out.println(user2);
	}
}
