package com.example.concertlog.controller;

import com.example.concertlog.entity.Concert;
import com.example.concertlog.entity.Review;
import com.example.concertlog.service.ConcertService;
import com.example.concertlog.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;
    private final ConcertService concertService;

    public ReviewController(ReviewService reviewService, ConcertService concertService) {
        this.reviewService = reviewService;
        this.concertService = concertService;
    }

    @GetMapping("/add/{concertId}")
    public String addForm(@PathVariable Long concertId, Model model) {
        model.addAttribute("review", new Review());
        model.addAttribute("concert", concertService.getById(concertId));
        return "reviews/add";
    }

    @PostMapping("/add/{concertId}")
    public String add(@PathVariable Long concertId,
                      @Valid @ModelAttribute Review review,
                      BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("concert", concertService.getById(concertId));
            return "reviews/add";
        }
        Concert concert = concertService.getById(concertId);
        reviewService.save(review, concert);
        return "redirect:/concerts/" + concertId;
    }

    @PostMapping("/delete/{id}/{concertId}")
    public String delete(@PathVariable Long id, @PathVariable Long concertId) {
        reviewService.delete(id);
        return "redirect:/concerts/" + concertId;
    }
}