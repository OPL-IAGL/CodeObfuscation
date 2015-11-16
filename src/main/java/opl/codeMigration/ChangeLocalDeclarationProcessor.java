package opl.codeMigration;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtLocalVariable;

public class ChangeLocalDeclarationProcessor extends AbstractProcessor<CtLocalVariable<?>> {

	public void process(CtLocalVariable<?> element) {
		
		
		if(element.getType().getSimpleName().equals("ClasseDepricated")){
	    	System.out.println("********** LOCAL VAR PROCESSOR ************");

			System.out.println("Changement de la declaration de la variable locale C...\n");
			element.getType().setSimpleName("ClassNew\n");
			System.out.println("ClasseDepricated ==> ClassNew\n");
		
			System.out.println("Changement du constructeur\n");
			System.out.println("New ClasseDepricated ==> New ClassNew\n");
			element.getAssignment().getType().setSimpleName("ClassNew");
		}
				
	}

}
