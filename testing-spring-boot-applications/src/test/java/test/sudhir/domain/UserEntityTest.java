package test.sudhir.domain;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author sudhir
 *         Date:18/12/16
 *         Time:5:37 PM
 *         Project:testing-spring-boot-applications
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserEntityTest {

    private static final VehicleIdentificationNumber VIN=new VehicleIdentificationNumber("12345");

    @Rule
    public ExpectedException expectedException=ExpectedException.none();

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void createWhenUserNameisnullSholdThrowException() throws Exception{
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Username must not be empty");
        new User(null,VIN);
    }

    @Test
    public void saveShouldPersist(){
        User user= this.testEntityManager.persistFlushFind(new User("Sudhir",VIN));
        Assertions.assertThat(user.getUsername()).isEqualTo("Sudhir");
        Assertions.assertThat(user.getVin()).isEqualTo(VIN);
    }

}
