package com.thoughtworks.ketsu.repositories;

import com.thoughtworks.ketsu.infrastructure.core.*;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.OrderMapper;
import com.thoughtworks.ketsu.support.DatabaseTestRunner;
import com.thoughtworks.ketsu.support.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.ws.rs.NotFoundException;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(DatabaseTestRunner.class)
public class UserRepositoryTest {
    @Inject
    UserRepository userRepository;

    @Inject
    ProductRepository productRepository;


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

    @Test
    public void should_find_user_by_id(){
        User user = userRepository.createUser(TestHelper.userMap("John"));
        User user_res = userRepository.findUserById(user.getId()).orElseThrow(() -> new NotFoundException("user not found"));
        assertThat(user_res.getId(), is(user.getId()));
    }

    @Test
    public void should_save_and_find_order(){
        User user = userRepository.createUser(TestHelper.userMap("John"));
        Product product = productRepository.createProduct(TestHelper.productMap("apple", "red apple", Float.valueOf(String.valueOf(1.2))));
        Order order = user.createOrderForUser(TestHelper.orderMap("kayla", product.getId()));
        assertThat(order.getName(), is("kayla"));
        assertThat(order.getItems().size(), is(1));
    }

    @Test
    public void should_list_orders_for_user(){
        User user = userRepository.createUser(TestHelper.userMap("John"));
        Product product = productRepository.createProduct(TestHelper.productMap("apple", "red apple", Float.valueOf(String.valueOf(1.2))));
        Order order = user.createOrderForUser(TestHelper.orderMap("kayla", product.getId()));
        List<Order> list = user.listOrdersForUser();
        assertThat(list.size(), is(1));
    }

    @Test
    public void should_find_order_by_id_for_user(){
        User user = userRepository.createUser(TestHelper.userMap("John"));
        Product product = productRepository.createProduct(TestHelper.productMap("apple", "red apple", Float.valueOf(String.valueOf(1.2))));
        Order order = user.createOrderForUser(TestHelper.orderMap("kayla", product.getId()));
        Order order_res = user.findOrderById(order.getId()).orElseThrow(() -> new NotFoundException("order not found"));
        assertThat(order_res.getId(), is(order.getId()));
    }
}
