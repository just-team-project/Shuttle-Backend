package com.shuttlebus.member;

import com.shuttlebus.member.command.MemberCommand;
import com.shuttlebus.util.TokenGenerator;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Member 객체
 *
 * @author :Uheejoon
 * @date :2025-04-10 오후 7:46
 */
@Getter
@NoArgsConstructor
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Member implements Serializable {
  private static final long serialVersionUID = 1L;
  private static final String MEMBER_PREFIX = "MEMBER_";

  private Long memberId;
  private String email;
  private String loginId;
  private String password;
  private String name;
  private String phoneNumber;
  private Role role;
  private String uniqueKey;
  private String appKey;
  private VerifiedStatus verifiedStatus;
  private LocalDateTime lastLoginAt;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  public static Member of(MemberCommand.RegisterMember registerCommand) {
    return Member.builder()
      .email(registerCommand.email())
      .loginId(registerCommand.loginId())
      .password(registerCommand.password())
      .name(registerCommand.name())
      .phoneNumber(registerCommand.phoneNumber())
      .role(registerCommand.role())
      .uniqueKey(TokenGenerator.randomCharacterWithPrefix(MEMBER_PREFIX))
      .appKey(registerCommand.appKey())
      .verifiedStatus(VerifiedStatus.CREATED)
      .build();
  }
}
