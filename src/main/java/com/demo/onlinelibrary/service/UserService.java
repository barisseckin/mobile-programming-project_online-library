package com.demo.onlinelibrary.service;

import com.demo.onlinelibrary.dto.UserDto;
import com.demo.onlinelibrary.model.ConfirmCode;
import com.demo.onlinelibrary.model.User;
import com.demo.onlinelibrary.repository.UserRepository;
import com.demo.onlinelibrary.request.CreateUserRequest;
import com.demo.onlinelibrary.utils.ConfirmCodeService;
import com.demo.onlinelibrary.utils.MailSenderService;
import static com.demo.onlinelibrary.utils.constant.MailConstant.*;
import com.demo.onlinelibrary.dto.converter.UserDtoConverter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserDtoConverter dtoConverter;
    private final MailSenderService mailSenderService;
    private final ConfirmCodeService confirmCodeService;

    public UserService(UserRepository userRepository,
                       UserDtoConverter dtoConverter,
                       MailSenderService mailSenderService,
                       ConfirmCodeService confirmCodeService) {
        this.userRepository = userRepository;
        this.dtoConverter = dtoConverter;
        this.mailSenderService = mailSenderService;
        this.confirmCodeService = confirmCodeService;
    }

    public UserDto save(CreateUserRequest request) {
        var saved = new User(
                request.getUsername(),
                request.getMail(),
                request.getPassword()
        );

        userRepository.save(saved);
        return dtoConverter.toDto(saved);
    }

    public void sendConfirmCode(String mail) {
        ConfirmCode confirmCode = new ConfirmCode();

        var fromDbUser = getByMail(mail);
        fromDbUser.setConfirmCode(confirmCode);

        confirmCodeService.save(confirmCode);
        userRepository.save(fromDbUser);

        String mailContent = String.format(SEND_CONFIRM_CODE_BODY, confirmCode.getCode());
        mailSenderService.send(fromDbUser.getMail(), SEND_CONFIRM_CODE_TITLE, mailContent);
    }

    public UserDto activateUser(String mail, int code) {
        var fromDbUser = getByMail(mail);

        if (fromDbUser.getConfirmCode().getCode() == code) {
            fromDbUser.setActive(true);
            fromDbUser.setUpdateDate(LocalDateTime.now());

            userRepository.save(fromDbUser);
            confirmCodeService.delete(confirmCodeService.getByCode(code));

            return dtoConverter.toDto(fromDbUser);
        }

        return null;
    }

    public void delete(String mail) {
        var fromDbUser = getByMail(mail);
        userRepository.deleteById(fromDbUser.getId());
    }

    protected User getByMail(String mail) {
        return userRepository.findUserByMail(mail)
                .orElseThrow(() -> new RuntimeException(""));
    }

}
