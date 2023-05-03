Feature: Greeting service

Scenario: Greet the world
  When I request the greeting endpoint with name "World"
  Then the response should be "Hello, World!"

Scenario: Greet a specific name
  When I request the greeting endpoint with name "John"
  Then the response should be "Hello, John!"
