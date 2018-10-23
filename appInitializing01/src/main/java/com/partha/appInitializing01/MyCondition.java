package com.partha.appInitializing01;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MyCondition implements Condition {
	
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata arg1) {
		if(context.getEnvironment().getProperty("key1")!=null)
			return true;
		else
			return false;
	}

}
