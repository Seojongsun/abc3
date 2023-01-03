package project.steam.abc.review.dao;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Repository;

import project.steam.abc.review.dto.ReviewDTO;

@Repository


@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ReviewDAO {
	
	@Autowired
		SqlSessionTemplate sqlSessionTemplate;
	
	public List<ReviewDTO> selectAll(){
		return sqlSessionTemplate.selectList("selectAll");
		
		
		
	}
	
	
	
	
	

}
