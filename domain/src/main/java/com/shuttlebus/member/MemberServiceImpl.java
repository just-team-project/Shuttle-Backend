package com.shuttlebus.member;

import com.shuttlebus.member.command.MemberCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Member service 기능 구현
 *
 * @author :Uheejoon
 * @date :2025-04-06 오후 7:57
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
  private final MemberRegister memberRegister;

  @Override
  public Member registerMember(MemberCommand.RegisterMember registerMember) {
    return memberRegister.registerMember(registerMember.toMember());
  }
}
