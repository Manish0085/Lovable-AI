package com.lovable.lovable_ai.entity;


import jakarta.persistence.*;
import jdk.jfr.Experimental;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    String email;

    String passwordHash;

    String name;
    String avatarUrl;

    @CreationTimestamp
    Instant createAt;

    @UpdateTimestamp
    Instant updatedAt;
    Instant deletedAt;  // Soft Delete
}
