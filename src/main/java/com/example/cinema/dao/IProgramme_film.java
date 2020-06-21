package com.example.cinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cinema.entities.programme_film;
@Repository
public interface IProgramme_film extends JpaRepository<programme_film,Integer>{

}
