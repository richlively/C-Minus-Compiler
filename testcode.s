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
putDigit_bb4:
	ret
.globl  printInt
printInt:
printInt_bb2:
printInt_bb3:
	movl	$0, %EAX
	movl	%EAX, %ESI
	movl	$10000, %EAX
	cmpl	%EAX, %EDI
	jl	printInt_bb6
printInt_bb5:
	movl	$45, %EAX
	movl	%EAX, %EDI
	movl	$1, %EAX
	movl	%EAX, %EDI
printInt_bb11:
	movl	$1000, %ESI
	movl	$0, %EDX
	movl	%EDI, %EAX
	idivl	%ESI, %EAX
	movl	%EAX, %EDI
	movl	$1000, %ESI
	imull	%ESI, %EAX
	movl	%EAX, %ESI
	movl	%EDI, %EAX
	subl	%ESI, %EAX
	movl	%EAX, %EDI
	movl	$1, %EAX
	movl	%EAX, %ESI
printInt_bb10:
	movl	$100, %EAX
	cmpl	%EAX, %EDI
	jl	printInt_bb15
printInt_bb14:
	movl	$100, %ESI
	movl	$0, %EDX
	movl	%EDI, %EAX
	idivl	%ESI, %EAX
	movl	%EAX, %EDI
	movl	$100, %ESI
	imull	%ESI, %EAX
	movl	%EAX, %ESI
	movl	%EDI, %EAX
	subl	%ESI, %EAX
	movl	%EAX, %EDI
	movl	$1, %EAX
	movl	%EAX, %ESI
printInt_bb13:
	movl	$10, %EAX
	cmpl	%EAX, %EDI
	jl	printInt_bb22
printInt_bb18:
	movl	$0, %EAX
	movl	%EAX, %EDI
printInt_bb21:
	movl	$10, %ESI
	movl	$0, %EDX
	movl	%EDI, %EAX
	idivl	%ESI, %EAX
	movl	%EAX, %EDI
	movl	$10, %ESI
	imull	%ESI, %EAX
	movl	%EAX, %ESI
	movl	%EDI, %EAX
	subl	%ESI, %EAX
	movl	%EAX, %EDI
printInt_bb20:
printInt_bb25:
	movl	$0, %EAX
	movl	%EAX, %EDI
printInt_bb27:
	ret
printInt_bb15:
	movl	$1, %EAX
	cmpl	%EAX, %ESI
	jne	printInt_bb21
	jmp	printInt_bb13
printInt_bb22:
	movl	$1, %EAX
	cmpl	%EAX, %ESI
	jne	printInt_bb27
	jmp	printInt_bb20
printInt_bb6:
	movl	$1000, %EAX
	cmpl	%EAX, %EDI
	jl	printInt_bb10
	jmp	printInt_bb11
.globl  main
main:
main_bb2:
main_bb3:
	movl	$5, %EAX
	movl	%EAX, %R8D
	movl	%R8D, %ESI
	movl	$5, %EAX
	cmpl	%EAX, %ESI
	jne	main_bb6
main_bb5:
	movl	$3, %EAX
	movl	%EAX, a(%RIP)
main_bb4:
	movl	$0, %EAX
	movl	%EAX, %EDI
	movl	$1, %EAX
	movl	$8, %EDX
	cmpl	%EDX, %EAX
	jg	main_bb8
	addl	%EAX, %EDI
	movl	$1, %EDX
	addl	%EDX, %EAX
main_bb8:
	movl	$3, %R8D
	movl	$0, %EDX
	movl	%EDI, %EAX
	idivl	%R8D, %EAX
	movl	%EAX, %EDX
	movl	$4, %EDI
	movl	%EDX, %EAX
	imull	%EDI, %EAX
	movl	%EAX, %EDI
	movl	a(%RIP), %EAX
	movl	%EAX, %EDI
	movl	%ECX, %R8D
	movl	$56, %EAX
	movl	%EAX, %EDI
	movl	$61, %EAX
	movl	%EAX, %EDI
	movl	%R8D, %EAX
	addl	%EDI, %EAX
	movl	%EAX, %EDI
	movl	$10, %EAX
	movl	%EAX, %EDI
	movl	$0, %EAX
	movl	$10, %EDI
	cmpl	%EDI, %EAX
	jge	main_bb15
	movl	$48, %EDI
	addl	%EAX, %EDI
	movl	$1, %EDI
	addl	%EDI, %EAX
main_bb15:
	movl	$10, %EAX
	movl	%EAX, %EDI
	movl	$67, %EAX
	movl	%EAX, %EDI
	movl	$83, %EAX
	movl	%EAX, %EDI
	movl	$3510, %EAX
	movl	%EAX, %EDI
	movl	$10, %EAX
	movl	%EAX, %EDI
	movl	$0, %EAX
	movl	%EAX, %ESI
	movl	$1, %EAX
	movl	%EAX, %R8D
	movl	$1, %EAX
	movl	%EAX, %EDI
	movl	$0, %EAX
	movl	%EAX, %EDX
	movl	$0, %EAX
	movl	$0, %EAX
	cmpl	%EAX, %ESI
	jne	main_bb24
main_bb23:
	movl	$0, %EAX
	cmpl	%EAX, %R8D
	jne	main_bb27
main_bb26:
	movl	$1, %EAX
main_bb29:
	movl	$2, %EAX
main_bb32:
	movl	$10, %EAX
main_bb22:
	movl	$10, %EDI
	cmpl	%EDI, %EAX
	jne	main_bb36
main_bb35:
	movl	$99, %EAX
	movl	%EAX, %EDI
	movl	$0, %EAX
	movl	%EAX, %EDI
	movl	$0, %EAX
	movl	%EAX, %EDI
	movl	$108, %EAX
	movl	%EAX, %EDI
main_bb34:
	movl	$10, %EAX
	movl	%EAX, %EDI
	movl	$0, %EAX
main_bb47:
	ret
main_bb6:
	movl	$4, %EAX
	movl	%EAX, a(%RIP)
	jmp	main_bb4
main_bb33:
	movl	$3, %EAX
	jmp	main_bb22
main_bb30:
	movl	$0, %EAX
	cmpl	%EAX, %EDX
	jne	main_bb33
	jmp	main_bb32
main_bb27:
	movl	$0, %EAX
	cmpl	%EAX, %EDI
	jne	main_bb30
	jmp	main_bb29
main_bb24:
	movl	$0, %EAX
	jmp	main_bb22
main_bb36:
	movl	$98, %EDI
	movl	$97, %EDI
	movl	$100, %EDI
	movl	$61, %EDI
	movl	%EAX, %EDI
	jmp	main_bb34
