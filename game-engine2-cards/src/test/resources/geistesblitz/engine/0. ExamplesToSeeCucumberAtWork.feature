Feature: Examples to see cucumber at work

  Scenario: Say hello to 5 unknown people
  This example demonstrates how to run a parameterized test, so using the number 5 in this example
    Given there are 5 people in the room
    Then correct greeting is "Hello to all 5 of you"

  Scenario: Say hello to known people
  This example demonstrates how to run a single test that uses multiple inputs, in this case three named people. In this
  example you also see how Cucumber transforms the combination of 2 strings in the below table into objects of type
  ExamplePerson. It does this by analysing the signature of the step definition, creating an instance of the class
  it finds there and then setting the properties from the below table directly on the internal fields of the object.
    Given the following people are in the room:
      | firstname | lastname   |
      | Martin    | van Dijken |
      | Wim       | Heemskerk  |
      | Simone    | de Ruijter |
    Then correct greeting is "Hello to all 3 of you, hi Martin, hi Wim, hi Simone"

  Scenario Outline: Say hello to 1 known person
  This example demonstrates how you can use 1 scenario outline to spawn multiple tests. Each row in the examples table
  will generate a single test replacing the <> values by the values from the examples.
    Given a person with firstname "<firstname>" and lastname "<lastname>" is alone in the room
    Then correct greeting is "hi <firstname>"
  Examples:
    | firstname | lastname   |
    | Martin    | van Dijken |
    | Wim       | Heemskerk  |
    | Simone    | de Ruijter |
