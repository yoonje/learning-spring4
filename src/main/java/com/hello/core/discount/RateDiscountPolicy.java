/*
 * RateDiscountPolicy.java 2021. 02. 03
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
 * Date : 2021/02/03
 */
public class RateDiscountPolicy implements DiscountPolicy {

	private int discountPercent = 10; //10% 할인

	@Override
	public int discount(Member member, int price) {
		if (member.getGrade() == Grade.VIP) {
			return price * discountPercent / 100;
		} else {
			return 0;
		}
	}
}
