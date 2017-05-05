.data
.comm	a,4,4

.text
	.align 4
.globl  addThem
addThem:
addThem_bb2:
	movl	%EDI, %EAX
	movl	%ESI, %EDI
addThem_bb3:
	addl	%EDI, %EAX
addThem_bb4:
	ret
.globl  putDigit
putDigit:
putDigit_bb2:
putDigit_bb3:
	movl	$48, %EAX
	addl	%EDI, %EAX
	movl	%EAX, %EDI
	call	putchar
putDigit_bb4:
	ret
.globl  printInt
printInt:
printInt_bb2:
	pushq	%R14
	pushq	%R15
	movl	%EDI, %R15D
printInt_bb3:
	movl	$0, %EAX
	movl	%EAX, %R14D
	movl	$10000, %EAX
	cmpl	%EAX, %R15D
	jl	printInt_bb6
printInt_bb5:
	movl	$45, %EAX
	movl	%EAX, %EDI
	call	putchar
	movl	$1, %EAX
	movl	%EAX, %EDI
	call	putDigit
printInt_bb27:
	popq	%R15
	popq	%R14
	ret
printInt_bb15:
	movl	$1, %EAX
	cmpl	%EAX, %R14D
	jne	printInt_bb13
printInt_bb18:
	movl	$0, %EAX
	movl	%EAX, %EDI
	call	putDigit
printInt_bb17:
	jmp	printInt_bb13
printInt_bb22:
	movl	$1, %EAX
	cmpl	%EAX, %R14D
	jne	printInt_bb20
printInt_bb25:
	movl	$0, %EAX
	movl	%EAX, %EDI
	call	putDigit
printInt_bb24:
	jmp	printInt_bb20
printInt_bb6:
	movl	$1000, %EAX
	cmpl	%EAX, %R15D
	jl	printInt_bb10
printInt_bb11:
	movl	$1000, %EDI
	movl	$0, %EDX
	movl	%R15D, %EAX
	idivl	%EDI, %EAX
	movl	%EAX, %R14D
	movl	%R14D, %EDI
	call	putDigit
	movl	$1000, %EDI
	movl	%R14D, %EAX
	imull	%EDI, %EAX
	movl	%EAX, %EDI
	movl	%R15D, %EAX
	subl	%EDI, %EAX
	movl	%EAX, %R15D
	movl	$1, %EAX
	movl	%EAX, %R14D
printInt_bb10:
	movl	$100, %EAX
	cmpl	%EAX, %R15D
	jl	printInt_bb15
printInt_bb14:
	movl	$100, %EDI
	movl	$0, %EDX
	movl	%R15D, %EAX
	idivl	%EDI, %EAX
	movl	%EAX, %R14D
	movl	%R14D, %EDI
	call	putDigit
	movl	$100, %EDI
	movl	%R14D, %EAX
	imull	%EDI, %EAX
	movl	%EAX, %EDI
	movl	%R15D, %EAX
	subl	%EDI, %EAX
	movl	%EAX, %R15D
	movl	$1, %EAX
	movl	%EAX, %R14D
printInt_bb13:
	movl	$10, %EAX
	cmpl	%EAX, %R15D
	jl	printInt_bb22
printInt_bb21:
	movl	$10, %EDI
	movl	$0, %EDX
	movl	%R15D, %EAX
	idivl	%EDI, %EAX
	movl	%EAX, %R14D
	movl	%R14D, %EDI
	call	putDigit
	movl	$10, %EDI
	movl	%R14D, %EAX
	imull	%EDI, %EAX
	movl	%EAX, %EDI
	movl	%R15D, %EAX
	subl	%EDI, %EAX
	movl	%EAX, %R15D
printInt_bb20:
	movl	%R15D, %EDI
	call	putDigit
	jmp	printInt_bb27
.globl  main
main:
main_bb2:
	pushq	%R14
	pushq	%R15
main_bb3:
	movl	$5, %EAX
	movl	%EAX, %R15D
	movl	%R15D, %EDI
	movl	$5, %EAX
	cmpl	%EAX, %EDI
	jne	main_bb6
main_bb5:
	movl	$3, %EAX
	movl	%EAX, a(%RIP)
main_bb4:
	movl	$0, %EAX
	movl	%EAX, %R14D
	movl	$1, %EAX
	movl	%EAX, %R15D
	movl	$8, %EAX
	cmpl	%EAX, %R15D
	jg	main_bb8
