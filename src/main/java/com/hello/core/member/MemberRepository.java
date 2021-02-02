/*
 * MemberRepository.java 2021. 02. 02
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
public interface MemberRepository {
	void save(Member member);
	Member findById(Long memberId);
}
