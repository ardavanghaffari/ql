form Box1HouseOwning {
	firstName: "Enter your first name" string
	lastName: "Enter your last name" string
	fullName: "fullName" string (firstName + " " + lastName)
	age: "How old are you?" integer
	if (age < 18) {
		hasMom: "Do you have a mother?" boolean
		if (hasMom) {
			momAge: "How old is your mother?" integer
			ageDifference: "Age difference with your mother" integer (momAge - age)
		}
		hasDad: "Do you have a father?" boolean
		if (hasDad) {
			dadName: "What is your father's name?" string
			if (dadName == "Ardavan") {
				referDad: "Then others probably refer to your father as:" string (dadName + " Senior")
			} else {
				referDad: "My complements:" string (dadName + " is a nice name")
			}
		}
	} else {
		salary: "What is your salary?" money 
		hasSoldHouse: "Did you sell a house in 2016" boolean
		if (hasSoldHouse) {
			sellingPrice: "Price the house was sold for:" money
			privateDebt: "Private debts for the sold house:" money
			valueResidue: "Value residue:" money (sellingPrice - privateDebt)
			tax: "Your calculated tax is:" money (valueResidue / salary)
		}
		
	}	
}