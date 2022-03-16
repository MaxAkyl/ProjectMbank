package mbank.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "clients")
@Getter @Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String fullName;

    private String email;

    private String password;

    private Role role;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

    public Client() {
    }

    public Client(String fullName, String email, String password, Role role) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
