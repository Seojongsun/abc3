package project.steam.abc.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
	
	
	public ReviewDTO reviewSelect(int rvno) {
		return reviewDAO.select(rvno);
	}
	
	public void reviewInsert(ReviewDTO reviewDTO) {
		
			reviewDAO.insert(reviewDTO);
	}
	
	public void reviewUpdate (ReviewDTO reviewDTO) {
		reviewDAO.update(reviewDTO);
	}
	
	public void reviewDelete(int rvno) {
		reviewDAO.delete(rvno);
	}
	
	
	
	
	

}
