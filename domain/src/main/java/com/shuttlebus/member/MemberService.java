package com.shuttlebus.member;

import com.shuttlebus.member.command.MemberCommand;

/**
 * Member service 기능 정의
 *
 * @author :Uheejoon
 * @date :2025-04-06 오후 7:54
 */
public interface MemberService {
  Member registerMember(MemberCommand.RegisterMember registerMember);
}
