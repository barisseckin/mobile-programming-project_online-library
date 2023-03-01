package com.demo.onlinelibrary.utils;

import com.demo.onlinelibrary.model.ConfirmCode;
import com.demo.onlinelibrary.repository.ConfirmCodeRepository;
import org.springframework.stereotype.Component;

@Component
public class ConfirmCodeService {

    private final ConfirmCodeRepository confirmCodeRepository;

    public ConfirmCodeService(ConfirmCodeRepository confirmCodeRepository) {
        this.confirmCodeRepository = confirmCodeRepository;
    }

    public void save(ConfirmCode confirmCode) {
        confirmCodeRepository.save(confirmCode);
    }

    public void delete(ConfirmCode confirmCode) {
        confirmCodeRepository.delete(confirmCode);
    }

    public ConfirmCode getByCode(int code) {
        return confirmCodeRepository.findConfirmCodeByCode(code)
                .orElseThrow(() -> new RuntimeException(""));
    }
}
