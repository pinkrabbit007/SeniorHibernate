package com.test.test.service;

import org.springframework.stereotype.Component;

/**
 * 
 * @author zjq
 * @aim 为了测试autowired的用法 @20150906
 */
@Component
public class Connecticut {
	
	private String name;
	private int id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
