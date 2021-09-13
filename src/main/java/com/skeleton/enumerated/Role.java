package com.skeleton.enumerated;

import java.util.Arrays;
import java.util.List;

public enum Role {
    ROLE_SUPERADMIN, ROLE_ADMIN, ROLE_USER;

    public static List<Role> getListWithoutSuperadmin() {
        return Arrays.asList(ROLE_ADMIN, ROLE_USER);
    }
}
