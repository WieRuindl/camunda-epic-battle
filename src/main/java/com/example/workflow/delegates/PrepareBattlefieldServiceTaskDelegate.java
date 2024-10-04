package com.example.workflow.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;

@Component("prepareBattlefieldServiceTask")
public class PrepareBattlefieldServiceTaskDelegate implements JavaDelegate {

	@Value("${default_battle_cells_count}")
	private int defaultBattleCellsCount;

	@Override
	public void execute(DelegateExecution delegateExecution) throws Exception {
		// get input process variable from Camunda context
		var inputVariable = delegateExecution.getVariable("battle_cells_count");
		var battleCellsCount = (inputVariable == null) ? defaultBattleCellsCount : (int) inputVariable;
		System.out.println("battleCellsCount: " + battleCellsCount);
		var battlefield = new ArrayList<>(Collections.nCopies(battleCellsCount, true));

		delegateExecution.setVariable("battlefield", battlefield);
	}
}
