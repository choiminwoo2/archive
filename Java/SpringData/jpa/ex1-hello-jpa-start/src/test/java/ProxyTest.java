import hellojpa.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.jboss.jandex.Main;

public class ProxyTest {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //code

        Member member1 = new Member();
        member1.setName("member1");
        em.persist(member1);
        em.flush();
        em.clear();

        Member m1 = em.find(Member.class, member1.getId());

        System.out.println("m1 == m2: " + m1.getClass());
        // 이미 영속성 컨텍스트에 올려놔서 원본을 가져옴.
        // 진짜 이유 ?
        // JPA에서는
        // cascade <= 소유자가 하나 일때만 사용해야함. 단일 엔티티에 완전 종속적일 때, 라이프 사이클이 같다면 사용할만함
        Member reference = em.getReference(Member.class, member1.getId());
        System.out.println("reference = " + reference.getClass());

        //항상 true가 되어야함.
        System.out.println("a == a: " + (m1 == reference));
        tx.commit();

        em.close();
        emf.close();
    }
}
