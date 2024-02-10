package com.jinju.spring.ex.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jinju.spring.ex.database.domain.UsedGoods;
import com.jinju.spring.ex.database.repository.UsedGoodsRepository;

// 데이터 베이스를 직접적으로 사용하는 것은 아니면서 데이터를 다루거나 필요한 기능을 자바 코드를 통해 수행 시킬 때 쓰는 놈이다 그걸 일반적으로 로직이라고 표현한다.
// 로직을 처리하는 클래스에는 Service라는 어노테이션을 붙여준다.
// 로직(business) 담당 / Controller는 오직 이 로직을 담당하는 곳에다가 원하는 기능을 수행시켜서 원하는 정보를 얻어옵니다
// Conroller 가 지금 중고물품 게시글 리스트를 얻어오는게 필요하다 그럼 이 기능은 Controller가 할 일이 아니다 그럼 Service라고 하는 놈한테서 해당 기능을 수행시켜서 정보를 얻어와야 한다.
@Service
public class UsedGoodsService {
	
	// 객체 생성을 프레임 워크가 직접 관리 해준다.
	// 해당하는 객체를 저장할 변수를 멤버 변수를 만든다.
	// 이 객체 관리를 스프링한테 맡길 것이다.
	@Autowired // 객체를 주입한다 / 의존성을 주입한다 
	private UsedGoodsRepository usedGoodsRepository; // usedGoodsRepository 이 변수에다가 스프링이 알아서 객체를 주입해준다 언제? 이 객체를 사용할 때 알아서 주입해줌
	
	// 중고물품 게시글 리스트 얻어오는 기능
	public List<UsedGoods> getUsedGoodsList() {
		
		List<UsedGoods> usedGoodsList = usedGoodsRepository.selectUsedGoodsList();
		
		return usedGoodsList;
	}

}
