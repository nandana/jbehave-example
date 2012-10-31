Story: Sorting a list of integers

Narrative:
	In order to easily find the numbers I want
	As a person who have many numerical lists
	I want to sort my lists
 

Scenario:  Sort ascending
!-- Simple scenario
 
Given a list of integers 76, 31, 25, 57, 19, 62, 48
When I sort the list in ascending order
Then the list should look like 19, 25, 31, 48, 57, 62, 76

Scenario:  Sort descending
!-- A scenario with And 
 
Given a list of integers 76, 31, 25, 57, 19, 62, 48
When I set the order is descending
And I sort the list
Then the list should look like 76, 62, 57, 48, 31, 25, 19

Scenario:  Sort lists of different sizes
!-- Parameterized scenario

Given a list of integers <originalList>
When I set the order is <order>
And I sort the list
Then the list should look like <sortedList>

Examples:

|originalList					|order		|sortedList						|
|52,49,32,28,11					|ascending	|11,28,32,49,52					|
|74,91,58,15,44,20,37,199,63,87 |ascending	|15,20,37,44,58,63,74,87,91,199	|
|7,9,5,1,4,2,3,10,6,8   		|ascending	|1,2,3,4,5,6,7,8,9,10			|
|7,9,5,1,4,2,3,10   			|descending |10,9,7,5,4,3,2,1				|
|7,7,7,1,4,10   				|descending |10,7,7,7,4,1					|






