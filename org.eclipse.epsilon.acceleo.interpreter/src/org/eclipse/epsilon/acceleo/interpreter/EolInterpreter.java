package org.eclipse.epsilon.acceleo.interpreter;

import java.util.concurrent.Callable;

import org.eclipse.acceleo.ui.interpreter.language.AbstractLanguageInterpreter;
import org.eclipse.acceleo.ui.interpreter.language.EvaluationContext;
import org.eclipse.acceleo.ui.interpreter.language.EvaluationResult;
import org.eclipse.epsilon.eol.EolModule;

public class EolInterpreter extends AbstractLanguageInterpreter {

	@Override
	public Callable<EvaluationResult> getEvaluationTask(EvaluationContext context) {
		return new Callable<EvaluationResult>() {
			@Override
			public EvaluationResult call() throws Exception {
				EolModule module = new EolModule();
				module.parse(context.getExpression());
				
				return new EvaluationResult(module.execute());
			}
		};
	}

}
