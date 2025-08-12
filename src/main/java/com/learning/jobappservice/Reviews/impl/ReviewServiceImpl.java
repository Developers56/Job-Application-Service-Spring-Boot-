package com.learning.jobappservice.Reviews.impl;

import com.learning.jobappservice.Company.Company;
import com.learning.jobappservice.Company.CompanyRepository;
import com.learning.jobappservice.Company.CompanyService;
import com.learning.jobappservice.Reviews.Review;
import com.learning.jobappservice.Reviews.ReviewRepository;
import com.learning.jobappservice.Reviews.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {


    ReviewRepository reviewRepository;
    CompanyService companyService;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository,CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService=companyService;
    }

    @Override
    public boolean postReview(Long companyId, Review review) {

        Company company = companyService.getCompanyById(companyId);
        if (company != null) {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Review> getAllreviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompany_CompanyId(companyId);
        return reviews;
    }
}
