package com.example.workflow.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("battleServiceTask")
public class BattleServiceTaskDelegate implements JavaDelegate {
	@Override
	public void execute(DelegateExecution delegateExecution) throws Exception {

		// get variables from Camunda context
		var allies = (int) delegateExecution.getVariable("allies");
		var enemies = (int) delegateExecution.getVariable("enemies");

		var isVictory = allies > enemies;

		// set variables to Camunda context
		delegateExecution.setVariable("isVictory", isVictory);
	}
}
