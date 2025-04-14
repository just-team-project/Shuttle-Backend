package com.shuttlebus.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * Timer Aop 구현체
 *
 * @author :Uheejoon
 * @date :2025-04-14 오후 8:55
 */
@Slf4j
@Aspect
@Component
@ConditionalOnProperty(name = "logging.level.com.shuttlebus", havingValue = "DEBUG")
public class TimerAspect {
    private static final Long THRESHOLD = 3000L;

    @Pointcut("@within(com.shuttlebus.aop.Timer) || @annotation(com.shuttlebus.aop.Timer)")
    public void enableTimer() {
    }

    @Around("enableTimer()")
    public Object aroundTimer(final ProceedingJoinPoint joinPoint) throws Throwable {
        // 전처리
        // 메소드 정보는 항상 미리 추출
        final String targetClassName = joinPoint.getTarget().getClass().getSimpleName();
        final String methodName = joinPoint.getSignature().getName();
        final Object[] args = joinPoint.getArgs();

        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        final Object result = joinPoint.proceed();
        // 후처리

        stopWatch.stop();
        final long totalTimeMillis = stopWatch.getTotalTimeMillis();

        // 일반적인 실행은 DEBUG 로그로 남김
        if (log.isDebugEnabled() && totalTimeMillis < THRESHOLD) {
            log.debug("{}.{} 실행 시간: {}ms", targetClassName, methodName, totalTimeMillis);
        }
        // 임계값 초과 시에만 WARN과 추가 정보 로깅
        else if (totalTimeMillis >= THRESHOLD && log.isWarnEnabled()) {
            final String simpleArgsInfo = getSimplifiedArgsInfo(args);
            log.warn("{}.{} 실행 시간: {}ms, args: {}, 위치: {}", targetClassName, methodName, totalTimeMillis, simpleArgsInfo, getMethodSignature(joinPoint));
        }

        return result;
    }

    // 메소드 시그니처 정보를 간결하게 반환 (호출 스택 트레이스보다 효율적)
    private String getMethodSignature(ProceedingJoinPoint joinPoint) {
        final MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        return signature.getDeclaringTypeName() + "." + signature.getName();
    }

    // 인자 정보를 간결하게 변환 (민감 정보 제외)
    private String getSimplifiedArgsInfo(final Object[] args) {
        if (args == null || args.length == 0) {
            return "[]";
        }

        final StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < args.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }

            final Object arg = args[i];
            if (arg == null) {
                sb.append("null");
            } else if (arg instanceof String str) {
                // 문자열은 길이만 표시하거나 일부만 표시
                if (str.length() > 30) {
                    sb.append("String(").append(str.length()).append(")");
                } else {
                    sb.append(str);
                }
            } else {
                // 객체 타입만 로깅하거나 toString() 결과를 간략화
                sb.append(arg.getClass().getSimpleName());
            }
        }
        sb.append("]");
        return sb.toString();
    }
}