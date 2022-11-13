form Box {
	A: "A" string ("ardavan")
	B: "B" boolean (true || false)
	C: "C" boolean (true || A)
	D: "D" money (10.32)
	E: "E" integer (D / 2)
	F: "F" boolean (! A)
	if (A && B) {
		G: "G" boolean (10 > true)
	}
}