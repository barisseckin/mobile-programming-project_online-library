package com.demo.onlinelibrary.scheduled;

import com.demo.onlinelibrary.dto.BookDto;
import com.demo.onlinelibrary.service.BookService;
import com.demo.onlinelibrary.utils.MailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static com.demo.onlinelibrary.utils.constant.MailConstant.REMINDER_TITLE;
import static com.demo.onlinelibrary.utils.constant.MailConstant.REMINDER_BODY;

@Component
@RequiredArgsConstructor
public class BookReadReminder {

    private final MailSenderService mailSenderService;
    private final BookService bookService;

    @Scheduled(fixedRateString = "${reminder.read-alarm-value}")
    public void executeReminder() {
        for (BookDto book : bookService.getAll()) {
            if (book.getUpdateDate().isBefore(book.getUpdateDate().plusDays(3))) {
                mailSenderService.send(
                        book.getUser().getMail(),
                        REMINDER_TITLE,
                        REMINDER_BODY
                );
            }
        }
    }
}
