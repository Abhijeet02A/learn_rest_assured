package com.abhi.RAssured.testrunner;

import java.util.ArrayList;

public class CucumberCMDExecutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		io.cucumber.core.cli.Main.run("--plugin", "pretty", "--monochrome", "--tags", "@GetCheckWithGroovy");
		ArrayList<String> ar = new ArrayList<String>();
		ar.add("features");
		ar.add("src/test/resources/features");
		ar.add("--plugin");
		ar.add("pretty");
		System.out.println(ar);
		for (String string : ar.toArray(new String[]{"Welcome", "High"})) {
			System.out.print(string + " ");
		}
	}

}
