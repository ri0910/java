package com.riya.EcommerceApplicationBackend.api.repo;


import com.riya.EcommerceApplicationBackend.model.LocalUser;
import com.riya.EcommerceApplicationBackend.model.WebOrder;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WebOrderRepository extends ListCrudRepository<WebOrder, Long> {

    List<WebOrder> findByUser(LocalUser user);
}
