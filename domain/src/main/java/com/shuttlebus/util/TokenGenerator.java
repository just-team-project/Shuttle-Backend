package com.shuttlebus.util;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * 토큰 생성 유틸 클래스
 *
 * @author :Uheejoon
 * @date :2025-04-08 오후 8:38
 */
public class TokenGenerator {
  private static final int TOKEN_LENGTH = 40;

  public static String randomCharacter(int length) {
    return RandomStringUtils.secureStrong().nextAlphanumeric(length);
  }

  public static String randomCharacterWithPrefix(String prefix) {
    return prefix + randomCharacter(TOKEN_LENGTH - prefix.length());
  }
}
