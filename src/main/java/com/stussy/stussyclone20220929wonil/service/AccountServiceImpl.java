package com.stussy.stussyclone20220929wonil.service;

import com.stussy.stussyclone20220929wonil.domain.User;
import com.stussy.stussyclone20220929wonil.dto.account.RegisterReqDto;
import com.stussy.stussyclone20220929wonil.exception.CustomValidationException;
import com.stussy.stussyclone20220929wonil.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;

    @Override
    public boolean checkDuplicateEmail(String email) {

        User user = accountRepository.findUserByEmail(email);
        if(user!= null) {
            Map<String, String> errorMap = new HashMap<String, String>();
            errorMap.put("duplicateFlag", "이미 가입된 이메일입니다");
            throw new CustomValidationException("duplicateEmail error", errorMap);
        }

        return true;
    }

    @Override
    public boolean register(RegisterReqDto registerReqDto) throws Exception {
        User userEntity = registerReqDto.toUserEntity();
        int result = accountRepository.save(userEntity);
        return result != 0;
    }
}
