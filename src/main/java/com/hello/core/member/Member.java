/*
 * Member.java 2021. 02. 02
 *
 * Copyright 2021 WorksMobile Corp. All rights Reserved.
 * WorksMobile PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package com.hello.core.member;

/**
 *
 * Created By Yoonje Choi
 * Date : 2021/02/02
 */
public class Member {

	private Long id;
	private String name;
	private Grade grade;

	public Member(Long id, String name, Grade grade) {
		this.id = id;
		this.name = name;
		this.grade = grade;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) { this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) { this.name = name;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) { this.grade = grade;
	}

}
