/*
 * OrderApp.java 2021. 02. 03
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
import com.hello.core.order.Order;
import com.hello.core.order.OrderService;

/**
 *
 * Created By Yoonje Choi
 * Date : 2021/02/03
 */
public class OrderApp {

	public static void main(String[] args) {
		// POJO
//		AppConfig appConfig = new AppConfig();
//		// appConfig에서 내부 구체 클래스를 만들고 할당
//		MemberService memberService = appConfig.memberService();
//		// appConfig에서 내부 구체 클래스를 만들고 할당
//		OrderService orderService = appConfig.orderService();
//		Long memberId = 1L;
//		Member member = new Member(memberId, "memberA", Grade.VIP);
//		memberService.join(member);
//		Order order = orderService.createOrder(memberId, "itemA", 10000);
//		System.out.println("order = " + order);

		// Spring
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
		OrderService orderService = applicationContext.getBean("orderService",OrderService.class);

		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);
		Order order = orderService.createOrder(memberId, "itemA", 10000);
		System.out.println("order = " + order);
	}
}
