package com.jinju.spring.ex.database.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jinju.spring.ex.database.domain.UsedGoods;

// 이 인터페이스가 이제 실제 데이터베이스를 조회해서 그 결과를 돌려주는 기능을 담당한다
// 데이터베이스 관련 기능 담당
// Mybatis framework를 사용할 것이다.
// Mybatis framework는 데이터 베이스 조회, 데이터 베이스 접속하고 쿼리를 수행하고 그 결과를 가져오는 방법, insert하고 이런 여러 복잡한 과정들을 명확하게 기능으로 정의해서 좀 더 쉽게 명료하게 사용할 수 있도록 도와주는 놈이다.
@Mapper
public interface UsedGoodsRepository {
	
	// selectUsedGoodsList 메소드를 호출하면 UsedGoods Entity 클래스의 객체로 한 행을 UsedGoods 객체로 만듭니다 
	// 그걸 여러 개 저장하면 테이블에 전체 데이터가 되는 것이다 그래서 리턴 타입을 List<UsedGoods> 이렇게 잡아준다.
	public List<UsedGoods> selectUsedGoodsList();
	// 그럼 selectUsedGoodsList 이걸 호출 했을 때 실행될 쿼리는 Mybatis에 사용법으로 인터페이스에 Mapper 어노테이션을 붙이고 수행시킬 쿼리를 호출할 메소드를 정의한 다음에 
	// 이 메소드 (selectUsedGoodsList)에 의해서 실행시킬 쿼리는 resources 아래 쪽에 만들어 놓은 mappers 라는 이 폴더 안에 xml 파일을 만들어서 그 내용을 구현해준다.
	// selectUsedGoodsList 호출했을 때 수행 될 코드가 자바 코드가 아니고 xml 코드이다. ( mybatis가 그렇게 기능을 구현해 놓았음 )
	
	// 원래는 인터페이스의 메소드는 클래스에서 implements 해서 구현하는게 일반적이다 근데 mybatis 라는 프레임워크를 활용 해서 간결하게 기능 구현을 할 수가 있고
	// 우리가 selectUsedGoodsList 이 메소드를 통해서 수행 할 기능은 쿼리를 수행시키는 것이다. 수행될 쿼리를 미리 지정해 놓은 규칙에 맞는 xml에다가 mybatis에서 지정한 dtd에 문법에 맞게 xml 코드로 작성을 해서 
	// repository와 연결하기 위한 mapper 태그를 만들고 그 repository 안에 들어 있는 메소드는 mapper 태그 안에 수행할 쿼리에 맞는 태그로 select 수행할거니깐 select 태그로 구성해서 이 태그가 특정 메소드를 수행하기 위한 거니깐
	// 그메소드에 대한 정의가 속성으로 들어가야 한다. 메소드는 메소드 이름 , 파라미터, 리턴 타입 세가지 정보이다. id라는 속성으로 메소드 이름 지정해주고 파라미터는 있을 때 적용하고 리턴 타입은 resultType으로 매칭 시켜주는데 
	// select의 경우 어차피 여러 행이면 리스트로 결과를 만들어 낼것이기 때문에 리스트라는 정보까지는 굳이 언급 할 필요 없고 한 행을 저장하기 위한 타입을 명시해주면 됨.
	
	// selectUsedGoodsList 이걸 만든 이유 자체가 service에서 직접 데이터 베이스 조회를 못하니깐 그 기능을 수행할 메소드가 필요했고 그 기능을 수행하기 위한 담당자가 바로 
	// repository라는 놈이기 때문에 이 담당하는 인터페이스를 만들어서 여기다가 메소드를 만들어 놓은 겁니다. 쓸 대상은 service로 가기
	
}
