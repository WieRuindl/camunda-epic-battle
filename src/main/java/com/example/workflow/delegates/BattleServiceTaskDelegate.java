package com.example.workflow.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component("battleServiceTask")
public class BattleServiceTaskDelegate implements JavaDelegate {

	private static int battleRound = 0;

	@Override
	public void execute(DelegateExecution delegateExecution) throws Exception {

		// get variables from Camunda context
		var allies = (int) delegateExecution.getVariable("allies");
		var enemies = (int) delegateExecution.getVariable("enemies");

		System.out.println("Battle round " + (++battleRound));
		if ( new Random().nextBoolean() ) {
			System.out.println("Enemy killed");
			enemies--;
		} else {
			System.out.println("Ally killed");
			allies--;
		}
		System.out.println("allies: " + allies + " enemies: " + enemies);
		System.out.println();

		delegateExecution.setVariable("allies", allies);
		delegateExecution.setVariable("enemies", enemies);
	}
}
