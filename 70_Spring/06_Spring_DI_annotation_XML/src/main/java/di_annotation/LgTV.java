package di_annotation;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
class LgTV implements TV {
	@Resource(name="speaker")
	private Speaker speaker;
	
	public LgTV() {
		System.out.println(">> LgTV() 객체 생성");
	}

	@Override
	public void powerOn() {
		System.out.println("LgTV - 전원 ON");
		
	}
	@Override
	public void powerOff() {
		System.out.println("LgTV - 전원 OFF");
		
	}
	@Override
	public void volumeUp() {
		System.out.println("LgTV - 소리크게~~");
		speaker.volumeUp();
	}
	@Override
	public void volumeDown() {
		System.out.println("LgTV - 소리작게~~");
		speaker.volumeDown();
	}
	
	//-----------------------------------------------
	public void initMethod() {
		System.out.println("LgTV - initMethod() 실행");
	}
	public void destroyMethod() {
		System.out.println("LgTV - destroyMethod() 실행");
	}
}
