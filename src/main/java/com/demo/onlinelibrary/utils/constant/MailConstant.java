package com.demo.onlinelibrary.utils.constant;

public class MailConstant {

    private MailConstant() {
        throw new UnsupportedOperationException();
    }

    public static final String SEND_CONFIRM_CODE_TITLE = "Online Library App Confirm Code";
    public static final String SEND_CONFIRM_CODE_BODY = "Hi your account activate code %s";
    public static final String REMINDER_TITLE = "Hello, we noticed that you have not read the book you are reading for a while.";
    public static final String REMINDER_BODY = "We look forward to continuing reading!";
}
