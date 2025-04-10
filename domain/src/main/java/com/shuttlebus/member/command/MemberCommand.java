package com.shuttlebus.member.command;

import com.shuttlebus.member.Member;
import com.shuttlebus.member.Role;
import com.shuttlebus.member.VerifiedStatus;
import lombok.Builder;

/**
 * command 관리 클래스
 *
 * @author :Uheejoon
 * @date :2025-04-08 오후 8:15
 */
public class MemberCommand {

  @Builder
  public record RegisterMember(
    String email,
    String loginId,
    String password,
    String name,
    String phoneNumber,
    Role role,
    String appKey,
    VerifiedStatus verifiedStatus
  ) {
    public static RegisterMember of(String email) {
      return RegisterMember.builder()
        .role(Role.NORMAL)
        .email(email)
        .build();
    }

    public Member toMember() {
      return Member.of(this);
    }
  }

}
