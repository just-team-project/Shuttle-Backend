package com.shuttlebus.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 멤버 권한
 *
 * @author :Uheejoon
 * @date :2025-04-10 오후 8:36
 */
@Getter
@AllArgsConstructor
public enum Role {
  NORMAL("일반 사용자"), DRIVER("기사"), ADMIN("관리자")

  ;
  private final String role;
}
