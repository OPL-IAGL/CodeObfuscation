package opl.codeMigration;

import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.reference.CtTypeReference;

public class MethodProcessor extends AbstractProcessor<CtMethod<?>> {

	public void process(CtMethod<?> element) {
		if(element.getBody().getSignature().contains("Framework#methodeAvecThrows")){
	    	System.out.println("********** METHOD PROCESSOR ************");

            final CtTypeReference<Exception> ref = getFactory().Code().createCtTypeReference(Exception.class);
            System.out.println("Ajout d'un throws");
            element.addThrownType(ref);
        }
	}

}
