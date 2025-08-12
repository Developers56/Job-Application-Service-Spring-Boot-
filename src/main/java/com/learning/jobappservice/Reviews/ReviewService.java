package com.learning.jobappservice.Reviews;

import org.springframework.stereotype.Service;

import java.util.List;

public interface ReviewService {

    boolean postReview(Long id,Review review);

    List<Review> getAllreviews(Long companyId);
}
