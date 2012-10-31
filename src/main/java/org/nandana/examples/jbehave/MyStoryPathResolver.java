package org.nandana.examples.jbehave;

import org.jbehave.core.Embeddable;
import org.jbehave.core.io.StoryPathResolver;

public class MyStoryPathResolver implements StoryPathResolver {

	@Override
	public String resolve(Class<? extends Embeddable> embeddableClass) {

		if (embeddableClass.getName().equals(
				"org.nandana.examples.jbehave.ListSortStory")) {
			return "stories/integer_list.story";
		} else {
			throw new IllegalArgumentException(
					"Cannot resolve path - Uknown embeddable class - "
							+ embeddableClass.getName());
		}
	}

}
