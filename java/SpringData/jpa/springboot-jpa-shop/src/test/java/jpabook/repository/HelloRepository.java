package jpabook.repository;


import jpabook.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@RepositoryTest
public class HelloRepository {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private TestEntityManager entityManager;

    Long savedId;
    String name;

    @BeforeEach
    public void setUp(){
        Member member = new Member();
        member.setUsername("memberA");

        name = member.getUsername();
        savedId = memberRepository.save(member);

        entityManager.flush();
        entityManager.clear();
    }

    @Test
    public void testMember() {

        Member findMember = memberRepository.findById(savedId);

        Assertions.assertThat(findMember.getId()).isEqualTo(savedId);
        Assertions.assertThat(findMember.getUsername()).isEqualTo(name);
    }
}
