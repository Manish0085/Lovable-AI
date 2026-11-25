package com.lovable.lovable_ai.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.stereotype.Indexed;

import java.time.Instant;
import java.util.UUID;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
@Table(
        name = "projects",
        indexes = {
                @Index(name = "idx_projects_updated_at_desc", columnList = "updated_at DESC, deleted_at"),
                @Index(name = "idx_project_deleted_at", columnList = "deleted_at")
        }
)
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @Column(nullable = false)
    String name;


//    @ManyToOne
//    @JoinColumn(name = "owner_id", nullable = false)
//    User owner;
    Boolean isPublic = false;

    @CreationTimestamp
    Instant createAt;

    @UpdateTimestamp
    Instant updatedAt;

    Instant deletedAt;  // Soft Delete
}
