package com.stussy.stussyclone20220929wonil.controller.api;

import com.stussy.stussyclone20220929wonil.aop.annotation.LogAspect;
import com.stussy.stussyclone20220929wonil.aop.annotation.ValidAspect;
import com.stussy.stussyclone20220929wonil.dto.CMRespDto;
import com.stussy.stussyclone20220929wonil.dto.account.RegisterReqDto;
import com.stussy.stussyclone20220929wonil.dto.validation.ValidationSequence;
import com.stussy.stussyclone20220929wonil.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/api/account")
@RestController
@RequiredArgsConstructor
public class AccountApi {

    private final AccountService accountService;

    @ValidAspect
    @LogAspect
    @PostMapping("/register")
    public ResponseEntity<?> register(@Validated(ValidationSequence.class) @RequestBody RegisterReqDto registerReqDto, BindingResult bindingResult) throws Exception {

        accountService.checkDuplicateEmail(registerReqDto.getEmail());

        accountService.register(registerReqDto);

        return ResponseEntity.ok().body(new CMRespDto<>(1, "Successfully registered", registerReqDto));
    }


}
