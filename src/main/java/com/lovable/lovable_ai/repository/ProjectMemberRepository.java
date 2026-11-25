package com.lovable.lovable_ai.repository;

import com.lovable.lovable_ai.dto.member.MemberResponse;
import com.lovable.lovable_ai.entity.ProjectMember;
import com.lovable.lovable_ai.entity.ProjectMemberId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMemberId> {

    List<ProjectMember> findByIdProjectId(UUID projectId);
}
