(FUNCTION  gcd  [(int u) (int v)]
  (BB 2
    (OPER 3 Func_Entry []  [])
  )
  (BB 3
    (OPER 4 Mov [(r 3)]  [(i 0)])
    (OPER 5 EQ [(r 4)]  [(r 2)(r 3)])
    (OPER 6 BEQ []  [(r 4)(i 0)(bb 6)])
  )
  (BB 5
    (OPER 7 Mov [(m RetReg)]  [(r 1)])
  )
  (BB 4
  )
  (BB 9
    (OPER 20 Func_Exit []  [])
    (OPER 21 Return []  [(m RetReg)])
  )
  (BB 6
    (OPER 10 Div_I [(r 5)]  [(r 1)(r 2)])
    (OPER 11 Mul_I [(r 6)]  [(r 5)(r 2)])
    (OPER 12 Sub_I [(r 7)]  [(r 1)(r 6)])
    (OPER 13 Pass []  [(r 7)])
    (OPER 14 Pass []  [(r 2)])
    (OPER 19 Mov [(m RetReg)]  [(r 8)])
    (OPER 22 Jmp []  [(bb 4)])
  )
)
(FUNCTION  main  [(void )]
  (BB 2
    (OPER 3 Func_Entry []  [])
  )
  (BB 3
    (OPER 8 Mov [(r 2)]  [(r 4)])
    (OPER 13 Mov [(r 3)]  [(r 5)])
    (OPER 14 Pass []  [(r 3)])
    (OPER 15 Pass []  [(r 2)])
    (OPER 20 Pass []  [(r 6)])
  )
  (BB 7
    (OPER 22 Func_Exit []  [])
    (OPER 23 Return []  [(m RetReg)])
  )
)
