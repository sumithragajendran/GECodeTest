# Coding Exercise

# Integrated with Gitlab for running Junit tests. Report can be viewed here,
https://gitlab.com/sumithragajendran/GECodeTest/-/jobs/340411634

Selected Exercises:
Exercise 1

Exercise 5

## General Instructions
1. Fully review the instructions for all exercises before beginning.
2. Select 2 of the 5 exercises to complete.
4. Please commit your solution no more than 48 hours after receiving the exercises.
5. Be sure that you have JDK 1.7+ installed and Apache Ant 1.9+ installed on your system
6. Each exercise has some amount of JUnit tests already. More details on tests are provided in the exercise description.
7. There is an ant script that can be used to build and test the project.

## How to submit work
1. Clone this repo from GitHub
2. Create a branch
3. Commit your solution to your chosen exercises
4. Open a pull request on GitHub

#
## Exercise 1 - User and Group Parsing
#### Package: com.ge.exercise1
For this exercise you will need to retrieve application, user, and group data from structured text. 
The text will contain the data for a single application and may contain many users and groups. 
The users and groups are unique based on their ID and may appear multiple times in the text 
(for example, same user in two different groups). Whitespace and newlines should be ignored.

The format of the text follows the convention  
```
Application(
    id: 0,
    name: MyApp,
    users: [
        User(
            id: 2,
            name: Beth Jones
        ),
        ...
    ],
    groups: [
        Group(
            id: 1,
            name: SimpleGroup,
            users: [
                User(
                    id: 2,
                    name: Beth Jones
                ),
                ...
            ]
        ),
        ...
    ]
)
```

### What is provided
1. A java interface for the parser and abstract classes for the Application, User, and Group
2. A JUnit test pre-loaded with test data (src/test/com/ge/exercise1/ParserTest.java)

### What to do
1. Build a parser class named MyParser that conforms to the Parser interface
2. Build your own Application, User, and Group classes that extend their abstract counterparts
3. Your parser should output an Application object that contains all the appropriate users and groups

### Other considerations
1. Do not modify the Parser interface or any of the abstract classes. 
Build your own classes that extend and implement these interfaces/abstract classes.


#
## Exercise 5 - Bad Warehouse
### Package com.ge.exercise5
For this exercise you will need to update our warehouse inventory software to accommodate a new type of item.

The software currently works as follows:
1. Items have a type attribute, sellBy attribute, and a value attribute
    - sellBy indicates how many days we have left to sell the item
    - value indicates how valuable the item is
2. The warehouse can manage any number of items
3. Each day the warehouse runs the updateItems method and updates the status of each item lowering the sellBy and value
attribute by 1

However, there are some special cases
1. Once the sell by date has passed, value goes down at twice the normal rate
2. The value of an item can never go below 0
3. Ageable items improve in value over time. Each day their value goes up by one. The rate doubles if past sellBy
4. The value of an item never goes above 50
5. Precious items never decrease in value and never need to be sold
6. Rare items increase in value over time like ageable items, however, within 14 days of the sell by the value improves by 2x the normal rate,
and within 7 days the value improves by 3x the normal rate. After the sellBy the value drops to 0.


### What is provided
1. Warehouse class
    - Has the updateItems logic
2. Item class
    - Describes the type of item, the sellBy, and the value
3. Extensive JUnit tests in src/test/com/ge/exercise5

### What to do
1. Update the software as necessary to accomplish the following
    - Add a new type of item that is perishable.
    - Perishable items are to degrade in value twice as fast as normal items
    
### Other considerations
1. Feel free to make any necessary changes.
2. Retain the existing tests as much as possible.
