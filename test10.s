.text
	.align 4
.globl  main
main:
main_bb2:
	pushq	%R14
	pushq	%R15
main_bb3:
	movl	$5, %EAX
	movl	%EAX, %R14D
	movl	$1, %EAX
	movl	%EAX, %R15D
	movl	%R14D, %EAX
	addl	%R15D, %EAX
	cmpl	%R15D, %R14D
	jle	main_bb4
main_bb5:
	movl	$65, %EAX
	movl	%EAX, %EDI
	call	putchar
main_bb4:
	cmpl	%R15D, %R14D
	jge	main_bb9
main_bb8:
	movl	$66, %EAX
	movl	%EAX, %EDI
	call	putchar
main_bb7:
	movl	$5, %EAX
main_bb12:
	popq	%R15
	popq	%R14
	ret
main_bb9:
	movl	$67, %EAX
	movl	%EAX, %EDI
	call	putchar
	jmp	main_bb7
