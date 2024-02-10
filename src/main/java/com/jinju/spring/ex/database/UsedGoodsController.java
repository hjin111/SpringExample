package com.jinju.spring.ex.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jinju.spring.ex.database.domain.UsedGoods;
import com.jinju.spring.ex.database.service.UsedGoodsService;

// Controller는 request, response 와 관련된 처리를 담당합니다. ( 이거 외에 기능은 이 클래스에서 수행 하지 않음 )
// request, response 처리 담당 => 딱 이 2개와 관련된 내용만 처리한다
@Controller
public class UsedGoodsController {
	
	@Autowired
	private UsedGoodsService usedGoodsService;
	
	// 메소드를 하나 만들어서 url 매핑을 하고 기능을 만들어 가야 된다. url 매핑도 request 요청을 연결하기 위한 과정이기 때문에 여기서 진행함
	@RequestMapping("/db/usedgoods/list")
	@ResponseBody
	public List<UsedGoods> usedGoodsList() {
		
		// /db/usedgoods/list 이 주소로 요청이 들어왔을 떄 중고물품 게시글 리스트 response에 담기 ( response에 담기 controller의 역할이다 )
		// 중고물품 게시글 리스트를 어디서 가져올까?? => 데이터베이스에서 가져 와야 한다. 근데 Controller의 역할은 그게 아니다.
		// 데이터베이스를 가져와야 하는 역할을 수행 하는 놈한테 요청을 해야 한다.
		
		// 중고물품 게시글 리스트 얻어오기 ( Controller는 데이터베이스를 처리 하는 곳에 직접적으로 요청을 안한다. Controller는 데이터를 처리하는 로직 부분에 해당하는 부분에만 요청한다 )
		List<UsedGoods> usedGoodsList = usedGoodsService.getUsedGoodsList();
		
		// 중고물품 게시글 리스트 response에 담기
		return usedGoodsList;
		
	}
}
