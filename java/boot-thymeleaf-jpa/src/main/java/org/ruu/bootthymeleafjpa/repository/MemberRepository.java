package org.ruu.bootthymeleafjpa.repository;

import java.util.Optional;
import org.ruu.bootthymeleafjpa.domain.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<Member, Long> {
    @EntityGraph(attributePaths = "roleSet")
    @Query("select m from Member m where m.id = :id and m.social = false ")
    Optional<Member> getWithRoles(String id);
}
