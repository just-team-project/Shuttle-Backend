package com.shuttlebus.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 계정 인증 상태
 *
 * @author :Uheejoon
 * @date :2025-04-10 오후 8:37
 */
@Getter
@AllArgsConstructor
public enum VerifiedStatus {
  CREATED("최초 생성"), EMAIL_VERIFIED("이메일 인증 완료"), FULLY_VERIFIED("모든 인증 절차 완료");
  private final String status;
}
