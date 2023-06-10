package com.example.demojparelationship;

import com.example.demojparelationship.entity.IdentityCard;
import com.example.demojparelationship.entity.Post;
import com.example.demojparelationship.entity.User;
import com.example.demojparelationship.repository.IdentityCardRepository;
import com.example.demojparelationship.repository.PostRepository;
import com.example.demojparelationship.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@Rollback(value = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DemoJpaRelationshipApplicationTests {
    @Autowired
    private IdentityCardRepository identityCardRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;


    @Test
    void save_user_cascape() {

//        IdentityCard identityCard = new IdentityCard(null, "111");
//        identityCardRepository.save(identityCard);
//
//
//
//        User user = new User(null, "binh trong", "trong@gmail.com", "111", identityCard);
//        userRepository.save(user);

    }

    @Test
    void save_user() {
        User user=User.builder()
                .name("anh trong ok")
                .name("binhtrong@ok.com")
                .password("fdshfd")
                .identityCard(
                        new IdentityCard(null,"234")
                ).build();
        userRepository.save(user);
    }

    @Test
    void findUser() {
        User u=userRepository.findById(2).orElse(null);
        System.out.println(u);
    }

    @Test
    void deleteUser() {
        userRepository.deleteById(2);
    }

    @Test
    void saveUserPost() {
        User user= User.builder()
                .name("binhtrong")
                .email("gfdjgifdg")
                .password("fdshdfs")
                .build();
        userRepository.save(user);

        for (int i = 0; i <3 ; i++) {
            Post post=new Post(null,"post"+(i+1),user);
            postRepository.save(post);
        }
    }

    @Test
    void orphan() {

        User u=userRepository.findById(7).orElse(null);
        System.out.println(u);

        List<Post> postList=u.getPosts();
        postList.remove(1);
    }
}
