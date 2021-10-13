package kr.co.ch02.sub1;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * ��¥: 2021/10/11
 * �̸�: �迹��
 * ����: ������ Ioc �ǽ��ϱ�
 * 
 * Ioc(������ ����)
 * - �ڹ� ��ü�� �����ϰ� ��ü�� ������ �������踦 ������ �����̳ʷ� ó���ϴ� ����
 * - ������ Ioc�� �̿��Ͽ� ��ü���� ���յ��� ��ȭ ȿ��
 * - Ioc�� �����ϴ� ����� DI (Dpendency Injection)
 * - DI��� �� ������̼� ����� ���� ���� ��� 
 * */

public class IocTest {
	
	
	public static void main(String[] args) {
		
		//DI (Ioc �������)�� Ȱ������ ���� ��ü ����
		Tv tv1 = new LgTv();
		Tv tv2 = new SamsungTv(); 
		
		tv1.powerOn();
		tv1.chUp();
		tv1.powerOff();
		
		tv2.powerOn();
		tv2.chUp();
		tv2.powerOff();
		
		// �����������̳��� ��ü�� ������ �����ϴ� ���
		ApplicationContext ctx = new GenericXmlApplicationContext("root-context.xml");
		
		Tv lgTv = (Tv) ctx.getBean("lgTv");
		Tv samsungTv = (Tv) ctx.getBean("samsungTv");
		
		lgTv.powerOn();
		lgTv.chDown();
		lgTv.soundDown();
		lgTv.powerOff();
		
		samsungTv.powerOn();
		samsungTv.chUp();
		samsungTv.soundUp();
		samsungTv.powerOff();
		
	}
}
