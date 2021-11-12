package com.example.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;

/*
store the UserContext in a ThreadLocal variable that is
accessible by any method being invoked by the thread processing the user’s request.
 */
public class UserContextHolder {

    private static final ThreadLocal<UserContext> userContext = new ThreadLocal<UserContext>();

    public static UserContext getContext() {
        UserContext context = userContext.get();
        if (context == null) {
            context = createEmptyContext();
            userContext.set(context);
        }
        return userContext.get();
    }

    public static void setContext(UserContext context) {
        Assert.notNull(context,
                "Only non-null UserContext instances are permitted");
        userContext.set(context);
    }

    public static UserContext createEmptyContext() {
        return new UserContext();
    }
}
