package com.shuttlebus.jooq.member;

import com.shuttlebus.jooq.converter.MemberEnumConverter;
import com.shuttlebus.member.Member;
import com.shuttlebus.member.MemberRegister;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.generated.tables.JMember;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

import static com.shuttlebus.jooq.converter.MemberEnumConverter.convertToRole;
import static com.shuttlebus.jooq.converter.MemberEnumConverter.convertToVerifiedStatus;

/**
 * Member 등록 기능 구현
 *
 * @author :Uheejoon
 * @date :2025-04-06 오후 8:01
 */
@Repository
@RequiredArgsConstructor
public class MemberRegisterImpl implements MemberRegister {

  private final DSLContext dslContext;
  private final JMember MEMBER = JMember.MEMBER;

  @Override
  public Member registerMember(Member member) {
    return dslContext.insertInto(MEMBER,
        MEMBER.EMAIL,
        MEMBER.LOGIN_ID,
        MEMBER.PASSWORD,
        MEMBER.NAME,
        MEMBER.PHONE_NUMBER,
        MEMBER.ROLE,
        MEMBER.UNIQUE_KEY,
        MEMBER.APP_KEY,
        MEMBER.VERIFIED_STATUS,
        MEMBER.LAST_LOGIN_AT
      )
      .values(
        member.getEmail(),
        member.getLoginId(),
        member.getPassword(),
        member.getName(),
        member.getPhoneNumber(),
        convertToRole(member.getRole()),
        member.getUniqueKey(),
        member.getAppKey(),
        convertToVerifiedStatus(member.getVerifiedStatus()),
        LocalDateTime.now()
      )
      .returning()
      .fetchOneInto(Member.class);
  }

}
