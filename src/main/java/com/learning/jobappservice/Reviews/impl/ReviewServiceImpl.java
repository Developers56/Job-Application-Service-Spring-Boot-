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

    @Override
    public Review getReviewById(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompany_CompanyId(companyId);
        return reviews.stream().filter(review -> review.getId() == reviewId).findFirst().orElse(null);
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
        if (companyService.getCompanyById(companyId) != null) {
            updatedReview.setCompany(companyService.getCompanyById(companyId));
            updatedReview.setId(reviewId);
            reviewRepository.save(updatedReview);
            return  true;
        }else  {
            return false;
        }
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        if (companyService.getCompanyById(companyId) != null
        && reviewRepository.existsById(reviewId)) {
            Review review = reviewRepository.findById(reviewId).orElse(null);
            Company company = review.getCompany();
            company.getReviews().remove(review);
            companyService.updateCompany(companyId,company);
            reviewRepository.deleteById(reviewId);
            return true;
        }else  {
            return false;
        }
    }
}
