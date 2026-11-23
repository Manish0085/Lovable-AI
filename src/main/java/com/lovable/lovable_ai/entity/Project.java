package com.lovable.lovable_ai.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.util.UUID;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @Column(nullable = false)
    String name;


    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    User owner;
    Boolean isPublic = false;

    @CreationTimestamp
    Instant createAt;

    @UpdateTimestamp
    Instant updatedAt;

    Instant deletedAt;  // Soft Delete
}
