(DATA  howdy)
(FUNCTION  main  [(int i) (int j)]
  (BB 2
    (OPER 3 Func_Entry []  [])
  )
  (BB 3
    (OPER 4 Mov [(r 4)]  [(i 2)])
    (OPER 5 Mov [(r 3)]  [(r 4)])
    (OPER 6 Mov [(r 5)]  [(i 2)])
    (OPER 7 EQ [(r 6)]  [(r 3)(r 5)])
    (OPER 8 BEQ []  [(r 6)(i 0)(bb 4)])
  )
  (BB 5
    (OPER 9 Mov [(r 7)]  [(i 1)])
    (OPER 10 Add_I [(r 8)]  [(r 3)(r 7)])
    (OPER 11 Mov [(r 3)]  [(r 8)])
  )
  (BB 4
    (OPER 12 Mov [(r 9)]  [(i 0)])
    (OPER 13 Mov [(m RetReg)]  [(r 9)])
  )
  (BB 6
    (OPER 14 Func_Exit []  [])
    (OPER 15 Return []  [(m RetReg)])
  )
)
