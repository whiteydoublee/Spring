package sub1;

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
		Tv ltv = new LgTv();
		Tv stv = new SamsungTv();
		
		ltv.powerOn();
		ltv.chUp();
		ltv.powerOff();
		
		stv.powerOn();
		stv.chUp();
		stv.powerOff();
		
		//DI�� Ȱ���� ��ü ����
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
