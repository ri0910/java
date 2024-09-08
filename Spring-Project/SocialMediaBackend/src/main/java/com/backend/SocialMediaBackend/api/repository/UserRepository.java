package com.backend.SocialMediaBackend.api.repository;


import com.backend.SocialMediaBackend.model.LocalUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<LocalUser, Long> {

    Optional<LocalUser> findByEmailIgnoreCase(String email);
}
