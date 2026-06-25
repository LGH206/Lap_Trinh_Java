package com.fe.horseracing.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fe.horseracing.DAO.UserDAO;
import com.fe.horseracing.pojo.User;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public User getUserProfile(Long userId) {
        return userDAO.findById(userId);
    }

    public void updateProfile(User updatedUser) {
        User existingUser = userDAO.findById(updatedUser.getUserId());
        if (existingUser != null) {
            existingUser.setFirstName(updatedUser.getFirstName());
            existingUser.setLastName(updatedUser.getLastName());
            existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
            // Có thể thêm việc update password hoặc email nếu cần,
            // nhưng thường email không cho update hoặc cần xác thực lại.
            userDAO.update(existingUser);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public List<User> getAllUsers() {
        return userDAO.findAll();
    }
    
    public void deleteUser(Long userId) {
        userDAO.delete(userId);
    }
}
