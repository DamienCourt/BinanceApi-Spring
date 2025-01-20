package my.BinanceApi.repositories;

import my.BinanceApi.models.Coin;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CoinRepository extends CrudRepository<Coin, Long> {

    List<Coin> getCoinsByName(String name);
}
