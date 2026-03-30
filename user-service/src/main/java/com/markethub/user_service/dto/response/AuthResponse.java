package com.markethub.user_service.dto.response;

public class AuthResponse {
    private String accessToken;
    private String tokenType;
    public AuthResponse() {}

    AuthResponse(String accessToken, String tokenType) {
        this.accessToken = accessToken;
        this.tokenType = tokenType;
    }

    public static AuthResponseBuilder builder() {
        return new AuthResponseBuilder();
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getTokenType() {
        return this.tokenType;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof AuthResponse)) return false;
        final AuthResponse other = (AuthResponse) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$accessToken = this.getAccessToken();
        final Object other$accessToken = other.getAccessToken();
        if (this$accessToken == null ? other$accessToken != null : !this$accessToken.equals(other$accessToken))
            return false;
        final Object this$tokenType = this.getTokenType();
        final Object other$tokenType = other.getTokenType();
        if (this$tokenType == null ? other$tokenType != null : !this$tokenType.equals(other$tokenType)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AuthResponse;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $accessToken = this.getAccessToken();
        result = result * PRIME + ($accessToken == null ? 43 : $accessToken.hashCode());
        final Object $tokenType = this.getTokenType();
        result = result * PRIME + ($tokenType == null ? 43 : $tokenType.hashCode());
        return result;
    }

    public String toString() {
        return "AuthResponse(accessToken=" + this.getAccessToken() + ", tokenType=" + this.getTokenType() + ")";
    }

    public static class AuthResponseBuilder {
        private String accessToken;
        private String tokenType;

        AuthResponseBuilder() {
        }

        public AuthResponseBuilder accessToken(String accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        public AuthResponseBuilder tokenType(String tokenType) {
            this.tokenType = tokenType;
            return this;
        }

        public AuthResponse build() {
            return new AuthResponse(accessToken, tokenType);
        }

        public String toString() {
            return "AuthResponse.AuthResponseBuilder(accessToken=" + this.accessToken + ", tokenType=" + this.tokenType + ")";
        }
    }
}
