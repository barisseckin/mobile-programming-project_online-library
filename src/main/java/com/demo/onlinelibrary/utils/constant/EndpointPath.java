package com.demo.onlinelibrary.utils.constant;

public class EndpointPath {

    private EndpointPath() {
        throw new UnsupportedOperationException();
    }

    public static final String BASE_PATH = "/api/v1";
    public static final String BOOK_PATH = BASE_PATH + "/book";
    public static final String USER_PATH = BASE_PATH + "/user";
    public static final String CATEGORY_PATH = BASE_PATH + "/category";
}
