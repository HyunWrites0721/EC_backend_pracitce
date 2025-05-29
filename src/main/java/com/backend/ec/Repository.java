package com.backend.ec;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Article, Long> {
}
