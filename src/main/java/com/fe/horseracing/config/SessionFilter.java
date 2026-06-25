package com.fe.horseracing.config;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import com.fe.horseracing.pojo.User;

@Component
public class SessionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization logic if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        String path = httpRequest.getRequestURI();
        
        // Bỏ qua filter đối với các endpoint đăng nhập, đăng ký và tài nguyên tĩnh
        if (path.startsWith("/auth/") || path.startsWith("/css/") || path.startsWith("/js/") || path.startsWith("/images/")) {
            chain.doFilter(request, response);
            return;
        }

        HttpSession session = httpRequest.getSession(false);
        boolean loggedIn = (session != null && session.getAttribute("loggedInUser") != null);

        // Nếu cố gắng truy cập các đường dẫn được bảo vệ (ví dụ: /user/...) mà chưa đăng nhập
        if (path.startsWith("/user/") && !loggedIn) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/auth/login");
            return;
        }
        
        // Optional: Phân quyền cụ thể hơn (ví dụ /admin/ bắt buộc Role ADMIN)
        if (path.startsWith("/user/admin/")) {
            if (!loggedIn) {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/auth/login");
                return;
            }
            User user = (User) session.getAttribute("loggedInUser");
            boolean isAdmin = user.getRoles().stream().anyMatch(role -> "ADMIN".equals(role.getRoleName()));
            if (!isAdmin) {
                httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied. Admin role required.");
                return;
            }
        }

        // Cho phép request đi tiếp
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Cleanup logic if needed
    }
}
