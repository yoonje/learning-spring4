/*
 * OrderServiceImpl.java 2021. 02. 02
 *
 * Copyright 2021 WorksMobile Corp. All rights Reserved.
 * WorksMobile PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package com.hello.core.order;

import com.hello.core.discount.DiscountPolicy;
import com.hello.core.discount.FixDiscountPolicy;
import com.hello.core.discount.RateDiscountPolicy;
import com.hello.core.member.Member;
import com.hello.core.member.MemberRepository;
import com.hello.core.member.MemoryMemberRepository;

/**
 *
 * Created By Yoonje Choi
 * Date : 2021/02/02
 */
public class OrderServiceImpl implements OrderService {

	private final MemberRepository memberRepository;
	private final DiscountPolicy discountPolicy;

	public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy){
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}

	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);
		return new Order(memberId, itemName, itemPrice, discountPrice);
	}
}
