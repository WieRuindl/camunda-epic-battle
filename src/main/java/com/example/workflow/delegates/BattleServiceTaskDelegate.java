package com.example.workflow.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component("battleServiceTask") // the bean name should be the same as camunda:delegateExpression="${battleServiceTask}"
public class BattleServiceTaskDelegate implements JavaDelegate {
	@Override
	public void execute(DelegateExecution delegateExecution) throws Exception {

		var random = new Random();

		var allies = random.nextInt(100) + 1;
		var enemies = random.nextInt(100) + 1;
		var isVictory = allies > enemies;

		// set variables to Camunda context
		delegateExecution.setVariable("allies", allies);
		delegateExecution.setVariable("enemies", enemies);
		delegateExecution.setVariable("isVictory", isVictory);
	}
}
