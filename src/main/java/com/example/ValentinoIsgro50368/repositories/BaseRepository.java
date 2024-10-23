package com.example.ValentinoIsgro50368.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository <E, ID extends Serializable> extends JpaRepository<E, ID> {
}
