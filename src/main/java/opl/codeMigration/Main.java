package opl.codeMigration;

import java.util.LinkedList;
import java.util.List;

import spoon.Launcher;

public class Main {

	public static void main(String[] args) {
		final Launcher launcher = new Launcher();
		final List<String> arguments = new LinkedList<String>();
		final String inputFolder = "../CodeMigrationProjectTest/src";
		final String outputFolder = "../CodeMigrationProjectTestResult/src";
		/*if(args.length != 2){
			System.err.println("Veuillez saisir 2 parametres : inputFolder/src outputFolder/src ");
			System.exit(-1);
		}
		
		String inputFolder = args[0];
		String outputFolder = args[1];*/
		
		arguments.add("-g");
		arguments.add("-i");
		arguments.add(inputFolder);
		arguments.add("-o");
		arguments.add(outputFolder);
		//arguments.add("--source-classpath");
		//arguments.add("libs/framework.jar:libs/junit-4.10.jar");
	
		launcher.addProcessor(new VariableAccessProcessor());
		launcher.addProcessor(new InvocationProcessor());
		launcher.addProcessor(new AnnotationProcessor());
		launcher.addProcessor(new MethodProcessor());
		launcher.addProcessor(new ChangeLocalDeclarationProcessor());
		
		System.out.println("Input folder : " + inputFolder + " | Output folder : " + outputFolder);
		System.out.println("Processing...");
		launcher.run(arguments.toArray(new String[arguments.size()]));
		System.out.println("Finished !");
    }

}