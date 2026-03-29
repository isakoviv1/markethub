package com.markethub.user_service.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
    @NotBlank(message = "Email is mandatory")
    @Email
    private String email;

    @NotBlank(message = "Password is mandatory")
    private String password;

    LoginRequest(@NotBlank(message = "Email is mandatory") @Email String email, @NotBlank(message = "Password is mandatory") String password) {
        this.email = email;
        this.password = password;
    }

    public static LoginRequestBuilder builder() {
        return new LoginRequestBuilder();
    }

    public @NotBlank(message = "Email is mandatory") @Email String getEmail() {
        return this.email;
    }

    public @NotBlank(message = "Password is mandatory") String getPassword() {
        return this.password;
    }

    public void setEmail(@NotBlank(message = "Email is mandatory") @Email String email) {
        this.email = email;
    }

    public void setPassword(@NotBlank(message = "Password is mandatory") String password) {
        this.password = password;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof LoginRequest)) return false;
        final LoginRequest other = (LoginRequest) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof LoginRequest;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        return result;
    }

    public String toString() {
        return "LoginRequest(email=" + this.getEmail() + ", password=" + this.getPassword() + ")";
    }

    public static class LoginRequestBuilder {
        private @NotBlank(message = "Email is mandatory") @Email String email;
        private @NotBlank(message = "Password is mandatory") String password;

        LoginRequestBuilder() {
        }

        public LoginRequestBuilder email(@NotBlank(message = "Email is mandatory") @Email String email) {
            this.email = email;
            return this;
        }

        public LoginRequestBuilder password(@NotBlank(message = "Password is mandatory") String password) {
            this.password = password;
            return this;
        }

        public LoginRequest build() {
            return new LoginRequest(email, password);
        }

        public String toString() {
            return "LoginRequest.LoginRequestBuilder(email=" + this.email + ", password=" + this.password + ")";
        }
    }
}
