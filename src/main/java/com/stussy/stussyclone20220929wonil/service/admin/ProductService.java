package com.stussy.stussyclone20220929wonil.service.admin;

import com.stussy.stussyclone20220929wonil.dto.admin.ProductAdditionReqDto;

public interface ProductService {
    public boolean addProduct(ProductAdditionReqDto productAdditionReqDto) throws Exception;
}
