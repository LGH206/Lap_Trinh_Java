package com.fe.horseracing.service;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fe.horseracing.DAO.RoleDAO;
import com.fe.horseracing.DAO.UserDAO;
import com.fe.horseracing.pojo.Role;
import com.fe.horseracing.pojo.User;
// LƯU Ý: Tạm thời chưa dùng BCrypt cho mật khẩu theo yêu cầu đơn giản hóa ở bước này.

@Service
public class AuthService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

    public User login(String username, String password) {
        User user = userDAO.findByUserName(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public User register(User user, String defaultRoleName) {
        // Kiểm tra xem user hoặc email đã tồn tại chưa
        if (userDAO.findByUserName(user.getUserName()) != null) {
            throw new RuntimeException("Username already exists");
        }
        if (userDAO.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Email already exists");
        }

        // Gán Role mặc định (ví dụ: SPECTATOR, HORSE_OWNER)
        Role role = roleDAO.findByRoleName(defaultRoleName);
        if (role != null) {
            Set<Role> roles = new HashSet<>();
            roles.add(role);
            user.setRoles(roles);
        }

        userDAO.save(user);
        return user;
    }
}
