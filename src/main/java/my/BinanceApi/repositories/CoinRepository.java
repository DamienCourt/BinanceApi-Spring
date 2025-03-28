package my.BinanceApi.repositories;

import jakarta.annotation.Nonnull;
import my.BinanceApi.models.Coin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CoinRepository extends CrudRepository<Coin, Long> {

    @Override
    @Nonnull
    List<Coin> findAll();
    List<Coin> findAllByOrderByName();
    List<Coin> findByName(String name);

}
