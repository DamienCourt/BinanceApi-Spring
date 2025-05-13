package my.BinanceApi.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BinanceRepository extends KeyRepository {

    @Override
    @Query(value = "SELECT key.public_key FROM keys key WHERE key.id = :id", nativeQuery = true)
    String getPublicKeyById(long id);

    @Override
    @Query(value = "SELECT key.secret_key FROM keys key WHERE key.id = :id", nativeQuery = true)
    String getSecretKeyById(long id);
}