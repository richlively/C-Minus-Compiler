(FUNCTION  main  [(void )]
  (BB 2
    (OPER 3 Func_Entry []  [])
  )
  (BB 3
    (OPER 4 Mov [(r 6)]  [(i 0)])
    (OPER 5 Mov [(r 2)]  [(r 6)])
    (OPER 6 Mov [(r 3)]  [(r 2)])
    (OPER 7 Mov [(r 7)]  [(i 1)])
    (OPER 8 Add_I [(r 8)]  [(r 2)(r 7)])
    (OPER 9 Mov [(r 5)]  [(r 8)])
    (OPER 10 Mov [(r 9)]  [(i 50)])
    (OPER 11 Pass []  [(r 9)])
    (OPER 12 JSR []  [(s putchar)])
    (OPER 15 Mov [(r 10)]  [(m RetReg)])
    (OPER 16 Mov [(r 11)]  [(i 5)])
    (OPER 17 LT [(r 12)]  [(r 2)(r 11)])
    (OPER 18 BEQ []  [(r 12)(i 0)(bb 6)])
  )
  (BB 5
    (OPER 19 Mov [(r 13)]  [(i 0)])
    (OPER 20 Mov [(r 4)]  [(r 13)])
    (OPER 21 Mov [(r 14)]  [(i 5)])
    (OPER 22 LT [(r 15)]  [(r 2)(r 14)])
    (OPER 23 BEQ []  [(r 15)(i 1)(bb 5)])
  )
  (BB 6
    (OPER 24 Mov [(r 16)]  [(i 0)])
    (OPER 25 Mov [(m RetReg)]  [(r 16)])
  )
  (BB 7
    (OPER 26 Func_Exit []  [])
    (OPER 27 Return []  [(m RetReg)])
  )
)