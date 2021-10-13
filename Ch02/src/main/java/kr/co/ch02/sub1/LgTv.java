package kr.co.ch02.sub1;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

@Component
public class LgTv implements Tv{
	
	@Inject
	private Speaker speaker;
	
	//본래는 생성자가 나와야함
//	public LgTv(Speaker spk) {
//		this.spk = spk;
//	}

	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("LgTv PowerOn...");
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("LgTv PowerOff...");	
	}

	@Override
	public void chUp() {
		// TODO Auto-generated method stub
		System.out.println("LgTv chUp...");
		//주입받은 Speaker 객체 실행
	}

	@Override
	public void chDown() {
		// TODO Auto-generated method stub
		System.out.println("LgTv chDown...");
	}

	@Override
	public void soundUp() {
		// TODO Auto-generated method stub
		speaker.soundUp();
	}

	@Override
	public void soundDown() {
		// TODO Auto-generated method stub
		speaker.soundDown();
	}
	
}
