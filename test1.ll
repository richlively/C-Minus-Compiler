(DATA  a)
(FUNCTION  main  [(void )]
  (BB 2
    (OPER 3 Func_Entry []  [])
  )
  (BB 3
    (OPER 4 Mov [(r 7)]  [(i 0)])
    (OPER 5 Mov [(r 4)]  [(r 7)])
    (OPER 6 Mov [(r 8)]  [(i 1)])
    (OPER 7 Mov [(r 6)]  [(r 8)])
    (OPER 8 Mov [(r 9)]  [(i 8)])
    (OPER 9 LTE [(r 10)]  [(r 6)(r 9)])
    (OPER 10 BEQ []  [(r 10)(i 0)(bb 5)])
    (OPER 11 Add_I [(r 11)]  [(r 4)(r 6)])
    (OPER 12 Mov [(r 4)]  [(r 11)])
    (OPER 13 Mov [(r 12)]  [(i 1)])
    (OPER 14 Add_I [(r 13)]  [(r 6)(r 12)])
    (OPER 15 Mov [(r 6)]  [(r 13)])
  )
  (BB 4
    (OPER 16 BEQ []  [(r 10)(i 0)(bb 5)])
  )
  (BB 5
    (OPER 17 Mov [(r 14)]  [(i 0)])
    (OPER 18 Mov [(m RetReg)]  [(r 14)])
  )
  (BB 6
    (OPER 19 Func_Exit []  [])
    (OPER 20 Return []  [(m RetReg)])
  )
)
