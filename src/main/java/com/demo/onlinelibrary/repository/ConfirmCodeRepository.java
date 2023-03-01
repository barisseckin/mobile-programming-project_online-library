package com.demo.onlinelibrary.repository;

import com.demo.onlinelibrary.model.ConfirmCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConfirmCodeRepository extends JpaRepository<ConfirmCode, Long> {
    Optional<ConfirmCode> findConfirmCodeByCode(int code);
}
