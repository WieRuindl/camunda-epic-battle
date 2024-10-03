package com.example.workflow.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component("prepareAlliesArmyServiceTask")
public class PrepareAlliesArmyServiceTaskDelegate implements JavaDelegate {
	@Override
	public void execute(DelegateExecution delegateExecution) throws Exception {

		var random = new Random();

		var allies = random.nextInt(100) + 1;

		// set variables to Camunda context
		delegateExecution.setVariable("allies", allies);
	}
}
