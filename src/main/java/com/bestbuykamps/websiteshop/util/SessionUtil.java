package com.bestbuykamps.websiteshop.util;

import com.bestbuykamps.websiteshop.web_controller.CartController;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SessionUtil {
    private static final Logger logger = LoggerFactory.getLogger(SessionUtil.class);

    public String checkSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false); // Do not create a new session if it doesn't exist
        if (session != null) {
            logger.info("Session ID existed: {}", session.getId());
            return session.getId();
        } else {
            session = request.getSession();
            logger.info("Created new ID: {}", session.getId());
            return session.getId();
        }
    }
}
