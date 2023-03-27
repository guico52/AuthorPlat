package com.guico.authorplat.redis;

import java.util.concurrent.TimeUnit;

public class RedisConstants {
//    ==================  redis key constants  =======================
    public static final String USER_REGISTER = "user:register:";
    public static final String USER_LOGIN = "user:login:";
    public static final String USER_RESET_PASSWORD = "user:reset:password:";

//    ==================  redis timeout constants  ===================

    public static final Long DEFAULT_TIME_OUT = 3L;

    public static final TimeUnit DEFAULT_TIME_UNIT = TimeUnit.HOURS;

    public static final Long LOGIN_TIME_OUT = 7L;

    public static final TimeUnit LOGIN_TIME_UNIT = TimeUnit.DAYS;

}
