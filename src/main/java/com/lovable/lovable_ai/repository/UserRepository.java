package com.lovable.lovable_ai.repository;

import com.lovable.lovable_ai.entity.Project;
import com.lovable.lovable_ai.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<User, UUID>
{
    Optional<User> findByUsername(String email);
}
