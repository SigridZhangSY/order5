package com.thoughtworks.ketsu.repositories;

import com.thoughtworks.ketsu.infrastructure.core.User;
import com.thoughtworks.ketsu.infrastructure.core.UserRepository;
import com.thoughtworks.ketsu.support.DatabaseTestRunner;
import com.thoughtworks.ketsu.support.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.ws.rs.NotFoundException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(DatabaseTestRunner.class)
public class UserRepositoryTest {
    @Inject
    UserRepository userRepository;

    @Test
    public void should_save_and_find_user(){
        User user = userRepository.createUser(TestHelper.userMap("John"));
        assertThat(user.getName(), is("John"));
    }

    @Test
    public void should_find_user_by_name(){
        User user = userRepository.createUser(TestHelper.userMap("John"));
        User user_res = userRepository.findUserByName(user.getName()).orElseThrow(() -> new NotFoundException("user not found"));
        assertThat(user_res.getName(), is(user.getName()));
    }
}
