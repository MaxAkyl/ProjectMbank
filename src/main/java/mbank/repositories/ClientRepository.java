package mbank.repositories;

import mbank.models.Client;

import java.util.Optional;

public interface ClientRepository {

    void save(Client client);

    Optional<Client> findByEmail(String email);
}
