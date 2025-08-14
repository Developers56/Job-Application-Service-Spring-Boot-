package com.learning.jobappservice.Reviews;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> postReview(@PathVariable Long companyId, @RequestBody Review review){
        boolean posted = reviewService.postReview(companyId,review);
        if (posted){
            return new ResponseEntity<>("Review Posted Successfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Company Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewService.getAllreviews(companyId),HttpStatus.OK);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long companyId, @PathVariable Long reviewId){
        return new ResponseEntity<>(reviewService.getReviewById(companyId,reviewId),HttpStatus.OK);
    }

    //enable user to update a particular review
    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId,@PathVariable Long reviewId,@RequestBody Review review){
        boolean updated = reviewService.updateReview(companyId,reviewId,review);
        if (updated)
            return new ResponseEntity<>("Review Updated Successfully",HttpStatus.OK);
        else return new ResponseEntity<>("Review Not Updated",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId){
        boolean deleted = reviewService.deleteReview(companyId,reviewId);
        if (deleted)
            return new ResponseEntity<>("Review Deleted Successfully",HttpStatus.OK);
        else return new ResponseEntity<>("Review Not Deleted",HttpStatus.NOT_FOUND);
    }
}

