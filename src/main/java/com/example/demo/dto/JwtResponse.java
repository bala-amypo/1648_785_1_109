package com.example.demo.dto;

public class JwtResponse {
    private String token;
    private Long userId;
    private String email;
    private String role;

    public JwtResponse(String token, Long userId, String email, String role) {
        this.token = token;
        this.userId = userId;
        this.email = email;
        this.role = role;
    }

    // Getters
    public String getToken() { return token; }
    public Long getUserId() { return userId; }
    public String getEmail() { return email; }
    public String getRole() { return role; }
}


package com.example.demo.dto;

public class LoginRequest {
    private String email;
    private String password;

    // Getters and Setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}


package com.example.demo.dto;

public class RegisterRequest {
    private String fullName;
    private String email;
    private String password;
    private String role;
    private String userId; // Add this field

    // Getters and Setters
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getUserId() { return userId; } // Add this getter
    public void setUserId(String userId) { this.userId = userId; } // Add this setter
}