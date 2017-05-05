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
    (OPER 7 JSR []  [(s putchar)])
    (OPER 10 Mov [(r 4)]  [(m RetReg)])
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
    (OPER 11 JSR []  [(s putchar)])
    (OPER 14 Mov [(r 8)]  [(m RetReg)])
    (OPER 15 Mov [(r 9)]  [(i 1)])
    (OPER 16 Pass []  [(r 9)])
    (OPER 17 JSR []  [(s putDigit)])
    (OPER 20 Mov [(r 10)]  [(m RetReg)])
  )
  (BB 4
  )
  (BB 27
    (OPER 94 Func_Exit []  [])
    (OPER 95 Return []  [(m RetReg)])
  )
  (BB 15
    (OPER 57 Mov [(r 29)]  [(i 1)])
    (OPER 58 EQ [(r 30)]  [(r 3)(r 29)])
    (OPER 59 BEQ []  [(r 30)(i 0)(bb 17)])
  )
  (BB 18
    (OPER 60 Mov [(r 31)]  [(i 0)])
    (OPER 61 Pass []  [(r 31)])
    (OPER 62 JSR []  [(s putDigit)])
    (OPER 65 Mov [(r 32)]  [(m RetReg)])
  )
  (BB 17
    (OPER 66 Jmp []  [(bb 13)])
  )
  (BB 22
    (OPER 82 Mov [(r 41)]  [(i 1)])
    (OPER 83 EQ [(r 42)]  [(r 3)(r 41)])
    (OPER 84 BEQ []  [(r 42)(i 0)(bb 24)])
  )
  (BB 25
    (OPER 85 Mov [(r 43)]  [(i 0)])
    (OPER 86 Pass []  [(r 43)])
    (OPER 87 JSR []  [(s putDigit)])
    (OPER 90 Mov [(r 44)]  [(m RetReg)])
  )
  (BB 24
    (OPER 91 Jmp []  [(bb 20)])
  )
  (BB 6
    (OPER 23 Mov [(r 11)]  [(i 1000)])
    (OPER 24 GTE [(r 12)]  [(r 1)(r 11)])
    (OPER 25 BEQ []  [(r 12)(i 0)(bb 10)])
  )
  (BB 11
    (OPER 26 Mov [(r 13)]  [(i 1000)])
    (OPER 27 Div_I [(r 14)]  [(r 1)(r 13)])
    (OPER 28 Mov [(r 2)]  [(r 14)])
    (OPER 29 Pass []  [(r 2)])
    (OPER 30 JSR []  [(s putDigit)])
    (OPER 33 Mov [(r 15)]  [(m RetReg)])
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
    (OPER 47 JSR []  [(s putDigit)])
    (OPER 50 Mov [(r 24)]  [(m RetReg)])
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
  (BB 21
    (OPER 70 Mov [(r 35)]  [(i 10)])
    (OPER 71 Div_I [(r 36)]  [(r 1)(r 35)])
    (OPER 72 Mov [(r 2)]  [(r 36)])
    (OPER 73 Pass []  [(r 2)])
    (OPER 74 JSR []  [(s putDigit)])
    (OPER 77 Mov [(r 37)]  [(m RetReg)])
    (OPER 78 Mov [(r 38)]  [(i 10)])
    (OPER 79 Mul_I [(r 39)]  [(r 2)(r 38)])
    (OPER 80 Sub_I [(r 40)]  [(r 1)(r 39)])
    (OPER 81 Mov [(r 1)]  [(r 40)])
  )
  (BB 20
    (OPER 92 Pass []  [(r 1)])
    (OPER 93 JSR []  [(s putDigit)])
    (OPER 96 Mov [(r 45)]  [(m RetReg)])
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
    (OPER 12 Store []  [(r 11)(s a)])
  )
  (BB 4
    (OPER 17 Mov [(r 14)]  [(i 0)])
    (OPER 18 Mov [(r 4)]  [(r 14)])
    (OPER 19 Mov [(r 15)]  [(i 1)])
    (OPER 20 Mov [(r 6)]  [(r 15)])
    (OPER 21 Mov [(r 16)]  [(i 8)])
    (OPER 22 LTE [(r 17)]  [(r 6)(r 16)])
    (OPER 23 BEQ []  [(r 17)(i 0)(bb 8)])
  )
  (BB 7
    (OPER 24 Add_I [(r 18)]  [(r 4)(r 6)])
    (OPER 25 Mov [(r 4)]  [(r 18)])
    (OPER 26 Mov [(r 19)]  [(i 1)])
    (OPER 27 Add_I [(r 20)]  [(r 6)(r 19)])
    (OPER 28 Mov [(r 6)]  [(r 20)])
    (OPER 29 Mov [(r 21)]  [(i 8)])
    (OPER 30 LTE [(r 22)]  [(r 6)(r 21)])
    (OPER 31 BNE []  [(r 22)(i 0)(bb 7)])
  )
  (BB 8
    (OPER 32 Mov [(r 23)]  [(i 3)])
    (OPER 33 Div_I [(r 24)]  [(r 4)(r 23)])
    (OPER 34 Mov [(r 5)]  [(r 24)])
    (OPER 35 Mov [(r 25)]  [(i 4)])
    (OPER 36 Mul_I [(r 26)]  [(r 5)(r 25)])
    (OPER 37 Mov [(r 4)]  [(r 26)])
    (OPER 38 Pass []  [(r 2)])
    (OPER 39 Load [(r 27)]  [(s a)])
    (OPER 40 Pass []  [(r 27)])
    (OPER 41 JSR []  [(s addThem)])
    (OPER 44 Mov [(r 28)]  [(m RetReg)])
    (OPER 45 Mov [(r 3)]  [(r 28)])
    (OPER 46 Mov [(r 29)]  [(i 56)])
    (OPER 47 Pass []  [(r 29)])
    (OPER 48 JSR []  [(s putchar)])
    (OPER 51 Mov [(r 30)]  [(m RetReg)])
    (OPER 52 Mov [(r 31)]  [(i 61)])
    (OPER 53 Pass []  [(r 31)])
    (OPER 54 JSR []  [(s putchar)])
    (OPER 57 Mov [(r 32)]  [(m RetReg)])
    (OPER 58 Add_I [(r 33)]  [(r 3)(r 4)])
    (OPER 59 Pass []  [(r 33)])
    (OPER 60 JSR []  [(s putchar)])
    (OPER 63 Mov [(r 34)]  [(m RetReg)])
    (OPER 64 Mov [(r 35)]  [(i 10)])
    (OPER 65 Pass []  [(r 35)])
    (OPER 66 JSR []  [(s putchar)])
    (OPER 69 Mov [(r 36)]  [(m RetReg)])
    (OPER 70 Mov [(r 37)]  [(i 0)])
    (OPER 71 Mov [(r 6)]  [(r 37)])
    (OPER 72 Mov [(r 38)]  [(i 10)])
    (OPER 73 LT [(r 39)]  [(r 6)(r 38)])
    (OPER 74 BEQ []  [(r 39)(i 0)(bb 15)])
  )
  (BB 14
    (OPER 75 Mov [(r 40)]  [(i 48)])
    (OPER 76 Add_I [(r 41)]  [(r 40)(r 6)])
    (OPER 77 Pass []  [(r 41)])
    (OPER 78 JSR []  [(s putchar)])
    (OPER 81 Mov [(r 42)]  [(m RetReg)])
    (OPER 82 Mov [(r 43)]  [(i 1)])
    (OPER 83 Add_I [(r 44)]  [(r 6)(r 43)])
    (OPER 84 Mov [(r 6)]  [(r 44)])
    (OPER 85 Mov [(r 45)]  [(i 10)])
    (OPER 86 LT [(r 46)]  [(r 6)(r 45)])
    (OPER 87 BNE []  [(r 46)(i 0)(bb 14)])
  )
  (BB 15
    (OPER 88 Mov [(r 47)]  [(i 10)])
    (OPER 89 Pass []  [(r 47)])
    (OPER 90 JSR []  [(s putchar)])
    (OPER 93 Mov [(r 48)]  [(m RetReg)])
    (OPER 94 Mov [(r 49)]  [(i 67)])
    (OPER 95 Pass []  [(r 49)])
    (OPER 96 JSR []  [(s putchar)])
    (OPER 99 Mov [(r 50)]  [(m RetReg)])
    (OPER 100 Mov [(r 51)]  [(i 83)])
    (OPER 101 Pass []  [(r 51)])
    (OPER 102 JSR []  [(s putchar)])
    (OPER 105 Mov [(r 52)]  [(m RetReg)])
    (OPER 106 Mov [(r 53)]  [(i 3510)])
    (OPER 107 Pass []  [(r 53)])
    (OPER 108 JSR []  [(s printInt)])
    (OPER 111 Mov [(r 54)]  [(m RetReg)])
    (OPER 112 Mov [(r 55)]  [(i 10)])
    (OPER 113 Pass []  [(r 55)])
    (OPER 114 JSR []  [(s putchar)])
    (OPER 117 Mov [(r 56)]  [(m RetReg)])
    (OPER 118 Mov [(r 57)]  [(i 0)])
    (OPER 119 Mov [(r 2)]  [(r 57)])
    (OPER 120 Mov [(r 58)]  [(i 1)])
    (OPER 121 Mov [(r 3)]  [(r 58)])
    (OPER 122 Mov [(r 59)]  [(i 1)])
    (OPER 123 Mov [(r 4)]  [(r 59)])
    (OPER 124 Mov [(r 60)]  [(i 0)])
    (OPER 125 Mov [(r 5)]  [(r 60)])
    (OPER 126 Mov [(r 61)]  [(i 0)])
    (OPER 127 Mov [(r 6)]  [(r 61)])
    (OPER 128 Mov [(r 62)]  [(i 0)])
    (OPER 129 EQ [(r 63)]  [(r 2)(r 62)])
    (OPER 130 BEQ []  [(r 63)(i 0)(bb 24)])
  )
  (BB 23
    (OPER 131 Mov [(r 64)]  [(i 0)])
    (OPER 132 EQ [(r 65)]  [(r 3)(r 64)])
    (OPER 133 BEQ []  [(r 65)(i 0)(bb 27)])
  )
  (BB 26
    (OPER 134 Mov [(r 66)]  [(i 1)])
    (OPER 135 Mov [(r 6)]  [(r 66)])
  )
  (BB 25
  )
  (BB 22
    (OPER 154 Mov [(r 75)]  [(i 10)])
    (OPER 155 EQ [(r 76)]  [(r 6)(r 75)])
    (OPER 156 BEQ []  [(r 76)(i 0)(bb 36)])
  )
  (BB 35
    (OPER 157 Mov [(r 77)]  [(i 99)])
    (OPER 158 Pass []  [(r 77)])
    (OPER 159 JSR []  [(s putchar)])
    (OPER 162 Mov [(r 78)]  [(m RetReg)])
    (OPER 163 Mov [(r 79)]  [(i 0)])
    (OPER 164 Pass []  [(r 79)])
    (OPER 165 JSR []  [(s putDigit)])
    (OPER 168 Mov [(r 80)]  [(m RetReg)])
    (OPER 169 Mov [(r 81)]  [(i 0)])
    (OPER 170 Pass []  [(r 81)])
    (OPER 171 JSR []  [(s putDigit)])
    (OPER 174 Mov [(r 82)]  [(m RetReg)])
    (OPER 175 Mov [(r 83)]  [(i 108)])
    (OPER 176 Pass []  [(r 83)])
    (OPER 177 JSR []  [(s putchar)])
    (OPER 180 Mov [(r 84)]  [(m RetReg)])
  )
  (BB 34
    (OPER 211 Mov [(r 94)]  [(i 10)])
    (OPER 212 Pass []  [(r 94)])
    (OPER 213 JSR []  [(s putchar)])
    (OPER 216 Mov [(r 95)]  [(m RetReg)])
    (OPER 217 Mov [(r 96)]  [(i 0)])
    (OPER 218 Mov [(m RetReg)]  [(r 96)])
  )
  (BB 47
    (OPER 219 Func_Exit []  [])
    (OPER 220 Return []  [(m RetReg)])
  )
  (BB 6
    (OPER 13 Load [(r 12)]  [(s a)])
    (OPER 14 Mov [(r 13)]  [(i 4)])
    (OPER 15 Store []  [(r 13)(s a)])
    (OPER 16 Jmp []  [(bb 4)])
  )
  (BB 33
    (OPER 146 Mov [(r 73)]  [(i 3)])
    (OPER 147 Mov [(r 6)]  [(r 73)])
    (OPER 148 Jmp []  [(bb 31)])
  )
  (BB 30
    (OPER 141 Mov [(r 70)]  [(i 0)])
    (OPER 142 EQ [(r 71)]  [(r 5)(r 70)])
    (OPER 143 BEQ []  [(r 71)(i 0)(bb 33)])
  )
  (BB 32
    (OPER 144 Mov [(r 72)]  [(i 10)])
    (OPER 145 Mov [(r 6)]  [(r 72)])
  )
  (BB 31
    (OPER 149 Jmp []  [(bb 28)])
  )
  (BB 27
    (OPER 136 Mov [(r 67)]  [(i 0)])
    (OPER 137 EQ [(r 68)]  [(r 4)(r 67)])
    (OPER 138 BEQ []  [(r 68)(i 0)(bb 30)])
  )
  (BB 29
    (OPER 139 Mov [(r 69)]  [(i 2)])
    (OPER 140 Mov [(r 6)]  [(r 69)])
  )
  (BB 28
    (OPER 150 Jmp []  [(bb 25)])
  )
  (BB 24
    (OPER 151 Mov [(r 74)]  [(i 0)])
    (OPER 152 Mov [(r 6)]  [(r 74)])
    (OPER 153 Jmp []  [(bb 22)])
  )
  (BB 36
    (OPER 181 Mov [(r 85)]  [(i 98)])
    (OPER 182 Pass []  [(r 85)])
    (OPER 183 JSR []  [(s putchar)])
    (OPER 186 Mov [(r 86)]  [(m RetReg)])
    (OPER 187 Mov [(r 87)]  [(i 97)])
    (OPER 188 Pass []  [(r 87)])
    (OPER 189 JSR []  [(s putchar)])
    (OPER 192 Mov [(r 88)]  [(m RetReg)])
    (OPER 193 Mov [(r 89)]  [(i 100)])
    (OPER 194 Pass []  [(r 89)])
    (OPER 195 JSR []  [(s putchar)])
    (OPER 198 Mov [(r 90)]  [(m RetReg)])
    (OPER 199 Mov [(r 91)]  [(i 61)])
    (OPER 200 Pass []  [(r 91)])
    (OPER 201 JSR []  [(s putchar)])
    (OPER 204 Mov [(r 92)]  [(m RetReg)])
    (OPER 205 Pass []  [(r 6)])
    (OPER 206 JSR []  [(s printInt)])
    (OPER 209 Mov [(r 93)]  [(m RetReg)])
    (OPER 210 Jmp []  [(bb 34)])
  )
)
