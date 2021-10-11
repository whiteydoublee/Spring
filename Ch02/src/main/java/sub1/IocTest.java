package sub1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * 날짜: 2021/10/11
 * 이름: 김예은
 * 내용: 스프링 Ioc 실습하기
 * 
 * Ioc(제어의 역행)
 * - 자바 객체를 생성하고 객체들 사이의 의존관계를 스프링 컨테이너로 처리하는 개념
 * - 스프링 Ioc를 이용하여 객체간의 결합도를 완화 효과
 * - Ioc를 구현하는 기술이 DI (Dpendency Injection)
 * - DI기법 중 어노테이션 기법을 가장 많이 사용 
 * */

public class IocTest {
	public static void main(String[] args) {
		
		//DI (Ioc 구현기술)를 활용하지 않은 객체 생성
		Tv ltv = new LgTv();
		Tv stv = new SamsungTv();
		
		ltv.powerOn();
		ltv.chUp();
		ltv.powerOff();
		
		stv.powerOn();
		stv.chUp();
		stv.powerOff();
		
		//DI를 활용한 객체 주입
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:root-context.xml");
		
		Tv lgTv = (Tv) ctx.getBean("lgTv");
		Tv samsungTv = (Tv) ctx.getBean("samsungTv");
		
		lgTv.powerOn();
		lgTv.chDown();
		lgTv.powerOff();
		
		samsungTv.powerOn();
		samsungTv.chUp();
		samsungTv.powerOff();
		
	}
}