main_bb7:
	movl	%R14D, %EAX
	addl	%R15D, %EAX
	movl	%EAX, %R14D
	movl	$1, %ESI
	movl	%R15D, %EAX
	addl	%ESI, %EAX
	movl	%EAX, %R15D
	movl	$8, %EAX
	cmpl	%EAX, %R15D
	jle	main_bb7
main_bb8:
	movl	$3, %ESI
	movl	$0, %EDX
	movl	%R14D, %EAX
	idivl	%ESI, %EAX
	movl	%EAX, %EDX
	movl	$4, %ESI
	movl	%EDX, %EAX
	imull	%ESI, %EAX
	movl	%EAX, %ESI
	movl	%ESI, %R14D
	movl	%EDI, %ESI
	movl	a(%RIP), %EDI
	call	addThem
	movl	%EAX, %R15D
	movl	$56, %EAX
	movl	%EAX, %EDI
	call	putchar
	movl	$61, %EAX
	movl	%EAX, %EDI
	call	putchar
	movl	%R15D, %EAX
	addl	%R14D, %EAX
	movl	%EAX, %EDI
	call	putchar
	movl	$10, %EAX
	movl	%EAX, %EDI
	call	putchar
	movl	$0, %EAX
	movl	%EAX, %R15D
	movl	$10, %EAX
	cmpl	%EAX, %R15D
	jge	main_bb15
main_bb14:
	movl	$48, %EAX
	addl	%R15D, %EAX
	movl	%EAX, %EDI
	call	putchar
	movl	$1, %EDI
	movl	%R15D, %EAX
	addl	%EDI, %EAX
	movl	%EAX, %R15D
	movl	$10, %EAX
	cmpl	%EAX, %R15D
	jl	main_bb14
main_bb15:
	movl	$10, %EAX
	movl	%EAX, %EDI
	call	putchar
	movl	$67, %EAX
	movl	%EAX, %EDI
	call	putchar
	movl	$83, %EAX
	movl	%EAX, %EDI
	call	putchar
	movl	$3510, %EAX
	movl	%EAX, %EDI
	call	printInt
	movl	$10, %EAX
	movl	%EAX, %EDI
	call	putchar
	movl	$0, %EAX
	movl	%EAX, %EDI
	movl	$1, %EAX
	movl	%EAX, %R15D
	movl	$1, %EAX
	movl	%EAX, %R14D
	movl	$0, %EAX
	movl	%EAX, %EDX
	movl	$0, %EAX
	movl	$0, %EAX
	cmpl	%EAX, %EDI
	jne	main_bb24
main_bb23:
	movl	$0, %EAX
	cmpl	%EAX, %R15D
	jne	main_bb27
main_bb26:
	movl	$1, %EAX
	movl	%EAX, %R15D
main_bb22:
	movl	$10, %EAX
	cmpl	%EAX, %R15D
	jne	main_bb36
main_bb35:
	movl	$99, %EAX
	movl	%EAX, %EDI
	call	putchar
	movl	$0, %EAX
	movl	%EAX, %EDI
	call	putDigit
	movl	$0, %EAX
	movl	%EAX, %EDI
	call	putDigit
	movl	$108, %EAX
	movl	%EAX, %EDI
	call	putchar
main_bb34:
	movl	$10, %EAX
	movl	%EAX, %EDI
	call	putchar
	movl	$0, %EAX
main_bb47:
	popq	%R15
	popq	%R14
	ret
main_bb6:
	movl	$4, %EAX
	movl	%EAX, a(%RIP)
	jmp	main_bb4
main_bb33:
	movl	$3, %EAX
	movl	%EAX, %R15D
	jmp	main_bb22
main_bb30:
	movl	$0, %EAX
	cmpl	%EAX, %EDX
	jne	main_bb33
main_bb32:
	movl	$10, %EAX
	movl	%EAX, %R15D
main_bb31:
	jmp	main_bb22
main_bb27:
	movl	$0, %EAX
	cmpl	%EAX, %R14D
	jne	main_bb30
main_bb29:
	movl	$2, %EAX
	movl	%EAX, %R15D
main_bb28:
	jmp	main_bb22
main_bb24:
	movl	$0, %EAX
	movl	%EAX, %R15D
	jmp	main_bb22
main_bb36:
	movl	$98, %EAX
	movl	%EAX, %EDI
	call	putchar
	movl	$97, %EAX
	movl	%EAX, %EDI
	call	putchar
	movl	$100, %EAX
	movl	%EAX, %EDI
	call	putchar
	movl	$61, %EAX
	movl	%EAX, %EDI
	call	putchar
	movl	%R15D, %EDI
	call	printInt
	jmp	main_bb34
