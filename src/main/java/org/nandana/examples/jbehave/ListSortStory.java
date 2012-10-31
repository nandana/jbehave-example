package org.nandana.examples.jbehave;

import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.core.reporters.Format.HTML;

import java.util.List;
import java.util.Properties;

import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.failures.PassingUponPendingStep;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.FilePrintStreamFactory.ResolveToPackagedName;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;


public class ListSortStory extends JUnitStory {

	private final CrossReference xref = new CrossReference();

	public ListSortStory() {

	}

	@Override
	public Configuration configuration() {
		Class<? extends Embeddable> embeddableClass = this.getClass();
		
	    Properties viewResources = new Properties();
	        viewResources.put("decorateNonHtml", "true");
		
		return new MostUsefulConfiguration()
			.usePendingStepStrategy(new PassingUponPendingStep())
			.useStoryPathResolver(new MyStoryPathResolver())
			.useStoryReporterBuilder(
                new StoryReporterBuilder()
                .withCodeLocation(CodeLocations.codeLocationFromClass(embeddableClass))
                .withDefaultFormats().withPathResolver(new ResolveToPackagedName())
                .withViewResources(viewResources).withFormats(CONSOLE, HTML)
                .withFailureTrace(true).withFailureTraceCompression(true).withCrossReference(xref));

	}

	@Override
	public List<CandidateSteps> candidateSteps() {
		return new InstanceStepsFactory(configuration(), new ListSortSteps())
				.createCandidateSteps();
	}

}
