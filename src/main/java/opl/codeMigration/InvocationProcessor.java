package opl.codeMigration;

import java.util.Collections;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.reference.CtTypeReference;

public class InvocationProcessor extends AbstractProcessor<CtInvocation<?>> {

    public void process(CtInvocation<?> ctInvoc) {

        getEnvironment().setAutoImports(true);
        
    	if(ctInvoc.getExecutable().toString().equals("framework.Framework#foo()")){
	    	System.out.println("********** INVOC PROCESSOR ************");

    		System.out.println("rename foo ---> bar");
    		// on renome la méthode
    		ctInvoc.getExecutable().setSimpleName("bar");
    	}
    	if(ctInvoc.getExecutable().toString().equals("framework.Framework#error()")){
	    	System.out.println("********** INVOC PROCESSOR ************");

    		// on définit l'argument que va prendre la fonction
    		CtExpression expr = getFactory().Code().createCodeSnippetExpression("\"default description of error\"");
    		System.out.println(" -> adding the argument to new_error.");
    		// on l'ajoute comme etant le seul argument 
    		ctInvoc.setArguments(Collections.<CtExpression<?>>singletonList(expr));  
    		System.out.println("rename error ---> new_error");
    		// on renome la methode
      		ctInvoc.getExecutable().setSimpleName("new_error");
    	}    	
    	
    	if(ctInvoc.getExecutable().toString().equals("framework.Framework#methodeSansThrows()")){
	    	System.out.println("********** INVOC PROCESSOR ************");

    		System.out.println("rename methodeSansThrows ---> methodeAvecThrows");
    		// on renome la méthode
    		ctInvoc.getExecutable().setSimpleName("methodeAvecThrows");
    	}
    	changeMethodeByAddParam(ctInvoc);
    	
    }
    
    public void changeMethodeByAddParam(CtInvocation<?> invoc){    	
    	if(invoc.getExecutable().getSimpleName().equals("methodeNoParam")){
	    	System.out.println("********** INVOC PROCESSOR ************");

    		System.out.println("Changement de methodeNoParam() ==> methodeWithParam()");
    		invoc.getExecutable().setSimpleName("methodeWithParam");
    		//Recuperation de la variable globale pour la mettre en parametre
    		
    		CtExpression exp = getFactory().Code().createCodeSnippetExpression("sts");
    		invoc.setArguments(Collections.<CtExpression<?>>singletonList(exp));
    		
		}
	}
}
