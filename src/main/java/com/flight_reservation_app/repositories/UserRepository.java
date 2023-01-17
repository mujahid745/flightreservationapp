package com.flight_reservation_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight_reservation_app.enities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

}
