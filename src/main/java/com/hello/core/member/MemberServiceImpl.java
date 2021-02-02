/*
 * MemberServiceImpl.java 2021. 02. 02
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
public class MemberServiceImpl implements MemberService {

	private final MemberRepository memberRepository;

	public MemberServiceImpl(MemberRepository memberRepository){
		this.memberRepository = memberRepository;
	}

	@Override
	public void join(Member member) {
		memberRepository.save(member);
	}

	@Override
	public Member findMember(Long memberId) {
		return memberRepository.findById(memberId);
	}
}
