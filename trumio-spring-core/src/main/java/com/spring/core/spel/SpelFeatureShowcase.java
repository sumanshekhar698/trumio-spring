package com.spring.core.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SpelFeatureShowcase {
	
	@Value("31")
	private int w;
	
	
	@Value("#{30+39}")//SpEL
	private int x;
	
	@Value("#{ T(java.lang.Math).sqrt(169) }")
	//SpEL used for static method call
	private double y;
	
	@Value("#{ T(java.lang.Math).E }")
	//SpEL used for static variables access
	private double e;
	
	@Value("#{new java.lang.String('SpEL')}")
	//SpEL used for Object creation
	private String topic;
	
	
	@Value("#{10<=11 ? true:false}")
	//SpEL used for handling boolean
	private boolean isActive;
	
	public boolean isActive() {
		return isActive;
	}

	@Override
	public String toString() {
		return "Demo [w=" + w + ", x=" + x + ", y=" + y + ", e=" + e + ", topic=" + topic + ", isActive=" + isActive
				+ "]";
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	
	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}


	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getE() {
		return e;
	}

	public void setE(double e) {
		this.e = e;
	}

	

}
