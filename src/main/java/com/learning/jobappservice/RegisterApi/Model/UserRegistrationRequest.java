package com.learning.jobappservice.RegisterApi.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UserRegistrationRequest {

    @Email(message = "Invalid email address")
    private String email;

    @NotBlank(message = "Mobile number is required")
    @Pattern(
            regexp = "^(92[1-9][0-9]{9}|0[1-9][0-9]{9})$",
            message = "Invalid mobile number format. Must start with 92 or 0"
    )
    private String mobile;

    @NotBlank(message = "CNIC number is required")
    @Pattern(
            regexp = "^[0-9]{13}$",
            message = "CNIC must be exactly 13 digits"
    )
    private String cnic;

    // Getters and setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    public String getCnic() { return cnic; }
    public void setCnic(String cnic) { this.cnic = cnic; }
}
