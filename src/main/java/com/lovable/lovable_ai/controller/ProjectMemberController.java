package com.lovable.lovable_ai.controller;

import com.lovable.lovable_ai.dto.member.InviteMemberRequest;
import com.lovable.lovable_ai.dto.member.MemberResponse;
import com.lovable.lovable_ai.dto.member.UpdateMemberRoleRequest;
import com.lovable.lovable_ai.service.ProjectMemberService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects/{projectId}/members")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProjectMemberController {

    ProjectMemberService projectMemberService;

    @GetMapping
    public ResponseEntity<List<MemberResponse>> getProjectMembers(@PathVariable UUID projectId) {
        UUID userId = UUID.randomUUID();
        return ResponseEntity
                .ok(projectMemberService
                        .getProjectMembers(projectId, userId)
                );
    }
    @PostMapping
    public ResponseEntity<MemberResponse> inviteMember(@PathVariable UUID projectId,
                                                       @RequestBody InviteMemberRequest request) {
        UUID userId = UUID.randomUUID();
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(projectMemberService.inviteMember(projectId, request,  userId));
    }

    @PatchMapping("/{memberId}")
    public ResponseEntity<MemberResponse> updateMemberRole(@PathVariable UUID projectId,
                                                            @PathVariable UUID memberId,
                                                            @RequestBody UpdateMemberRoleRequest request) {
        UUID userId = UUID.randomUUID();
        return ResponseEntity
                .ok(projectMemberService.updateMemberRole(projectId, request,  userId));
    }

    @PatchMapping("/{memberId}")
    public ResponseEntity<Void> deleteMember(@PathVariable UUID projectId,
                                                           @PathVariable UUID memberId) {
        UUID userId = UUID.randomUUID();
        projectMemberService.deleteProjectMember(projectId, userId);
        return ResponseEntity
                .noContent()
                .build();
    }
}
