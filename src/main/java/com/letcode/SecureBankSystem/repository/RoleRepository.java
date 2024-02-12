package com.letcode.SecureBankSystem.repository;

import com.letcode.SecureBankSystem.entity.RoleEntity;
import org.apache.el.stream.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,Long> {
    // RoleEntity findByType(Roles title);
    @Query(value = "SELECT * FROM role r where r.title= : title",nativeQuery = true)
    Optional<RoleEntity> findRoleEntityByTitle(String title);
}