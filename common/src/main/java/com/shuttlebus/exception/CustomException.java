package com.shuttlebus.exception;

import com.shuttlebus.enums.error.CodeIfs;
import lombok.Getter;

/**
 * Exception 최상위 부모
 *
 * @author :Uheejoon
 * @date :2025-04-13 오후 8:26
 */
@Getter
public abstract class CustomException extends RuntimeException {
  private final CodeIfs codeIfs;

  public CustomException(CodeIfs codeIfs) {
    super(codeIfs.getMessage());
    this.codeIfs = codeIfs;
  }

  public CustomException(String message, CodeIfs codeIfs) {
    super(message);
    this.codeIfs = codeIfs;
  }
}
