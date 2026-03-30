package com.markethub.user_service.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class RegisterRequest {
    @NotBlank(message = "Email is mandatory")
    @Email
    private String email;

    @NotBlank(message = "Password is mandatory")
    private String password;

    @NotBlank(message = "Firstname is mandatory")
    private String firstname;

    @NotBlank(message = "Lastname is mandatory")
    private String lastname;

    RegisterRequest(@NotBlank(message = "Email is mandatory") @Email String email, @NotBlank(message = "Password is mandatory") String password, @NotBlank(message = "Firstname is mandatory") String firstname, @NotBlank(message = "Lastname is mandatory") String lastname) {
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public RegisterRequest() {}

    public static RegisterRequestBuilder builder() {
        return new RegisterRequestBuilder();
    }

    public @NotBlank(message = "Email is mandatory") @Email String getEmail() {
        return this.email;
    }

    public @NotBlank(message = "Password is mandatory") String getPassword() {
        return this.password;
    }

    public @NotBlank(message = "Firstname is mandatory") String getFirstname() {
        return this.firstname;
    }

    public @NotBlank(message = "Lastname is mandatory") String getLastname() {
        return this.lastname;
    }

    public void setEmail(@NotBlank(message = "Email is mandatory") @Email String email) {
        this.email = email;
    }

    public void setPassword(@NotBlank(message = "Password is mandatory") String password) {
        this.password = password;
    }

    public void setFirstname(@NotBlank(message = "Firstname is mandatory") String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(@NotBlank(message = "Lastname is mandatory") String lastname) {
        this.lastname = lastname;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof RegisterRequest)) return false;
        final RegisterRequest other = (RegisterRequest) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        final Object this$firstname = this.getFirstname();
        final Object other$firstname = other.getFirstname();
        if (this$firstname == null ? other$firstname != null : !this$firstname.equals(other$firstname)) return false;
        final Object this$lastname = this.getLastname();
        final Object other$lastname = other.getLastname();
        if (this$lastname == null ? other$lastname != null : !this$lastname.equals(other$lastname)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof RegisterRequest;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        final Object $firstname = this.getFirstname();
        result = result * PRIME + ($firstname == null ? 43 : $firstname.hashCode());
        final Object $lastname = this.getLastname();
        result = result * PRIME + ($lastname == null ? 43 : $lastname.hashCode());
        return result;
    }

    public String toString() {
        return "RegisterRequest(email=" + this.getEmail() + ", password=" + this.getPassword() + ", firstname=" + this.getFirstname() + ", lastname=" + this.getLastname() + ")";
    }

    public static class RegisterRequestBuilder {
        private @NotBlank(message = "Email is mandatory") @Email String email;
        private @NotBlank(message = "Password is mandatory") String password;
        private @NotBlank(message = "Firstname is mandatory") String firstname;
        private @NotBlank(message = "Lastname is mandatory") String lastname;

        RegisterRequestBuilder() {
        }

        public RegisterRequestBuilder email(@NotBlank(message = "Email is mandatory") @Email String email) {
            this.email = email;
            return this;
        }

        public RegisterRequestBuilder password(@NotBlank(message = "Password is mandatory") String password) {
            this.password = password;
            return this;
        }

        public RegisterRequestBuilder firstname(@NotBlank(message = "Firstname is mandatory") String firstname) {
            this.firstname = firstname;
            return this;
        }

        public RegisterRequestBuilder lastname(@NotBlank(message = "Lastname is mandatory") String lastname) {
            this.lastname = lastname;
            return this;
        }

        public RegisterRequest build() {
            return new RegisterRequest(email, password, firstname, lastname);
        }

        public String toString() {
            return "RegisterRequest.RegisterRequestBuilder(email=" + this.email + ", password=" + this.password + ", firstname=" + this.firstname + ", lastname=" + this.lastname + ")";
        }
    }
}
