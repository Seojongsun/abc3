package project.steam.abc.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.steam.abc.review.dao.ReviewDAO;
import project.steam.abc.review.dto.ReviewDTO;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewDAO reviewDAO;
	
	public List<ReviewDTO> reviewSelectAll(){
		return reviewDAO.selectAll();
		
		
	}
	
	
	
	
	

}
