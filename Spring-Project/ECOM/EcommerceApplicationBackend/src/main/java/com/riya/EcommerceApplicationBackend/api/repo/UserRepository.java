package com.riya.EcommerceApplicationBackend.api.repo;

import com.riya.EcommerceApplicationBackend.model.LocalUser;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends ListCrudRepository<LocalUser, Long> {
    Optional<LocalUser> findByUsernameIgnoreCase(String username);

    Optional<LocalUser> findByEmailIgnoreCase(String email);
}
