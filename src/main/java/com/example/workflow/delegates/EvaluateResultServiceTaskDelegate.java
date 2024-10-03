package com.example.workflow.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("evaluateResultServiceTask")
public class EvaluateResultServiceTaskDelegate implements JavaDelegate {
	@Override
	public void execute(DelegateExecution delegateExecution) throws Exception {

		var allies = (int) delegateExecution.getVariable("allies");
		var enemies = (int) delegateExecution.getVariable("enemies");

		var isVictory = allies > enemies;

		// set variables to Camunda context
		delegateExecution.setVariable("isVictory", isVictory);

		// remove variables from Camunda context
		delegateExecution.removeVariable("battlefield");
	}
}
