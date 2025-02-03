package my.BinanceApi.models;

import java.math.BigDecimal;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "coins")
public class Coin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "coin_name", nullable = false )
    private String name;

    @Column(name = "coin_amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "coin_price", nullable = false)
    private BigDecimal purchasePrice;

    @Column(name = "purchase_value", nullable = false)
    private BigDecimal purchaseValue;


}
