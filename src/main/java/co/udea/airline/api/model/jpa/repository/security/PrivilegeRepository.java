package co.udea.airline.api.model.jpa.repository.security;

import org.springframework.data.jpa.repository.JpaRepository;

import co.udea.airline.api.model.jpa.model.security.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

}
