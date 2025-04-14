package com.shuttlebus.enums.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 공통 에러 코드
 *
 * @author :Uheejoon
 * @date :2025-04-13 오후 9:34
 */
@Getter
@AllArgsConstructor
public enum CommonErrorCode implements CodeIfs {
    INTERNAL_SERVER_ERROR("C001", "내부 서버 오류가 발생하였습니다."),
    IS_NULL_PARAM("C002", "파라미터가 올바르지 않습니다.(NULL)"),
    INVALID_PARAM("C003", "파라미터가 올바르지 않습니다."),
    INVALID_AUTHENTICATION("C004", "인증이 올바르지 않습니다."),
    NO_SUCH_METHOD("C005", "메소드를 찾을 수 없습니다."),
    NOT_FOUND_ENUM_CONSTANT("C006", "열거형 상수값을 찾을 수 없습니다."),
    METHOD_ARG_NOT_VALID("C007", "유효성 오류가 발생했습니다."),
    INVALID_LIST("C008", "리스트가 비어있거나 NULL 입니다."),

    FORBIDDEN("C009", "접근 권한이 없습니다."),
    UNAUTHORIZED("C010", "유효한 인증 자격이 없습니다."),

    JSON_PROCESSING_ERROR("C011", "JSON 처리 중 오류가 발생하였습니다."),

    ;
    private final String code;
    private final String message;

}
