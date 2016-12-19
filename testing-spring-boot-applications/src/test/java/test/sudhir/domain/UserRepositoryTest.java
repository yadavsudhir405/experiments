package test.sudhir.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author sudhir
 *         Date:19/12/16
 *         Time:4:58 PM
 *         Project:testing-spring-boot-applications
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    private  static final VehicleIdentificationNumber VEHICLE_IDENTIFICATION_NUMBER=
            new VehicleIdentificationNumber("12345");

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByUserNameShouldReturnUser(){
        User user=new User("Sudhir",VEHICLE_IDENTIFICATION_NUMBER);
        this.testEntityManager.persistAndFlush(user);
        User receivedUser=this.userRepository.findByUsername("Sudhir");
        Assertions.assertThat(receivedUser.getUsername()).isEqualTo("Sudhir");
        Assertions.assertThat(receivedUser.getVin()).isEqualTo(VEHICLE_IDENTIFICATION_NUMBER);
    }

    @Test
    public void findByUserNamewhenNoUserShouldReturnNull(){
        this.testEntityManager.persistAndFlush(new User("George",new VehicleIdentificationNumber("56896")));
        User user =this.userRepository.findByUsername("Unkonwen");
        Assertions.assertThat(user).isNull();
    }
}
