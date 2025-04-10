package com.shuttlebus.member;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

/**
 * Member 요청, 응답 DTO
 *
 * @author :Uheejoon
 * @date :2025-04-06 오후 8:08
 */
public class MemberDto {

  @Builder
  public record NormalMemberLoginRequest(
    @NotBlank
    String email
  ) {
  }
}
