package com.app.server;

import com.app.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

    Car findByUserName(String userName);
    Car findByUserNameOrEmail(String username, String email);

}
