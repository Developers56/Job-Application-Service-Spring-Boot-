package com.learning.jobappservice.job;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<job,Long> {
}
