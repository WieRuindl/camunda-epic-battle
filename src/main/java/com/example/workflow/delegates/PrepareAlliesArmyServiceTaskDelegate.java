package com.example.workflow.delegates;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("prepareAlliesArmyServiceTask")
public class PrepareAlliesArmyServiceTaskDelegate implements JavaDelegate {
	@Override
	public void execute(DelegateExecution delegateExecution) throws Exception {

		var inputVariable = delegateExecution.getVariable("allies");
		if (inputVariable == null) {
			throw new BpmnError("count_of_allies_error");
		}

		var allies = Integer.parseInt(inputVariable.toString());
		if ( allies < 10 || allies > 100 ) {
			throw new BpmnError("count_of_allies_error");
		}

		// set variables to Camunda context
		delegateExecution.setVariable("allies", allies);
	}
}
