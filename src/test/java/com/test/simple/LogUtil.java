package com.test.simple;

import io.qameta.allure.Step;

public class LogUtil {
	
	 private LogUtil() {
	    }

	    @Step("{0}")
	    public static void log(final String message){
	        //intentionally empty
	    }

}
