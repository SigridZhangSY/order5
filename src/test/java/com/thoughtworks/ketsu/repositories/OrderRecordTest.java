package com.thoughtworks.ketsu.repositories;

import com.thoughtworks.ketsu.infrastructure.core.*;
import com.thoughtworks.ketsu.support.DatabaseTestRunner;
import com.thoughtworks.ketsu.support.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.ws.rs.NotFoundException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(DatabaseTestRunner.class)
public class OrderRecordTest {
    @Inject
    UserRepository userRepository;

    @Inject
    ProductRepository productRepository;

    @Test
    public void should_create_payment_for_order(){
        User user = userRepository.createUser(TestHelper.userMap("John"));
        Product product = productRepository.createProduct(TestHelper.productMap("apple", "red apple", Float.valueOf(String.valueOf(1.2))));
        Order order = user.createOrderForUser(TestHelper.orderMap("kayla", product.getId()));
        Payment payment = order.createPayment(TestHelper.paymentMap("CASH", Float.valueOf(100)));
        assertThat(payment.getOrderId(), is(order.getId()));
    }
}
