# QL: DSL for Questionnaires

This project is the result of a lab assignment for the Software Construction
course at the [UvA](https://www.uva.nl/). The goal of the assignment is to build
a DSL for questionnaires, called QL. The lab assignment is based on the Language
Workbench Challenge 2013 [LWC'13](https://homepages.cwi.nl/~storm/publications/lwc13-comlan.pdf).
A questionnaire consists of a sequence of questions and derived values presented
to a user by rendering it as a GUI. Later questions may only be visible
depending on answers given to earlier questions.

## Requirements
* Questions are enabled and disabled when different values are entered.
* The type checker detects:
  * Reference to undefined questions
  * Duplicate question declarations with different types
  * Conditions that are not of the type boolean
  * Operands of invalid type to operators
  * Cyclic dependencies between questions
  * Duplicate labels (warning)
* The language supports booleans, integers and string values.
* Different data types in QL map to different (default) GUI widgets.

Here's a simple questionnaire in QL from the domain of tax filing:
```
form taxOfficeExample {
  "Did you sell a house in 2010?"
    hasSoldHouse: boolean
  "Did you buy a house in 2010?"
    hasBoughtHouse: boolean
  "Did you enter a loan?"
    hasMaintLoan: boolean

  if (hasSoldHouse) {
    "What was the selling price?"
      sellingPrice: money
    "Private debts for the sold house:"
      privateDebt: money
    "Value residue:"
      valueResidue: money =
        (sellingPrice - privateDebt)
  }
}
```

## Running the application
Place the questionnaire in `resources` and run the main class
`nl.uva.ql.main.Main` using this questionnaire.
