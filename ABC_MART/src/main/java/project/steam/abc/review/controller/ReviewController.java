package project.steam.abc.review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;
import project.steam.abc.review.dto.ReviewDTO;
import project.steam.abc.review.service.ReviewService;


@Controller

@Slf4j

public class ReviewController {
	
	@Autowired
	
	private ReviewService reviewService;
	
//	@RequestMapping(value = "ReviewSelect" , method = RequestMethod.GET)
	@RequestMapping("/ReviewSelect")
	public String list(Model model) {
		model.addAttribute("list", reviewService.reviewSelectAll());
		log.info("전체 조회 " + model);
		return "./review/review_select_all_view";
	}
	
	
//	@RequestMapping (value = "/ReviewSelectDetail", method = RequestMethod.GET)
	@RequestMapping ("/ReviewSelectDetail")
	public String detail(Model model, ReviewDTO reviewDTO) {
		model.addAttribute("reviewDTO", reviewService.reviewSelect(reviewDTO.getRvno()));
		log.info("상세 조회" + model);
		return "./review/review_select_view";
	}
	
	// ======= 인서트 =============
	
	@RequestMapping("/ReviewInsert")
	public String insert() {
		return "./review/review_insert";
	}
	
	@RequestMapping(value = "/ReviewInsert", method = RequestMethod.POST)
	public String insert ( Model model, ReviewDTO reviewDTO) {
		model.addAttribute("list", reviewService.reviewSelectAll());
		reviewService.reviewInsert(reviewDTO);
		log.info("리뷰 작성 값 확인 ===============" + model);
		log.info("리뷰 작성 값 확인 ===============" + reviewService);
		return "./review/review_insert_view";
	}
	
	
	
	

}
