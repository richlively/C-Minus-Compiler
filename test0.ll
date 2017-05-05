(DATA  howdy)
(FUNCTION  main  [(void )]
  (BB 2
    (OPER 3 Func_Entry []  [])
  )
  (BB 3
    (OPER 4 Mov [(r 3)]  [(i 2)])
    (OPER 5 Mov [(r 2)]  [(r 3)])
    (OPER 6 Mov [(r 4)]  [(i 0)])
    (OPER 7 Mov [(m RetReg)]  [(r 4)])
  )
  (BB 4
    (OPER 8 Func_Exit []  [])
    (OPER 9 Return []  [(m RetReg)])
  )
)
