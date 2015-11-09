package opl.codeObfuscation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.reference.CtFieldReference;

public class ClassProcessor extends AbstractProcessor<CtClass<?>> {
    
	private static int SIZE_FIELD_RENAMED_MIN = 10;
	private static int SIZE_FIELD_RENAMED_MAX = 20;
	private static String ALPHA_NUMERIC = "abcdefghijklmnopqrstuvwxyz0123456789";
	private static ArrayList<String> all_generated_AN = new ArrayList<String>();
	
    public void process(CtClass<?> ctClass) {
        /*
    	// Creates field.
        final CtTypeReference<Date> dateRef = getFactory().Code().createCtTypeReference(Date.class);
        final CtTypeReference<List<Date>> listRef = getFactory().Code().createCtTypeReference(List.class);
        listRef.addActualTypeArgument(dateRef);
        final CtField<List<Date>> listOfDates = getFactory().Core().<List<Date>>createField();
        listOfDates.<CtField>setType(listRef);
        listOfDates.<CtField>addModifier(ModifierKind.PRIVATE);
        listOfDates.setSimpleName("dates");

        // Creates constructor.
        final CtCodeSnippetStatement statementInConstructor = getFactory().Code().createCodeSnippetStatement("this.dates = dates");
        final CtBlock<?> ctBlockOfConstructor = getFactory().Code().createCtBlock(statementInConstructor);
        final CtParameter<List<Date>> parameter = getFactory().Core().<List<Date>>createParameter();
        parameter.<CtParameter>setType(listRef);
        parameter.setSimpleName("dates");
        final CtConstructor constructor = getFactory().Core().createConstructor();
        constructor.setBody(ctBlockOfConstructor);
        constructor.setParameters(Collections.<CtParameter<?>>singletonList(parameter));
        constructor.addModifier(ModifierKind.PUBLIC);
        */
    	
        ctClass = renameField(ctClass);
        ctClass.setDocComment(generateFalseDoc());
        
        /*
        // Apply transformation.
        ctClass.addField(listOfDates);
        ctClass.addConstructor(constructor);
        */
    }
    
    public String generateFalseDoc(){
    	String res = "hahaha";
    	
    	return res;
    }
    
    public CtClass renameField(CtClass<?> ctClass) {
    	Collection<CtFieldReference<?>> c = ctClass.getDeclaredFields();
        Iterator<CtFieldReference<?>> it = c.iterator();
        while(it.hasNext()){
        	String generated = getAlphaNumericRandom();
        	// we check if the generated AN does not exist yet
        	while(all_generated_AN.contains(generated)){
        		generated = getAlphaNumericRandom();
        	}
        	// add the generated AN to all_generated_AN list
        	all_generated_AN.add(generated);
        	
        	CtFieldReference tmp = it.next();
        	System.out.println("replace " + tmp.getSimpleName() + " by " + generated);
        	try{
        		String field_name = tmp.getSimpleName();
        		ctClass.getField(field_name).setSimpleName(generated);
        	}catch(Exception e){
        		
        	}
        }    
        return ctClass;
    }
 
    public String getAlphaNumericRandom(){
	    StringBuilder generated = new StringBuilder();
	    Random rnd = new Random();
	    int size = rnd.nextInt((SIZE_FIELD_RENAMED_MAX + 1) - SIZE_FIELD_RENAMED_MIN) + SIZE_FIELD_RENAMED_MIN;
	    while (generated.length() < size) {
	        int index = (int) (rnd.nextFloat() * ALPHA_NUMERIC.length());
	        generated.append(ALPHA_NUMERIC.charAt(index));
	    }
	    return generated.toString();
	}
    
    
}