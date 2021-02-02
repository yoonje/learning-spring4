/*
 * MemoryMemberRepository.java 2021. 02. 02
 *
 * Copyright 2021 WorksMobile Corp. All rights Reserved.
 * WorksMobile PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package com.hello.core.member;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Created By Yoonje Choi
 * Date : 2021/02/02
 */
public class MemoryMemberRepository implements MemberRepository {

	private static Map<Long, Member> store = new HashMap<>();

	@Override
	public void save(Member member) {
		store.put(member.getId(), member);
	}

	@Override
	public Member findById(Long memberId) {
		return store.get(memberId);
	}
}
