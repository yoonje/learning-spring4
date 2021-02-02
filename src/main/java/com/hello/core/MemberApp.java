/*
 * MemberApp.java 2021. 02. 03
 *
 * Copyright 2021 WorksMobile Corp. All rights Reserved.
 * WorksMobile PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package com.hello.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import com.hello.core.member.MemberService;

/**
 *
 * Created By Yoonje Choi
 * Date : 2021/02/03
 */
public class MemberApp {

	public static void main(String[] args) {
		// POJO
//		AppConfig appConfig = new AppConfig();
//		// appConfig에서 내부 구체 클래스를 만들고 할당
//		MemberService memberService = appConfig.memberService();
//		Member member = new Member(1L, "memberA", Grade.VIP);
//		memberService.join(member);
//		Member findMember = memberService.findMember(1L);
//		System.out.println("new member = " + member.getName());
//		System.out.println("find Member = " + findMember.getName());

		// Spring
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService = applicationContext.getBean("memberService",MemberService.class);

		Member member = new Member(1L, "memberA", Grade.VIP);
		memberService.join(member);

		Member findMember = memberService.findMember(1L);
		System.out.println("new member = " + member.getName());
		System.out.println("find Member = " + findMember.getName());


	}
}
