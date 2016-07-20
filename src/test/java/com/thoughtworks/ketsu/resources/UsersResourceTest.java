package com.thoughtworks.ketsu.resources;

import com.thoughtworks.ketsu.infrastructure.core.Order;
import com.thoughtworks.ketsu.infrastructure.core.Product;
import com.thoughtworks.ketsu.infrastructure.core.User;
import com.thoughtworks.ketsu.infrastructure.core.UserRepository;
import com.thoughtworks.ketsu.infrastructure.repositories.ProductRepository;
import com.thoughtworks.ketsu.support.ApiSupport;
import com.thoughtworks.ketsu.support.ApiTestRunner;
import com.thoughtworks.ketsu.support.TestHelper;
import org.glassfish.grizzly.http.util.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(ApiTestRunner.class)
public class UsersResourceTest extends ApiSupport {
    @Inject
    UserRepository userRepository;
    @Inject
    ProductRepository productRepository;

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void should_return_201_when_create_user_with_specifid_parameter() {
        Response post = post("users", TestHelper.userMap("John"));
        assertThat(post.getStatus(), is(HttpStatus.CREATED_201.getStatusCode()));
        assertThat(Pattern.matches(".*?/users/[0-9-]*", post.getLocation().toASCIIString()), is(true));
    }

    @Test
    public void should_return_400_when_create_user_with_name_exists() {
        userRepository.createUser(TestHelper.userMap("John"));
        Response post = post("users", TestHelper.userMap("John"));
        assertThat(post.getStatus(), is(HttpStatus.BAD_REQUEST_400.getStatusCode()));
    }

    @Test
    public void should_return_400_when_create_user_with_name_is_null() {

        Response post = post("users", new HashMap<String, Object>());
        assertThat(post.getStatus(), is(HttpStatus.BAD_REQUEST_400.getStatusCode()));
        final List<Map<String, Object>> res = post.readEntity(List.class);
        assertThat(res.size(), is(1));
        assertThat(res.get(0).get("message"), is("name can not be empty"));
    }

    @Test
    public void should_return_detail_when_find_user_by_id() {
        User user = userRepository.createUser(TestHelper.userMap("John"));
        Response get = get("users/" + user.getId());
        assertThat(get.getStatus(), is(HttpStatus.OK_200.getStatusCode()));
        final Map<String, Object> res = get.readEntity(Map.class);
        assertThat(res.get("name"), is("John"));
        assertThat(res.get("id"), is(user.getId()));
        assertThat(res.get("uri"), is("/users/" + user.getId()));
    }

    @Test
    public void should_return_404_when_find_user_with_user_not_exists() {
        User user = userRepository.createUser(TestHelper.userMap("John"));
        Response get = get("users/" + (user.getId() + 1));
        assertThat(get.getStatus(), is(HttpStatus.NOT_FOUND_404.getStatusCode()));
    }

    @Test
    public void should_return_201_when_create_order_for_user_with_specified_parameter() {
        User user = userRepository.createUser(TestHelper.userMap("John"));
        Product product = productRepository.createProduct(TestHelper.productMap("apple", "red apple", Float.valueOf(String.valueOf(1.2))));
        Response post = post("users/" + user.getId() + "/orders", TestHelper.orderMap("John", product.getId()));
        assertThat(post.getStatus(), is(HttpStatus.CREATED_201.getStatusCode()));
        assertThat(post.getLocation().toString(), containsString("/orders/"));
        assertThat(Pattern.matches(".*?/orders/[0-9-]*", post.getLocation().toASCIIString()), is(true));
    }

    @Test
    public void should_return_400_when_create_order_for_user_with_name_and_items_are_null() {
        User user = userRepository.createUser(TestHelper.userMap("John"));
        Product product = productRepository.createProduct(TestHelper.productMap("apple", "red apple", Float.valueOf(String.valueOf(1.2))));
        Map<String, Object> map = TestHelper.orderMap("John", product.getId());
        map.remove("name");
        map.remove("order_items");
        Response post = post("users/" + user.getId() + "/orders", map);

        assertThat(post.getStatus(), is(HttpStatus.BAD_REQUEST_400.getStatusCode()));
        final List<Map<String, Object>> errorInfo = post.readEntity(List.class);
        assertThat(errorInfo.size(), is(2));

    }

    @Test
    public void should_return_400_when_create_order_with_product_not_exists(){
        User user = userRepository.createUser(TestHelper.userMap("John"));
        Product product = productRepository.createProduct(TestHelper.productMap("apple", "red apple", Float.valueOf(String.valueOf(1.2))));
        Response post = post("users/" + user.getId() + "/orders", TestHelper.orderMap("John", product.getId()+1));
        assertThat(post.getStatus(), is(HttpStatus.BAD_REQUEST_400.getStatusCode()));
    }

    @Test
    public void should_return_detail_when_get_all_orders_for_user(){
        User user = userRepository.createUser(TestHelper.userMap("John"));
        Product product = productRepository.createProduct(TestHelper.productMap("apple", "red apple", Float.valueOf(String.valueOf(1.2))));
        Order order = user.createOrderForUser(TestHelper.orderMap("kayla", product.getId()));
        Response get = get("users/" + user.getId() + "/orders");
        assertThat(get.getStatus(), is(HttpStatus.OK_200.getStatusCode()));
        final List<Map<String, Object>> list = get.readEntity(List.class);
        assertThat(list.size(), is(1));
        assertThat(list.get(0).get("uri"), is("/users/" + user.getId() + "/orders/" + order.getId()));
    }

    @Test
    public void should_return_200_when_find_order_by_id_for_user(){
        User user = userRepository.createUser(TestHelper.userMap("John"));
        Product product = productRepository.createProduct(TestHelper.productMap("apple", "red apple", Float.valueOf(String.valueOf(1.2))));
        Order order = user.createOrderForUser(TestHelper.orderMap("kayla", product.getId()));
        Response get = get("users/" + user.getId() + "/orders/" + order.getId());
        assertThat(get.getStatus(), is(HttpStatus.OK_200.getStatusCode()));
    }
}
