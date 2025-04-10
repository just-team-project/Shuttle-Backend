package com.shuttlebus.member;

import com.shuttlebus.member.command.MemberCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Member 사용 구현체
 *
 * @author :Uheejoon
 * @date :2025-04-06 오후 7:52
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class MemberFacade {
  private final MemberService memberService;

  public Member registerMember(MemberCommand.RegisterMember registerMember) {
    return memberService.registerMember(registerMember);
  }

}
