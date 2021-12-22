package com.bridgelabz.greetingapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.greetingapp.model.Greeting;

@Repository
public interface IGreetingRepository extends JpaRepository<Greeting,Long> {
}