package springJpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.transaction.annotation.Transactional;
import springJpa.domain.Post;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootApplication
public class StudyApplication {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	@EventListener(ApplicationReadyEvent.class) // application 준비 https://mr-popo.tistory.com/113
	public void started(){
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				Post post = new Post();
				post.setUserId((long) j);
				post.setAuthor("휴먼" + j);
				post.setTitle("heHe" + j);
				em.persist(post);
			}
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(StudyApplication.class, args);
	}

}
