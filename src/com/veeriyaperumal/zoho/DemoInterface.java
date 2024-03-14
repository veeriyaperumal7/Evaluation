package com.veeriyaperumal.zoho;

public interface DemoInterface {

	default void method2() {
		System.out.println();
	}
	
	private void method() {
		System.out.println();
	}
	
}
