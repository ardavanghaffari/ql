form Box {
	A: "A" boolean (true)
	ID1: "1" integer
	if (A) {
		ID2: "2" integer (ID1)
	} else {
		ID2: "2" integer (ID2 + ID9)
	}
	ID3: "3" money (ID2)
	ID1: "2" money (ID3)
}