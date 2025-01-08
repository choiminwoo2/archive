package org.ruu.bootthymeleafjpa.study;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.ruu.bootthymeleafjpa.annotation.RepositoryTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@RepositoryTest
public class EntityTest {

    @Autowired
    TestEntityManager entityManager;

    @Entity
    @ToString
    @Setter
    public static class A{
        @Id
        @Column(name = "a_id")
        private long id;

        @ManyToOne(fetch = FetchType.LAZY)
        private B b;

    }

    @Entity
    @ToString
    @Getter
    @Setter
    public static class B{

        @Id
        @Column(name = "b_id")
        long id;

        @OneToMany(mappedBy = "b")
        private List<A> list = new ArrayList<>();

        public void addList(A a){
            list.add(a);
            a.setB(this);
        }


    }


    @ToString
    @Builder
    @Getter
    public static class ABDTO{

        private B b;

        public static ABDTO of(B entity){
            return ABDTO.builder()
                .b(entity)
                .build();
        }

    }


    @Test
    void test(){
        B b = new B();
        A a1 = new A();
        A a2 = new A();
        b.setId(1L);
        a1.setId(1L);
        a2.setId(2L);
        b.addList(a1);
        b.addList(a2);
        entityManager.persist(a1);
        entityManager.persist(a2);
        entityManager.persist(b);
        ABDTO abdto = ABDTO.of(entityManager.find(B.class, 1L));
        abdto.getB().getList().forEach(System.out::println);

    }


}
