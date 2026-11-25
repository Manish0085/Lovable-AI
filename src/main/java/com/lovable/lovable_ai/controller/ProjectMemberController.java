package com.lovable.lovable_ai.controller;

import com.lovable.lovable_ai.dto.member.InviteMemberRequest;
import com.lovable.lovable_ai.dto.member.MemberResponse;
import com.lovable.lovable_ai.dto.member.UpdateMemberRoleRequest;
import com.lovable.lovable_ai.service.ProjectMemberService;
import jakarta.validation.Valid;
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
        return ResponseEntity
                .ok(projectMemberService
                        .getProjectMembers(projectId)
                );
    }
    @PostMapping
    public ResponseEntity<MemberResponse> inviteMember(@PathVariable UUID projectId,
                                                       @RequestBody @Valid InviteMemberRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(projectMemberService.inviteMember(projectId, request));
    }

    @PatchMapping("/{memberId}")
    public ResponseEntity<MemberResponse> updateMemberRole(@PathVariable UUID projectId,
                                                            @PathVariable UUID memberId,
                                                            @RequestBody @Valid UpdateMemberRoleRequest request) {

        return ResponseEntity
                .ok(projectMemberService.updateMemberRole(projectId, memberId, request));
    }

    @PatchMapping("/{memberId}")
    public ResponseEntity<Void> deleteMember(@PathVariable UUID projectId,
                                             @PathVariable UUID memberId) {
        projectMemberService.removeProjectMember(projectId);
        return ResponseEntity
                .noContent()
                .build();
    }
}
