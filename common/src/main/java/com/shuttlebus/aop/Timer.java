package com.shuttlebus.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* 메서드 실행 시간을 측정하기 위한 어노테이션
* 
* @author       :Uheejoon
* @date        :2025-04-14 오후 8:50
*/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Timer {
}
