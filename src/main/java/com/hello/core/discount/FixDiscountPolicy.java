/*
 * FixDiscountPolicy.java 2021. 02. 02
 *
 * Copyright 2021 WorksMobile Corp. All rights Reserved.
 * WorksMobile PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package com.hello.core.discount;

import com.hello.core.member.Grade;
import com.hello.core.member.Member;

/**
 *
 * Created By Yoonje Choi
 * Date : 2021/02/02
 */
public class FixDiscountPolicy implements DiscountPolicy {

	private int discountFixAmount = 1000; //1000원 할인

	@Override
	public int discount(Member member, int price) {
		if (member.getGrade() == Grade.VIP) {
			return discountFixAmount;
		} else {
			return 0;
		}
	}

}
