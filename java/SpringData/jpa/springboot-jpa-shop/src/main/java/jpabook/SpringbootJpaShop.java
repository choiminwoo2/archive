package jpabook;

import jpabook.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class SpringbootJpaShop {

    public static void main(String[] args) {

        SpringApplication.run(SpringbootJpaShop.class, args);
    }
}
