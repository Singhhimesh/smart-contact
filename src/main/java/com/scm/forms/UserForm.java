package com.scm.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserForm {
    @NotBlank(message = "Username is required")
    @Size(min=3, max=255, message="Minimum 3 and maximum 12 character")
    private String name;

    @Email(message = "Invalid email provided")
    @NotBlank(message = "Email is required")
    private String email;

    @Size(min = 10, max = 12, message = "Invalid phone number")
    private String phone;

    @Size(min=6, max=10, message = "Password should be 6 to 10 character")
    private String password;

    @Size(min = 3, max = 255, message = "About should be minimum 3 charater to 255 charater")
    private String about;
}
