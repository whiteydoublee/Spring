package kr.co.kmarket.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.MemberVo;

@Repository
public interface MemberRepo extends JpaRepository<MemberVo, String> {
	//JpaRepostiory <T = table> ID= PK column의 타입 / JPA 연결객체

}
