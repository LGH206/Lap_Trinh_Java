package com.example.app.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "com.example.app") // Quét và kích hoạt @Repository, @Service
public class AppConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        // Cấu hình Driver kết nối MySQL
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        
        // Bạn nhớ thay "ten_database_cua_ban" thành tên Schema DB bạn đã tạo trong MySQL/XAMPP nhé
        dataSource.setUrl("jdbc:mysql://localhost:3306/ten_database_cua_ban?useSSL=false&serverTimezone=UTC");
        dataSource.setUsername("root"); // Tài khoản mặc định là root
        dataSource.setPassword("");     // Mật khẩu XAMPP mặc định để trống, nếu dùng Workbench thì điền pass của bạn vào
        
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
