package com.irix.business.repository;

import com.irix.business.entity.ClientsData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDataRepository extends JpaRepository<ClientsData, Long> {
}
