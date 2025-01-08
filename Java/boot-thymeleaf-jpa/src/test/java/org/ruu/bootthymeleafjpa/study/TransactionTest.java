package org.ruu.bootthymeleafjpa.study;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.ruu.bootthymeleafjpa.annotation.RepositoryTest;
import org.ruu.bootthymeleafjpa.repository.JpaTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RepositoryTest
@RequiredArgsConstructor
public class TransactionTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    TestService1 testService1;

    @Autowired
    TestService2 testService2;

    @Test
    public void exceptionTest(){

    }

    @Component
    public static class TestService1 {
        @Autowired
        private JpaTestRepository testRepository;

        public void exception() {
        }
        public void runtimeException(){

        }



    }

    @Component
    public static class TestService2 {
        @Autowired
        JpaTestRepository testRepository;

    }


}
