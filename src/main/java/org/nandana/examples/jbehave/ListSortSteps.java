package org.nandana.examples.jbehave;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.nandana.examples.list.IntegerList;
import org.nandana.examples.list.SortOrder;

public class ListSortSteps {
	
    private IntegerList integerList;
	
    @Given("a list of integers $originalList")
    @Alias("a list of integers <originalList>")
    public void aListOfIntegers(@Named("originalList") List<Integer> list) {
    	integerList = new IntegerList(10);
    	for (int item : list) {
        	integerList.add(item);
        }
    }
    
    @When("I sort the list in ascending order")
    public void sortListInAscendingOrder() {
    	integerList.sort(SortOrder.ASCENDING);
    }
    
    @When("I sort the list in descending order")
    public void sortListInDescendingOrder() {
    	integerList.sort(SortOrder.DESCENDING);
    }
    
    @When("I sort the list")
    public void sortList() {
    	integerList.sort();
    }
    
    @When("I set the order is $order")
    @Alias("I set the order is <order>")
    public void setSortOrder(@Named("order") String order) {
    	
    	if ("descending".equals(order)) {
    		integerList.setOrder(SortOrder.DESCENDING);
    	} else if ("ascending".equals(order)) {
    		integerList.setOrder(SortOrder.ASCENDING);
    	} else {
    		throw new IllegalArgumentException("Unknown sorting order - '" + order + "'");
    	}
    	
    }
    
    @Then("the list should look like $list")
    @Alias("I set the order is <sortedList>")
    public void secondElementOfTheList(@Named("sortedList")List<Integer> list) {
    	// Verify that the ordered list is identical to the expected one
        for (int i = 0 ; i < list.size() ; i++) {
        	assertEquals(list.get(i).intValue(),integerList.get(i));
        }
    }
    
}
