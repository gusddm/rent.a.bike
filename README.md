# rent.a.bike
A Java model to implement a Bike rental service.

This is meant to build with Maven

To run test just step in main directory and type : mvn test

For this model I've mainly used an Strategy design pattern. This is so because you can add new implementations which behave independently between them, just keeping a contract with a common interface. 



Another benefit is that your code is more readable/testable.

For testing I've decided to use some Mockito combined with Junit, to make some behavior oriented test, and some results assertion too.
