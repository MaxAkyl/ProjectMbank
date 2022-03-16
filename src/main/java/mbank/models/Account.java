package mbank.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "account")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String accountNumber;

    @OneToOne
    private Client holder;

    private BigDecimal amount;

    private boolean nonLocked;
}