test1.asm
AST for test1.txt
FunDecl: INT gcd
(
	Param: u
	Param: v
)
	Compound Statement:
	{
		Local Decls:
			None
		Statement List:
			Select Statement: IF
			(
				Binary Expression: ==
					Variable Expression: v
					Num Expression: 0
			)
				Return Statement: RETURN
					Expression Statement:
						Variable Expression: u
					;
			ELSE
				Return Statement: RETURN
					Expression Statement:
						Call Expression: gcd
						(
							Variable Expression: v
							Binary Expression: -
								Variable Expression: u
								Binary Expression: /
									Variable Expression: u
									Binary Expression: *
										Variable Expression: v
										Variable Expression: v
						)
					;
	}
FunDecl: VOID main
(
	Param: VOID
)
	Compound Statement:
	{
		Local Decls:
			VarDecl: INT x
			VarDecl: INT y
		Statement List:
			Expression Statement:
				Assign Expression: =
					Variable Expression: x
					Call Expression: input
					(
					)
			;
			Expression Statement:
				Assign Expression: =
					Variable Expression: y
					Call Expression: input
					(
					)
			;
			Expression Statement:
				Call Expression: output
				(
					Call Expression: gcd
					(
						Variable Expression: x
						Variable Expression: y
					)
				)
			;
	}
