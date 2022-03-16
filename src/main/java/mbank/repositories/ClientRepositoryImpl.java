package mbank.repositories;

import mBankProject.models.Client;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    private final SessionFactory sessionFactory;

    public ClientRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Client client) {
        sessionFactory.getCurrentSession().save(client);
    }

    @Override
    public Optional<Client> findByEmail(String email) {
        int clientId = sessionFactory.getCurrentSession()
                .createQuery("SELECT c FROM Client c WHERE c.email = ?").executeUpdate();
        System.out.println(clientId);
        return null;
    }
}
