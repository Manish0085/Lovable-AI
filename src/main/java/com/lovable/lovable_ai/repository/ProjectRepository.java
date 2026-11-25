package com.lovable.lovable_ai.repository;

import com.lovable.lovable_ai.entity.Project;
import com.lovable.lovable_ai.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProjectRepository extends JpaRepository<Project, UUID>
{

    @Query("""
            SELECT p FROM Project p
            WHERE p.deleteAt IS NULL
            AND p.owner.id = :userId
            ORDER BY p.updatedAt DESC
            """)
    List<Project> findAllAccessibleByUser(@Param("userId") UUID userId);

    @Query("""
            SELECT p FROM Project p
            LEFT JOIN FETCH p.owner
            WHERE p.id = :projectId
                AND p.deletedAt IS NULL
                AND p.owner.id = :userId
            """)
    Optional<Project> findAccessibleProjectById(@Param("projectId") UUID projectId,
                                                @Param("userId") UUID uuid);
}
