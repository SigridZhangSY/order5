package com.thoughtworks.ketsu.resources;

import com.thoughtworks.ketsu.support.ApiSupport;
import com.thoughtworks.ketsu.support.ApiTestRunner;
import com.thoughtworks.ketsu.support.TestHelper;
import org.glassfish.grizzly.http.util.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.core.Response;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


@RunWith(ApiTestRunner.class)
public class ProductResourceTest extends ApiSupport{

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void should_return_201_when_create_product(){
        Response post = post("products", TestHelper.productMap("apple", "red apple", Float.valueOf(String.valueOf(1.2))));
        assertThat(post.getStatus(), is(HttpStatus.CREATED_201.getStatusCode()));
    }
}
