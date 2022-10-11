package com.stussy.stussyclone20220929wonil.service;

import com.stussy.stussyclone20220929wonil.dto.account.RegisterReqDto;

public interface AccountService {
    public boolean checkDuplicateEmail(String email);

    public boolean register(RegisterReqDto registerReqDto) throws Exception;

}
