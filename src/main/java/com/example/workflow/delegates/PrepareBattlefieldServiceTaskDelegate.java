package com.example.workflow.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;

@Component("prepareBattlefieldServiceTask")
public class PrepareBattlefieldServiceTaskDelegate implements JavaDelegate {
	@Override
	public void execute(DelegateExecution delegateExecution) throws Exception {
		var battleCellsCount = 10;
		var battlefield = new ArrayList<>(Collections.nCopies(battleCellsCount, true));

		delegateExecution.setVariable("battlefield", battlefield);
	}
}
