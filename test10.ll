(FUNCTION  main  [(void )]
  (BB 2
    (OPER 3 Func_Entry []  [])
  )
  (BB 3
    (OPER 4 Mov [(r 5)]  [(i 5)])
    (OPER 5 Mov [(r 2)]  [(r 5)])
    (OPER 6 Mov [(r 6)]  [(i 1)])
    (OPER 7 Mov [(r 3)]  [(r 6)])
    (OPER 8 Add_I [(r 7)]  [(r 2)(r 3)])
    (OPER 9 Mov [(r 4)]  [(r 7)])
    (OPER 10 GT [(r 8)]  [(r 2)(r 3)])
    (OPER 11 BEQ []  [(r 8)(i 0)(bb 4)])
  )
  (BB 5
    (OPER 12 Mov [(r 9)]  [(i 65)])
    (OPER 13 Pass []  [(r 9)])
    (OPER 14 JSR []  [(s putchar)])
    (OPER 17 Mov [(r 10)]  [(m RetReg)])
  )
  (BB 4
    (OPER 18 LT [(r 11)]  [(r 2)(r 3)])
    (OPER 19 BEQ []  [(r 11)(i 0)(bb 9)])
  )
  (BB 8
    (OPER 20 Mov [(r 12)]  [(i 66)])
    (OPER 21 Pass []  [(r 12)])
    (OPER 22 JSR []  [(s putchar)])
    (OPER 25 Mov [(r 13)]  [(m RetReg)])
  )
  (BB 7
    (OPER 33 Mov [(r 16)]  [(i 5)])
    (OPER 34 Mov [(m RetReg)]  [(r 16)])
  )
  (BB 12
    (OPER 35 Func_Exit []  [])
    (OPER 36 Return []  [(m RetReg)])
  )
  (BB 9
    (OPER 26 Mov [(r 14)]  [(i 67)])
    (OPER 27 Pass []  [(r 14)])
    (OPER 28 JSR []  [(s putchar)])
    (OPER 31 Mov [(r 15)]  [(m RetReg)])
    (OPER 32 Jmp []  [(bb 7)])
  )
)
