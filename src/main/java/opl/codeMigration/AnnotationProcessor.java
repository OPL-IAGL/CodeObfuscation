package opl.codeMigration;

import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtAnnotation;
import spoon.reflect.reference.CtTypeReference;

public class AnnotationProcessor extends AbstractProcessor<CtAnnotation<?>> {

	public void process(CtAnnotation<?> ctAnnot) {

    	if(ctAnnot.getSignature().equals("@framework.Annotation")){
        	System.out.println("********** ANNOT PROCESSOR ************");

    		CtTypeReference type = ctAnnot.getType().setSimpleName("NewAnnotation");
    		ctAnnot.setAnnotationType(type);
    		System.out.println("rename @Annotation ---> @NewAnnotation");
    		//ctAnnot.setDocComment("Change From @Annotation to @NewAnnotation");
    	}
	}

}
