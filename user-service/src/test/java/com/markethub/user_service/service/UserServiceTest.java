package com.markethub.user_service.service;
import com.markethub.user_service.domain.entity.User;
import com.markethub.user_service.domain.enums.Role;
import com.markethub.user_service.dto.request.LoginRequest;
import com.markethub.user_service.dto.request.RegisterRequest;
import com.markethub.user_service.dto.response.AuthResponse;
import com.markethub.user_service.dto.response.UserProfileResponse;
import com.markethub.user_service.repository.UserRepository;
import com.markethub.user_service.security.JwtService;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private JwtService jwtService;
    @InjectMocks
    private UserService userService;

    @Nested
    class Register {

        @org.junit.jupiter.api.Test
        void registersNewUserAndReturnsAuthResponse() {
            RegisterRequest request = RegisterRequest.builder()
                    .firstname("John")
                    .lastname("Doe")
                    .email("john@example.com")
                    .password("password")
                    .build();

            when(userRepository.findByEmail("john@example.com")).thenReturn(Optional.empty());
            when(passwordEncoder.encode("password")).thenReturn("hashed");
            when(jwtService.generateToken(any(User.class))).thenReturn("jwt-token");

            AuthResponse response = userService.register(request);

            ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
            verify(userRepository).save(userCaptor.capture());
            User savedUser = userCaptor.getValue();

            assertThat(savedUser.getFirstname()).isEqualTo("John");
            assertThat(savedUser.getLastname()).isEqualTo("Doe");
            assertThat(savedUser.getEmail()).isEqualTo("john@example.com");
            assertThat(savedUser.getPassword()).isEqualTo("hashed");
            assertThat(savedUser.getRole()).isEqualTo(Role.USER);

            assertThat(response.getAccessToken()).isEqualTo("jwt-token");
            assertThat(response.getTokenType()).isEqualTo("Bearer");
        }

        @org.junit.jupiter.api.Test
        void throwsWhenUserAlreadyExists() {
            RegisterRequest request = RegisterRequest.builder()
                    .email("existing@example.com")
                    .build();

            when(userRepository.findByEmail("existing@example.com")).thenReturn(Optional.of(mock(User.class)));

            assertThatThrownBy(() -> userService.register(request))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessageContaining("User already exists");
        }
    }

    @Nested
    class Login {

        @org.junit.jupiter.api.Test
        void returnsAuthResponseWhenCredentialsAreValid() {
            LoginRequest request = LoginRequest.builder()
                    .email("john@example.com")
                    .password("password")
                    .build();

            User user = User.builder()
                    .email("john@example.com")
                    .password("hashed")
                    .build();

            when(userRepository.findByEmail("john@example.com")).thenReturn(Optional.of(user));
            when(passwordEncoder.matches("password", "hashed")).thenReturn(true);
            when(jwtService.generateToken(user)).thenReturn("jwt-token");

            AuthResponse response = userService.login(request);

            assertThat(response.getAccessToken()).isEqualTo("jwt-token");
            assertThat(response.getTokenType()).isEqualTo("Bearer");
        }

        @org.junit.jupiter.api.Test
        void throwsWhenUserNotFound() {
            LoginRequest request = LoginRequest.builder()
                    .email("notfound@example.com")
                    .password("password")
                    .build();

            when(userRepository.findByEmail("notfound@example.com")).thenReturn(Optional.empty());

            assertThatThrownBy(() -> userService.login(request))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessageContaining("User not found");
        }

        @org.junit.jupiter.api.Test
        void throwsWhenPasswordIsWrong() {
            LoginRequest request = LoginRequest.builder()
                    .email("john@example.com")
                    .password("wrongpassword")
                    .build();

            User user = User.builder()
                    .email("john@example.com")
                    .password("hashed")
                    .build();

            when(userRepository.findByEmail("john@example.com")).thenReturn(Optional.of(user));
            when(passwordEncoder.matches("wrongpassword", "hashed")).thenReturn(false);

            assertThatThrownBy(() -> userService.login(request))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessageContaining("Password is wrong");
        }
    }

    @Nested
    class GetProfile {

        @org.junit.jupiter.api.Test
        void returnsUserProfileResponseWhenUserExists() {
            User user = User.builder()
                    .firstname("Jane")
                    .lastname("Smith")
                    .email("jane@example.com")
                    .role(Role.USER)
                    .build();

            when(userRepository.findByEmail("jane@example.com")).thenReturn(Optional.of(user));

            UserProfileResponse response = userService.getProfile("jane@example.com");

            assertThat(response.getFirstname()).isEqualTo("Jane");
            assertThat(response.getLastname()).isEqualTo("Smith");
            assertThat(response.getEmail()).isEqualTo("jane@example.com");
            assertThat(response.getRole()).isEqualTo(Role.USER);
        }

        @org.junit.jupiter.api.Test
        void throwsWhenUserNotFound() {
            when(userRepository.findByEmail("missing@example.com")).thenReturn(Optional.empty());

            assertThatThrownBy(() -> userService.getProfile("missing@example.com"))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessageContaining("User not found");
        }
    }
}