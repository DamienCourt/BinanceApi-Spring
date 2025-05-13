package my.BinanceApi.repositories;

import my.BinanceApi.models.Coin;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;


//@NoRepositoryBean
//Repository interfaces for which Spring Data should not create instances at runtime

public interface KeyRepository extends Repository<Coin, Long> {

    String getPublicKeyById(long id);
    String getSecretKeyById(long id);
}
