package kr.co.ch02.sub1;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

@Component
public class LgTv implements Tv{
	
	@Inject
	private Speaker speaker;
	
	//������ �����ڰ� ���;���
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
		//���Թ��� Speaker ��ü ����
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
