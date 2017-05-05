(FUNCTION  fact  [(int x)]
  (BB 2
    (OPER 3 Func_Entry []  [])
  )
  (BB 3
    (OPER 4 Mov [(r 2)]  [(i 1)])
    (OPER 5 GT [(r 3)]  [(r 1)(r 2)])
    (OPER 6 BEQ []  [(r 3)(i 0)(bb 6)])
  )
  (BB 5
    (OPER 7 Mov [(r 4)]  [(i 1)])
    (OPER 8 Sub_I [(r 5)]  [(r 1)(r 4)])
    (OPER 9 Pass []  [(r 5)])
    (OPER 14 Mul_I [(r 7)]  [(r 1)(r 6)])
    (OPER 15 Mov [(m RetReg)]  [(r 7)])
  )
  (BB 4
  )
  (BB 9
    (OPER 20 Func_Exit []  [])
    (OPER 21 Return []  [(m RetReg)])
  )
  (BB 6
    (OPER 18 Mov [(r 8)]  [(i 1)])
    (OPER 19 Mov [(m RetReg)]  [(r 8)])
    (OPER 22 Jmp []  [(bb 4)])
  )
)
(FUNCTION  main  [(void )]
  (BB 2
    (OPER 3 Func_Entry []  [])
  )
  (BB 3
    (OPER 8 Mov [(r 2)]  [(r 3)])
    (OPER 9 Mov [(r 4)]  [(i 0)])
    (OPER 10 GT [(r 5)]  [(r 2)(r 4)])
    (OPER 11 BEQ []  [(r 5)(i 0)(bb 5)])
  )
  (BB 6
    (OPER 12 Pass []  [(r 2)])
    (OPER 17 Pass []  [(r 6)])
  )
  (BB 5
  )
  (BB 8
    (OPER 19 Func_Exit []  [])
    (OPER 20 Return []  [(m RetReg)])
  )
)
