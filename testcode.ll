(DATA  a)
(FUNCTION  addThem  [(int d) (int e)]
  (BB 2
    (OPER 3 Func_Entry []  [])
  )
  (BB 3
    (OPER 4 Add_I [(r 4)]  [(r 1)(r 2)])
    (OPER 5 Mov [(r 3)]  [(r 4)])
    (OPER 6 Mov [(m RetReg)]  [(r 3)])
  )
  (BB 4
    (OPER 7 Func_Exit []  [])
    (OPER 8 Return []  [(m RetReg)])
  )
)
(FUNCTION  putDigit  [(int s)]
  (BB 2
    (OPER 3 Func_Entry []  [])
  )
  (BB 3
    (OPER 4 Mov [(r 2)]  [(i 48)])
    (OPER 5 Add_I [(r 3)]  [(r 2)(r 1)])
    (OPER 6 Pass []  [(r 3)])
  )
  (BB 4
    (OPER 8 Func_Exit []  [])
    (OPER 9 Return []  [(m RetReg)])
  )
)
(FUNCTION  printInt  [(int r)]
  (BB 2
    (OPER 3 Func_Entry []  [])
  )
  (BB 3
    (OPER 4 Mov [(r 4)]  [(i 0)])
    (OPER 5 Mov [(r 3)]  [(r 4)])
    (OPER 6 Mov [(r 5)]  [(i 10000)])
    (OPER 7 GTE [(r 6)]  [(r 1)(r 5)])
    (OPER 8 BEQ []  [(r 6)(i 0)(bb 6)])
  )
  (BB 5
    (OPER 9 Mov [(r 7)]  [(i 45)])
    (OPER 10 Pass []  [(r 7)])
    (OPER 15 Mov [(r 9)]  [(i 1)])
    (OPER 16 Pass []  [(r 9)])
  )
  (BB 4
  )
  (BB 11
    (OPER 26 Mov [(r 13)]  [(i 1000)])
    (OPER 27 Div_I [(r 14)]  [(r 1)(r 13)])
    (OPER 28 Mov [(r 2)]  [(r 14)])
    (OPER 29 Pass []  [(r 2)])
    (OPER 34 Mov [(r 16)]  [(i 1000)])
    (OPER 35 Mul_I [(r 17)]  [(r 2)(r 16)])
    (OPER 36 Sub_I [(r 18)]  [(r 1)(r 17)])
    (OPER 37 Mov [(r 1)]  [(r 18)])
    (OPER 38 Mov [(r 19)]  [(i 1)])
    (OPER 39 Mov [(r 3)]  [(r 19)])
  )
  (BB 10
    (OPER 40 Mov [(r 20)]  [(i 100)])
    (OPER 41 GTE [(r 21)]  [(r 1)(r 20)])
    (OPER 42 BEQ []  [(r 21)(i 0)(bb 15)])
  )
  (BB 14
    (OPER 43 Mov [(r 22)]  [(i 100)])
    (OPER 44 Div_I [(r 23)]  [(r 1)(r 22)])
    (OPER 45 Mov [(r 2)]  [(r 23)])
    (OPER 46 Pass []  [(r 2)])
    (OPER 51 Mov [(r 25)]  [(i 100)])
    (OPER 52 Mul_I [(r 26)]  [(r 2)(r 25)])
    (OPER 53 Sub_I [(r 27)]  [(r 1)(r 26)])
    (OPER 54 Mov [(r 1)]  [(r 27)])
    (OPER 55 Mov [(r 28)]  [(i 1)])
    (OPER 56 Mov [(r 3)]  [(r 28)])
  )
  (BB 13
    (OPER 67 Mov [(r 33)]  [(i 10)])
    (OPER 68 GTE [(r 34)]  [(r 1)(r 33)])
    (OPER 69 BEQ []  [(r 34)(i 0)(bb 22)])
  )
  (BB 18
    (OPER 60 Mov [(r 31)]  [(i 0)])
    (OPER 61 Pass []  [(r 31)])
  )
  (BB 17
  )
  (BB 21
    (OPER 70 Mov [(r 35)]  [(i 10)])
    (OPER 71 Div_I [(r 36)]  [(r 1)(r 35)])
    (OPER 72 Mov [(r 2)]  [(r 36)])
    (OPER 73 Pass []  [(r 2)])
    (OPER 78 Mov [(r 38)]  [(i 10)])
    (OPER 79 Mul_I [(r 39)]  [(r 2)(r 38)])
    (OPER 80 Sub_I [(r 40)]  [(r 1)(r 39)])
    (OPER 81 Mov [(r 1)]  [(r 40)])
  )
  (BB 20
    (OPER 92 Pass []  [(r 1)])
  )
  (BB 25
    (OPER 85 Mov [(r 43)]  [(i 0)])
    (OPER 86 Pass []  [(r 43)])
  )
  (BB 24
  )
  (BB 27
    (OPER 94 Func_Exit []  [])
    (OPER 95 Return []  [(m RetReg)])
  )
  (BB 15
    (OPER 57 Mov [(r 29)]  [(i 1)])
    (OPER 58 EQ [(r 30)]  [(r 3)(r 29)])
    (OPER 59 BEQ []  [(r 30)(i 0)(bb 17)])
    (OPER 66 Jmp []  [(bb 13)])
  )
  (BB 22
    (OPER 82 Mov [(r 41)]  [(i 1)])
    (OPER 83 EQ [(r 42)]  [(r 3)(r 41)])
    (OPER 84 BEQ []  [(r 42)(i 0)(bb 24)])
    (OPER 91 Jmp []  [(bb 20)])
  )
  (BB 6
    (OPER 23 Mov [(r 11)]  [(i 1000)])
    (OPER 24 GTE [(r 12)]  [(r 1)(r 11)])
    (OPER 25 BEQ []  [(r 12)(i 0)(bb 10)])
    (OPER 97 Jmp []  [(bb 4)])
  )
)
(FUNCTION  main  [(void )]
  (BB 2
    (OPER 3 Func_Entry []  [])
  )
  (BB 3
    (OPER 4 Mov [(r 7)]  [(i 5)])
    (OPER 5 Mov [(r 3)]  [(r 7)])
    (OPER 6 Mov [(r 2)]  [(r 3)])
    (OPER 7 Mov [(r 8)]  [(i 5)])
    (OPER 8 EQ [(r 9)]  [(r 2)(r 8)])
    (OPER 9 BEQ []  [(r 9)(i 0)(bb 6)])
  )
  (BB 5
    (OPER 10 Load [(r 10)]  [(s a)])
    (OPER 11 Mov [(r 11)]  [(i 3)])
    (OPER 12 Store [(s a)]  [(r 11)])
  )
  (BB 4
    (OPER 17 Mov [(r 14)]  [(i 0)])
    (OPER 18 Mov [(r 4)]  [(r 14)])
    (OPER 19 Mov [(r 15)]  [(i 1)])
    (OPER 20 Mov [(r 6)]  [(r 15)])
    (OPER 21 Mov [(r 16)]  [(i 8)])
    (OPER 22 LTE [(r 17)]  [(r 6)(r 16)])
    (OPER 23 BEQ []  [(r 17)(i 0)(bb 8)])
    (OPER 24 Add_I [(r 18)]  [(r 4)(r 6)])
    (OPER 25 Mov [(r 4)]  [(r 18)])
    (OPER 26 Mov [(r 19)]  [(i 1)])
    (OPER 27 Add_I [(r 20)]  [(r 6)(r 19)])
    (OPER 28 Mov [(r 6)]  [(r 20)])
  )
  (BB 7
    (OPER 29 BEQ []  [])
  )
  (BB 8
    (OPER 30 Mov [(r 21)]  [(i 3)])
    (OPER 31 Div_I [(r 22)]  [(r 4)(r 21)])
    (OPER 32 Mov [(r 5)]  [(r 22)])
    (OPER 33 Mov [(r 23)]  [(i 4)])
    (OPER 34 Mul_I [(r 24)]  [(r 5)(r 23)])
    (OPER 35 Mov [(r 4)]  [(r 24)])
    (OPER 36 Pass []  [(r 2)])
    (OPER 37 Load [(r 25)]  [(s a)])
    (OPER 38 Pass []  [(r 25)])
    (OPER 43 Mov [(r 3)]  [(r 26)])
    (OPER 44 Mov [(r 27)]  [(i 56)])
    (OPER 45 Pass []  [(r 27)])
    (OPER 50 Mov [(r 29)]  [(i 61)])
    (OPER 51 Pass []  [(r 29)])
    (OPER 56 Add_I [(r 31)]  [(r 3)(r 4)])
    (OPER 57 Pass []  [(r 31)])
    (OPER 62 Mov [(r 33)]  [(i 10)])
    (OPER 63 Pass []  [(r 33)])
    (OPER 68 Mov [(r 35)]  [(i 0)])
    (OPER 69 Mov [(r 6)]  [(r 35)])
    (OPER 70 Mov [(r 36)]  [(i 10)])
    (OPER 71 LT [(r 37)]  [(r 6)(r 36)])
    (OPER 72 BEQ []  [(r 37)(i 0)(bb 15)])
    (OPER 73 Mov [(r 38)]  [(i 48)])
    (OPER 74 Add_I [(r 39)]  [(r 38)(r 6)])
    (OPER 75 Pass []  [(r 39)])
    (OPER 80 Mov [(r 41)]  [(i 1)])
    (OPER 81 Add_I [(r 42)]  [(r 6)(r 41)])
    (OPER 82 Mov [(r 6)]  [(r 42)])
  )
  (BB 14
    (OPER 83 BEQ []  [])
  )
  (BB 15
    (OPER 84 Mov [(r 43)]  [(i 10)])
    (OPER 85 Pass []  [(r 43)])
    (OPER 90 Mov [(r 45)]  [(i 67)])
    (OPER 91 Pass []  [(r 45)])
    (OPER 96 Mov [(r 47)]  [(i 83)])
    (OPER 97 Pass []  [(r 47)])
    (OPER 102 Mov [(r 49)]  [(i 3510)])
    (OPER 103 Pass []  [(r 49)])
    (OPER 108 Mov [(r 51)]  [(i 10)])
    (OPER 109 Pass []  [(r 51)])
    (OPER 114 Mov [(r 53)]  [(i 0)])
    (OPER 115 Mov [(r 2)]  [(r 53)])
    (OPER 116 Mov [(r 54)]  [(i 1)])
    (OPER 117 Mov [(r 3)]  [(r 54)])
    (OPER 118 Mov [(r 55)]  [(i 1)])
    (OPER 119 Mov [(r 4)]  [(r 55)])
    (OPER 120 Mov [(r 56)]  [(i 0)])
    (OPER 121 Mov [(r 5)]  [(r 56)])
    (OPER 122 Mov [(r 57)]  [(i 0)])
    (OPER 123 Mov [(r 6)]  [(r 57)])
    (OPER 124 Mov [(r 58)]  [(i 0)])
    (OPER 125 EQ [(r 59)]  [(r 2)(r 58)])
    (OPER 126 BEQ []  [(r 59)(i 0)(bb 24)])
  )
  (BB 23
    (OPER 127 Mov [(r 60)]  [(i 0)])
    (OPER 128 EQ [(r 61)]  [(r 3)(r 60)])
    (OPER 129 BEQ []  [(r 61)(i 0)(bb 27)])
  )
  (BB 26
    (OPER 130 Mov [(r 62)]  [(i 1)])
    (OPER 131 Mov [(r 6)]  [(r 62)])
  )
  (BB 25
  )
  (BB 29
    (OPER 135 Mov [(r 65)]  [(i 2)])
    (OPER 136 Mov [(r 6)]  [(r 65)])
  )
  (BB 28
  )
  (BB 32
    (OPER 140 Mov [(r 68)]  [(i 10)])
    (OPER 141 Mov [(r 6)]  [(r 68)])
  )
  (BB 31
  )
  (BB 22
    (OPER 150 Mov [(r 71)]  [(i 10)])
    (OPER 151 EQ [(r 72)]  [(r 6)(r 71)])
    (OPER 152 BEQ []  [(r 72)(i 0)(bb 36)])
  )
  (BB 35
    (OPER 153 Mov [(r 73)]  [(i 99)])
    (OPER 154 Pass []  [(r 73)])
    (OPER 159 Mov [(r 75)]  [(i 0)])
    (OPER 160 Pass []  [(r 75)])
    (OPER 165 Mov [(r 77)]  [(i 0)])
    (OPER 166 Pass []  [(r 77)])
    (OPER 171 Mov [(r 79)]  [(i 108)])
    (OPER 172 Pass []  [(r 79)])
  )
  (BB 34
    (OPER 207 Mov [(r 90)]  [(i 10)])
    (OPER 208 Pass []  [(r 90)])
    (OPER 213 Mov [(r 92)]  [(i 0)])
    (OPER 214 Mov [(m RetReg)]  [(r 92)])
  )
  (BB 47
    (OPER 215 Func_Exit []  [])
    (OPER 216 Return []  [(m RetReg)])
  )
  (BB 6
    (OPER 13 Load [(r 12)]  [(s a)])
    (OPER 14 Mov [(r 13)]  [(i 4)])
    (OPER 15 Store [(s a)]  [(r 13)])
    (OPER 16 Jmp []  [(bb 4)])
  )
  (BB 33
    (OPER 142 Mov [(r 69)]  [(i 3)])
    (OPER 143 Mov [(r 6)]  [(r 69)])
    (OPER 144 Jmp []  [(bb 31)])
  )
  (BB 30
    (OPER 137 Mov [(r 66)]  [(i 0)])
    (OPER 138 EQ [(r 67)]  [(r 5)(r 66)])
    (OPER 139 BEQ []  [(r 67)(i 0)(bb 33)])
    (OPER 145 Jmp []  [(bb 28)])
  )
  (BB 27
    (OPER 132 Mov [(r 63)]  [(i 0)])
    (OPER 133 EQ [(r 64)]  [(r 4)(r 63)])
    (OPER 134 BEQ []  [(r 64)(i 0)(bb 30)])
    (OPER 146 Jmp []  [(bb 25)])
  )
  (BB 24
    (OPER 147 Mov [(r 70)]  [(i 0)])
    (OPER 148 Mov [(r 6)]  [(r 70)])
    (OPER 149 Jmp []  [(bb 22)])
  )
  (BB 36
    (OPER 177 Mov [(r 81)]  [(i 98)])
    (OPER 178 Pass []  [(r 81)])
    (OPER 183 Mov [(r 83)]  [(i 97)])
    (OPER 184 Pass []  [(r 83)])
    (OPER 189 Mov [(r 85)]  [(i 100)])
    (OPER 190 Pass []  [(r 85)])
    (OPER 195 Mov [(r 87)]  [(i 61)])
    (OPER 196 Pass []  [(r 87)])
    (OPER 201 Pass []  [(r 6)])
    (OPER 206 Jmp []  [(bb 34)])
  )
)
