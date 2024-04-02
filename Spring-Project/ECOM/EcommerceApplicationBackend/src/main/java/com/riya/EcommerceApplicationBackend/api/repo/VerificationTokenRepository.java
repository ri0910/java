package com.riya.EcommerceApplicationBackend.api.repo;

import com.riya.EcommerceApplicationBackend.model.LocalUser;
import com.riya.EcommerceApplicationBackend.model.VerificationToken;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface VerificationTokenRepository extends ListCrudRepository<VerificationToken, Long> {
    Optional<VerificationToken> findByToken(String token);

    void deleteByUser(LocalUser user);
}
