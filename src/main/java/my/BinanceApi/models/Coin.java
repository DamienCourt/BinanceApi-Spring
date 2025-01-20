package my.BinanceApi.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "coins")
public class Coin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "coin_name")
    private String name;

    @Column(name = "coin_amount")
    private BigDecimal amount;

    @Column(name = "coin_price")
    private BigDecimal purchasePrice;

    @Column(name = "purchase_value")
    private BigDecimal purchaseValue;


}
