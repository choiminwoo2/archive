package org.ruu.bootthymeleafjpa.repository;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.BatchSize;
import org.ruu.bootthymeleafjpa.repository.JpaTestRepository.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTestRepository extends JpaRepository<TestEntity, Long> {

    @Entity
    @ToString
    @Getter
    public static class TestEntity{

        @Id
        @GeneratedValue
        @Column(name = "tset_id")
        private Long id;

        @BatchSize(size = 30)
        @OneToMany(cascade = CascadeType.ALL)
        List<TestManyEntity> manyEntities = new ArrayList<>();
        public void changeTestEntity(TestManyEntity entity){
            manyEntities.add(entity);
            entity.setTestEntity(this);
        }
    }

    @Entity
    public static class TestManyEntity{
        //TODO
        // RUNTIME, TRY, EXCEPTION 분기의 TRANSACTION이
        // 어떻게 동작하는지 테스트를 해보고 싶다. 이건 내일 하자!
        @Id
        @GeneratedValue
        @Column(name = "test_many_id")
        private Long id;

        @Setter
        @ManyToOne(fetch = FetchType.LAZY)
        private TestEntity testEntity;

    }


}
