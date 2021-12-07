package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.entity.Role;

public interface RoleRepository extends JpaRepository<Role,Integer>{
	Role findByRole(String role);
}
