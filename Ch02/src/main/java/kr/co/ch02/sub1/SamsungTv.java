package kr.co.ch02.sub1;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

@Component
public class SamsungTv implements Tv{
	
	@Inject
	private Speaker speaker;

	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("SamsungTv PowerOn...");
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("SamsungTv PowerOff...");
	}

	@Override
	public void chUp() {
		// TODO Auto-generated method stub
		System.out.println("SamsungTv chUP...");
	}

	@Override
	public void chDown() {
		// TODO Auto-generated method stub
		System.out.println("SamsungTv chDown...");
	}

	@Override
	public void soundUp() {
		// 주입된 speaker 실행
		speaker.soundUp();
	}

	@Override
	public void soundDown() {
		// TODO Auto-generated method stub
		speaker.soundDown();
	}
	
}
