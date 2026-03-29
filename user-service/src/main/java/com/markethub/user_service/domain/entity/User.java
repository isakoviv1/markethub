package com.markethub.user_service.domain.entity;

import com.markethub.user_service.domain.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class User {

    public User(Long id, Role role, @NotBlank(message = "Lastrame is mandatory") String lastname, @NotBlank(message = "Firstname is mandatory") String firstname, @NotBlank(message = "E-mail is mandatory") @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$") String email, @NotBlank(message = "Password is mandatory") String password, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.role = role;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public User() {
    }

    private static Role $default$role() {
        return Role.USER;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public String getEmail() {
        return this.email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

    @NotBlank(message = "Lastrame is mandatory")
    private String lastname;

    @NotBlank(message = "Firstname is mandatory")
    private String firstname;

    @NotBlank(message = "E-mail is mandatory")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
    private String email;

    @NotBlank(message = "Password is mandatory")
    private String password;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public Long getId() {
        return this.id;
    }

    public Role getRole() {
        return this.role;
    }

    public @NotBlank(message = "Lastrame is mandatory") String getLastname() {
        return this.lastname;
    }

    public @NotBlank(message = "Firstname is mandatory") String getFirstname() {
        return this.firstname;
    }

    public @NotBlank(message = "Password is mandatory") String getPassword() {
        return this.password;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setLastname(@NotBlank(message = "Lastrame is mandatory") String lastname) {
        this.lastname = lastname;
    }

    public void setFirstname(@NotBlank(message = "Firstname is mandatory") String firstname) {
        this.firstname = firstname;
    }

    public void setEmail(@NotBlank(message = "E-mail is mandatory") @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$") String email) {
        this.email = email;
    }

    public void setPassword(@NotBlank(message = "Password is mandatory") String password) {
        this.password = password;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof User)) return false;
        final User other = (User) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$role = this.getRole();
        final Object other$role = other.getRole();
        if (this$role == null ? other$role != null : !this$role.equals(other$role)) return false;
        final Object this$lastname = this.getLastname();
        final Object other$lastname = other.getLastname();
        if (this$lastname == null ? other$lastname != null : !this$lastname.equals(other$lastname)) return false;
        final Object this$firstname = this.getFirstname();
        final Object other$firstname = other.getFirstname();
        if (this$firstname == null ? other$firstname != null : !this$firstname.equals(other$firstname)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        final Object this$createdAt = this.getCreatedAt();
        final Object other$createdAt = other.getCreatedAt();
        if (this$createdAt == null ? other$createdAt != null : !this$createdAt.equals(other$createdAt)) return false;
        final Object this$updatedAt = this.getUpdatedAt();
        final Object other$updatedAt = other.getUpdatedAt();
        if (this$updatedAt == null ? other$updatedAt != null : !this$updatedAt.equals(other$updatedAt)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof User;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $role = this.getRole();
        result = result * PRIME + ($role == null ? 43 : $role.hashCode());
        final Object $lastname = this.getLastname();
        result = result * PRIME + ($lastname == null ? 43 : $lastname.hashCode());
        final Object $firstname = this.getFirstname();
        result = result * PRIME + ($firstname == null ? 43 : $firstname.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        final Object $createdAt = this.getCreatedAt();
        result = result * PRIME + ($createdAt == null ? 43 : $createdAt.hashCode());
        final Object $updatedAt = this.getUpdatedAt();
        result = result * PRIME + ($updatedAt == null ? 43 : $updatedAt.hashCode());
        return result;
    }

    public String toString() {
        return "User(id=" + this.getId() + ", role=" + this.getRole() + ", lastname=" + this.getLastname() + ", firstname=" + this.getFirstname() + ", email=" + this.getEmail() + ", password=" + this.getPassword() + ", createdAt=" + this.getCreatedAt() + ", updatedAt=" + this.getUpdatedAt() + ")";
    }

    public static class UserBuilder {
        private Long id;
        private Role role$value;
        private boolean role$set;
        private @NotBlank(message = "Lastrame is mandatory") String lastname;
        private @NotBlank(message = "Firstname is mandatory") String firstname;
        private @NotBlank(message = "E-mail is mandatory") @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$") String email;
        private @NotBlank(message = "Password is mandatory") String password;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        UserBuilder() {
        }

        public UserBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public UserBuilder role(Role role) {
            this.role$value = role;
            this.role$set = true;
            return this;
        }

        public UserBuilder lastname(@NotBlank(message = "Lastrame is mandatory") String lastname) {
            this.lastname = lastname;
            return this;
        }

        public UserBuilder firstname(@NotBlank(message = "Firstname is mandatory") String firstname) {
            this.firstname = firstname;
            return this;
        }

        public UserBuilder email(@NotBlank(message = "E-mail is mandatory") @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$") String email) {
            this.email = email;
            return this;
        }

        public UserBuilder password(@NotBlank(message = "Password is mandatory") String password) {
            this.password = password;
            return this;
        }

        public UserBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public UserBuilder updatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public User build() {
            Role role$value = this.role$value;
            if (!this.role$set) {
                role$value = User.$default$role();
            }
            return new User(id, role$value, lastname, firstname, email, password, createdAt, updatedAt);
        }

        public String toString() {
            return "User.UserBuilder(id=" + this.id + ", role$value=" + this.role$value + ", lastname=" + this.lastname + ", firstname=" + this.firstname + ", email=" + this.email + ", password=" + this.password + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ")";
        }
    }
}
