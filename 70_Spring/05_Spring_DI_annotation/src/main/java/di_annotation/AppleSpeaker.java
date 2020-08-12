package di_annotation;

import org.springframework.stereotype.Component;

@Component("apple")
public class AppleSpeaker implements Speaker {
	public AppleSpeaker() {
		System.out.println("--> AppleSpeaker() 생성");
	}
	public void volumeUp() {
		System.out.println(">> AppleSpeaker - 소리크게");
	}
	public void volumeDown() {
		System.out.println(">> AppleSpeaker - 소리작게");
	}
}
