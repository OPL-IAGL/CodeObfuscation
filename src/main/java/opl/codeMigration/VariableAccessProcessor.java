package opl.codeMigration;
import java.util.Collection;
import java.util.Iterator;

import spoon.processing.AbstractProcessor;
import spoon.reflect.reference.CtFieldReference;
import spoon.support.reflect.code.CtVariableAccessImpl;

public class VariableAccessProcessor extends AbstractProcessor<CtVariableAccessImpl<?>> {
    
    public void process(CtVariableAccessImpl<?> ctVar){
    	
        if(ctVar.getSignature().contains("Framework#MAX_SIZE")){
        	System.out.println("********** VAR_ACCESS PROCESSOR ************");

        	ctVar.getVariable().setSimpleName("MAX_UPLOAD_SIZE");
        	System.out.println("rename MAX_SIZE ---> MAX_UPLOAD_SIZE");
        }
    }
    
}