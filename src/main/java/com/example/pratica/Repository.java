package com.example.pratica;

import org.springframework.data.jpa.repository.JpaRepository;
@org.springframework.stereotype.Repository

public interface Repository extends JpaRepository<Model,Long> {
}
