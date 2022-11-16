package springJpa.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springJpa.domain.User;
import springJpa.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @PersistenceContext
    private EntityManager em;

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User save(User user) {
        LocalDateTime date = LocalDateTime.now();

        user.setCreatedAt(date);
        User saveUser = userRepository.save(user);
        em.persist(saveUser);


        return saveUser;
    }

    @Transactional
    public User findById(Long userId) {
        User findUser = userRepository.findById(userId).get();

        return findUser;
    }

//    @Transactional
//    public List<User> findAll() {
//        List<User> userList = userRepository.findAll();
//
//        return userList;
//    }
}
