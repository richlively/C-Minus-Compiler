.text
	.align 4
.globl  main
main:
main_bb2:
main_bb3:
	movl	$5, %EAX
	movl	%EAX, %ESI
	movl	$1, %EAX
	movl	%EAX, %EDI
	movl	$0, %EAX
	cmpl	%EAX, %ESI
	jle	main_bb6
main_bb5:
	movl	$65, %EAX
	movl	%EAX, %EDI
	call	putchar
main_bb4:
	movl	$68, %EAX
	movl	%EAX, %EDI
	call	putchar
main_bb9:
	movl	$66, %EAX
	movl	%EAX, %EDI
	call	putchar
main_bb13:
	ret
main_bb10:
	movl	$67, %EAX
	movl	%EAX, %EDI
	call	putchar
	jmp	main_bb13
main_bb6:
	movl	$1, %EAX
	cmpl	%EAX, %EDI
	jne	main_bb10
	jmp	main_bb4
