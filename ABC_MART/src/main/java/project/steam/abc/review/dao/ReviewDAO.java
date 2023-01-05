package project.steam.abc.review.dao;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import project.steam.abc.review.dto.ReviewDTO;

@Repository


@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ReviewDAO {
	
	@Autowired
		SqlSessionTemplate sqlSessionTemplate;
	
	public List<ReviewDTO> selectAll(){
		return sqlSessionTemplate.selectList("selectAll");
	}
	
	public ReviewDTO select(int rvno) {
		return sqlSessionTemplate.selectOne("select", rvno);
	}
	
	@Transactional
	public void insert(ReviewDTO reviewDTO) {
		sqlSessionTemplate.insert("insert", reviewDTO);
		System.out.println("인서트 ㅏㅡㅡㅡㅡㅡㅡㅡㅡ" + sqlSessionTemplate);
	}
	
	
	

}
