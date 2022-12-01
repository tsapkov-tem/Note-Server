import com.example.note.Entity.Users.Users;
import com.example.note.Repository.UsersRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
@EnableAutoConfiguration
@Import(UsersRepository.class)
public class UserRepositoryTest {

    @Autowired
    private UsersRepository usersRepository;


    @Test
    public void testSave(){
        Users user = new Users();
        user.setIdUser(1);
        user.setUsername("name");
        user.setPassword("pass");
        user.setRole("ADMIN");
        Users newUser = usersRepository.save(new Users());
        Assertions.assertThat(newUser).isNotNull();
        Assertions.assertThat(newUser.getIdUser()).isGreaterThan(0);
    }

    @Test
    public void testFindByUsername(){
        Users user = new Users();
        user.setIdUser(1);
        user.setUsername("name");
        user.setPassword("pass");
        user.setRole("ADMIN");
        usersRepository.save(new Users());
        Users nameUser = usersRepository.findByUsername("name").orElse(null);
        Assertions.assertThat(nameUser).isNotNull();
    }

    public void testFindById(){
        Users user = new Users();
        user.setIdUser(1);
        user.setUsername("name");
        user.setPassword("pass");
        user.setRole("ADMIN");
        usersRepository.save(new Users());
        Users idUser = usersRepository.findById(1).orElse(null);
        Assertions.assertThat(idUser).isNotNull();
    }

}
