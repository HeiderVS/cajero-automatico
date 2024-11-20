package prueba.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "accounts")
public class Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountId;
    private int account_number;
    private int account_holder;
    private int account_balance;
    private int account_nip;

    public void retiro (int monto){
        account_balance -= monto;
    }
}
