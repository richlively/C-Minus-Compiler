(FUNCTION  main  [(void )]
  (BB 2
    (OPER 3 Func_Entry []  [])
  )
  (BB 3
    (OPER 4 Mov [(r 5)]  [(i 0)])
    (OPER 5 Mov [(r 2)]  [(r 5)])
    (OPER 6 Mov [(r 6)]  [(i 2)])
    (OPER 7 Mov [(r 3)]  [(r 6)])
    (OPER 8 Mov [(r 7)]  [(i 0)])
    (OPER 9 GT [(r 8)]  [(r 2)(r 7)])
    (OPER 10 BEQ []  [(r 8)(i 0)(bb 6)])
  )
  (BB 5
    (OPER 11 Mov [(r 9)]  [(i 65)])
    (OPER 12 Pass []  [(r 9)])
    (OPER 13 JSR []  [(s putchar)])
    (OPER 16 Mov [(r 10)]  [(m RetReg)])
  )
  (BB 4
    (OPER 34 Mov [(r 17)]  [(i 68)])
    (OPER 35 Pass []  [(r 17)])
    (OPER 36 JSR []  [(s putchar)])
    (OPER 39 Mov [(r 18)]  [(m RetReg)])
  )
  (BB 13
    (OPER 37 Func_Exit []  [])
    (OPER 38 Return []  [(m RetReg)])
  )
  (BB 10
    (OPER 26 Mov [(r 15)]  [(i 67)])
    (OPER 27 Pass []  [(r 15)])
    (OPER 28 JSR []  [(s putchar)])
    (OPER 31 Mov [(r 16)]  [(m RetReg)])
    (OPER 32 Jmp []  [(bb 8)])
  )
  (BB 6
    (OPER 17 Mov [(r 11)]  [(i 1)])
    (OPER 18 EQ [(r 12)]  [(r 3)(r 11)])
    (OPER 19 BEQ []  [(r 12)(i 0)(bb 10)])
  )
  (BB 9
    (OPER 20 Mov [(r 13)]  [(i 66)])
    (OPER 21 Pass []  [(r 13)])
    (OPER 22 JSR []  [(s putchar)])
    (OPER 25 Mov [(r 14)]  [(m RetReg)])
  )
  (BB 8
    (OPER 33 Jmp []  [(bb 4)])
  )
)
