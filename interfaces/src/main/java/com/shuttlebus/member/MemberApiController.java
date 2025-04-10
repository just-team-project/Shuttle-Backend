package com.shuttlebus.member;

import com.shuttlebus.member.command.MemberCommand;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 회원 API
 *
 * @author :Uheejoon
 * @date :2025-04-06 오후 7:46
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberApiController {

  private final MemberFacade memberFacade;

  @PostMapping("/register-normal")
  public Member registerMember(@RequestBody @Valid MemberDto.NormalMemberLoginRequest request) {
    MemberCommand.RegisterMember registerMember = MemberCommand.RegisterMember.of(request.email());
    return memberFacade.registerMember(registerMember);
  }

}
