package com.fe.horseracing.repository.interfaces;

import java.util.List;

import com.fe.horseracing.pojo.Admin;

public interface IAdminRepository {

    void save(Admin admin);

    void update(Admin admin);

    void delete(Long adminId);

    Admin findById(Long adminId);

    List<Admin> findAll();

}