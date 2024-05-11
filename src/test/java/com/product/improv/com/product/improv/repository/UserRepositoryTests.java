package com.product.improv.com.product.improv.repository;

import com.product.improv.com.product.improv.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;


import java.time.LocalDateTime;
import java.util.List;

@DataMongoTest
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void UserRepository_Save_ReturnSavedUser() {
        LocalDateTime mockDateTime = LocalDateTime.of(2024, 5, 11, 10, 30);
        User user = new User("1", "knirantar", "knirantar@gmail.com", "9b37c5e0516c97136d12f7fe31e9c8681e80f482b572e9ec1f0f28d5d19428d5",
                mockDateTime, mockDateTime, true, true);

        User savedUser = userRepository.save(user);

        Assertions.assertThat(savedUser).isNotNull();
    }

    @Test
    public void UserRepository_GetAll_ResturnMoreThanOneUser() {
        LocalDateTime mockDateTime = LocalDateTime.of(2024, 5, 11, 10, 30);

        User user1 = new User("1", "knirantar", "knirantar@gmail.com", "9b37c5e0516c97136d12f7fe31e9c8681e80f482b572e9ec1f0f28d5d19428d5",
                mockDateTime, mockDateTime, true, true);
        User user2 = new User("2", "sham", "sham@gmail.com", "997136d12f7fe31e9c8",
                mockDateTime, mockDateTime, false, false);

        userRepository.save(user1);
        userRepository.save(user2);
        List<User> users = userRepository.findAll();
        Assertions.assertThat(users).isNotNull();
        Assertions.assertThat(users.size()).isEqualTo(2);
    }

    @Test
    public void UserRepository_FindById_ReturnUser() {
        LocalDateTime mockDateTime = LocalDateTime.of(2024, 5, 11, 10, 30);
        User user = new User("1", "knirantar", "knirantar@gmail.com", "9b37c5e0516c97136d12f7fe31e9c8681e80f482b572e9ec1f0f28d5d19428d5",
                mockDateTime, mockDateTime, true, true);

        User returnedUser = userRepository.findById(user.getId()).get();

        Assertions.assertThat(returnedUser).isNotNull();
    }


}
