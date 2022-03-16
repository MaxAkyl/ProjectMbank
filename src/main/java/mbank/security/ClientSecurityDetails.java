package mbank.security;

import mbank.models.Client;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class ClientSecurityDetails implements UserDetails {
    private final Client client;

    public ClientSecurityDetails(Client client) {
        this.client = client;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(client.getRole());
    }

    @Override
    public String getPassword() {
        return client.getPassword();
    }

    @Override
    public String getUsername() {
        return client.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return client.getAccount().isNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

