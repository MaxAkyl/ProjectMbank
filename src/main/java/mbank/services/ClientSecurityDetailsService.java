package mbank.services;

import lombok.RequiredArgsConstructor;
import mbank.exceptions.NotFoundException;
import mbank.models.Client;
import mbank.repositories.ClientRepository;
import mbank.security.ClientSecurityDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientSecurityDetailsService implements UserDetailsService {

    private final ClientRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Client client = repository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Client with email = %s does not exists in database", email)
                ));

        return new ClientSecurityDetails(client);
    }
}
