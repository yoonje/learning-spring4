/*
 * AppConfig.java 2021. 02. 03
 *
 * Copyright 2021 WorksMobile Corp. All rights Reserved.
 * WorksMobile PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package com.hello.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hello.core.discount.DiscountPolicy;
import com.hello.core.discount.FixDiscountPolicy;
import com.hello.core.discount.RateDiscountPolicy;
import com.hello.core.member.MemberService;
import com.hello.core.member.MemberServiceImpl;
import com.hello.core.member.MemoryMemberRepository;
import com.hello.core.order.OrderService;
import com.hello.core.order.OrderServiceImpl;

///**
// * 어떤 구현 객체을 주입할지는 결정하는 클래스(POJO)
// * Created By Yoonje Choi
// * Date : 2021/02/03
// */
//public class AppConfig {
//
//	private MemoryMemberRepository getMemberRepository() {
//		return new MemoryMemberRepository();
//	}
//
//	public DiscountPolicy getDiscountPolicy() {
////		return new FixDiscountPolicy();
//		return new RateDiscountPolicy();
//	}
//
//	public OrderService orderService() {
//		return new OrderServiceImpl(
//			getMemberRepository(),
//			getDiscountPolicy());
//	}
//
//	public MemberService memberService() {
//		return new MemberServiceImpl(getMemberRepository());
//	}
//}
/**
 * 어떤 구현 객체을 주입할지는 결정하는 클래스(Spring)
 * Created By Yoonje Choi
 * Date : 2021/02/03
 */
@Configuration
public class AppConfig {

	@Bean
	public MemoryMemberRepository getMemberRepository() {
		return new MemoryMemberRepository();
	}

	@Bean
	public DiscountPolicy getDiscountPolicy() {
		//		return new FixDiscountPolicy();
		return new RateDiscountPolicy();
	}

	@Bean
	public OrderService orderService() {
		return new OrderServiceImpl(
			getMemberRepository(),
			getDiscountPolicy());
	}

	@Bean
	public MemberService memberService() {
		return new MemberServiceImpl(getMemberRepository());
	}
}