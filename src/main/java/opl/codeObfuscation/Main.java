package opl.codeObfuscation;

import java.util.LinkedList;
import java.util.List;

import spoon.Launcher;

public class Main {

	public static void main(String[] args) {
		final Launcher launcher = new Launcher();
		final List<String> arguments = new LinkedList<String>();
		final String inputFolder = "../CodeObfuscationProjectTest/src";
		final String outputFolder = "../CodeObfuscationProjectTest/spooned";
		arguments.add("-g");
		arguments.add("-i");
		arguments.add(inputFolder);
		arguments.add("-o");
		arguments.add(outputFolder);
		launcher.addProcessor(new ClassProcessor());
		System.out.println("Input folder : " + inputFolder + " | Output folder : " + outputFolder);
		System.out.println("Processing...");
		launcher.run(arguments.toArray(new String[arguments.size()]));
		System.out.println("Finished !");
    }

}