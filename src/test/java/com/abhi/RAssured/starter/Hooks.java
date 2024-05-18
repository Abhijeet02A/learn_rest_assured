package com.abhi.RAssured.starter;

import com.abhi.RAssured.objectController.DriverCoordinator;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public class Hooks {
	private DriverCoordinator coordinator;
	
	public Hooks(DriverCoordinator singleTonhandler) {
		this.coordinator = singleTonhandler;
	}
	
	//It will run before all scenarios are run
	//
	@BeforeAll()
	public static void before_all() {
		System.out.println("Here I am starting execution of your execution ");
	}
	
	//It will run after all scenarios are run
	@AfterAll()
	private static void after_all() {
		System.out.println("All Execution is completed");
	}
}
