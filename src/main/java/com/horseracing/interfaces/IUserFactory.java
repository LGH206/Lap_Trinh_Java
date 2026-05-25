package com.horseracing.interfaces;

import com.horseracing.entity.User;

public interface IUserFactory {
    User createUser(String role);
}
