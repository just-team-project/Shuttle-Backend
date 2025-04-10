package com.shuttlebus.jooq.converter;

import com.shuttlebus.member.Role;
import com.shuttlebus.member.VerifiedStatus;
import org.jooq.EnumType;
import org.jooq.generated.enums.MemberRole;
import org.jooq.generated.enums.MemberVerifiedStatus;
import org.springframework.util.ObjectUtils;

/**
 * java enum to jooq enum
 *
 * @author :Uheejoon
 * @date :2025-04-10 오후 9:11
 */
public class MemberEnumConverter {
  public static MemberRole convertToRole(Role role) {
    return MemberRole.valueOf(role.name());
  }
  public static MemberVerifiedStatus convertToVerifiedStatus(VerifiedStatus status) {
    if(ObjectUtils.isEmpty(status)) {
      return null;
    }
    return MemberVerifiedStatus.valueOf(status.name());
  }
  public static String convertToString(EnumType role) {
    return role.getName();
  }
}
