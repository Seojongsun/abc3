package project.steam.abc.review.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;
import project.steam.abc.review.service.ReviewService;


@Controller

@Slf4j

public class ReviewController {
	
	@Autowired
	
	private ReviewService reviewService;
	
	@RequestMapping(value = "ReviewSelect" , method = RequestMethod.GET)
	public String list(Model model) {
		
		model.addAttribute("list", reviewService.reviewSelectAll());
		
		log.info("전체 조회 " + model);
		
		return "./review/review_select_all_view";
	}
	
	
	
	
	

}
