package com.jking31cs.jerseyexample.objects;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for User domain object.
 */
public class UserTest {

    private ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new GuavaModule());
    }

    @Test
    public void testJsonSerializeDeserialize() throws Exception {
        User original = new User();

        original.setId(1234L);
        original.setName("John Doe");
        original.setEmail("jdoe3@gmail.biz");

        String json = objectMapper.writeValueAsString(original);

        User deserialized = objectMapper.readValue(json, User.class);

        assertEquals(
                "Object should equal itself after serialization and deserialization.",
                original,
                deserialized
        );
    }

}