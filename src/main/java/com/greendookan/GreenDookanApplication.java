package com.greendookan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Green Dooan - E-Commerce Shopping Cart System
 * Main Spring Boot Application Class
 * 
 * @author Aditi Anand
 * @version 1.0.0
 */
@SpringBootApplication
public class GreenDookanApplication {

    public static void main(String[] args) {
        SpringApplication.run(GreenDookanApplication.class, args);
        System.out.println("\n" +
                "  ██████╗ ██████╗ ███████╗███████╗███╗   ██╗    ██████╗  ██████╗  ██████╗  █████╗ ███╗   ██╗\n" +
                " ██╔════╝ ██╔══██╗██╔════╝██╔════╝████╗  ██║    ██╔══██╗██╔═══██╗██╔═══██╗██╔══██╗████╗  ██║\n" +
                " ██║  ███╗██████╔╝█████╗  █████╗  ██╔██╗ ██║    ██║  ██║██║   ██║██║   ██║███████║██╔██╗ ██║\n" +
                " ██║   ██║██╔══██╗██╔══╝  ██╔══╝  ██║╚██╗██║    ██║  ██║██║   ██║██║   ██║██╔══██║██║╚██╗██║\n" +
                " ╚██████╔╝██║  ██║███████╗███████╗██║ ╚████║    ██████╔╝╚██████╔╝╚██████╔╝██║  ██║██║ ╚████║\n" +
                "  ╚═════╝ ╚═╝  ╚═╝╚══════╝╚══════╝╚═╝  ╚═══╝    ╚═════╝  ╚═════╝  ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝\n" +
                "\n" +
                " 🌿 E-Commerce Shopping Cart System\n" +
                " 🚀 Application started successfully!\n" +
                " 🌐 Access at: http://localhost:8080\n" +
                " 🔐 Admin Login: admin@greendookan.com / admin123\n" +
                "\n");
    }

    /**
     * Password encoder bean for secure password storage
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
