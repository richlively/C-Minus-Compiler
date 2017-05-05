.text
	.align 4
.globl  main
main:
main_bb2:
	pushq	%R15
main_bb3:
	movl	$0, %EAX
	movl	%EAX, %R15D
	movl	$1, %EDI
	movl	%R15D, %EAX
	addl	%EDI, %EAX
	movl	$50, %EAX
	movl	%EAX, %EDI
	call	putchar
	movl	$5, %EAX
	cmpl	%EAX, %R15D
	jge	main_bb6
main_bb5:
	movl	$0, %EAX
	movl	$5, %EAX
	cmpl	%EAX, %R15D
	jge	main_bb5
main_bb6:
	movl	$0, %EAX
main_bb7:
	popq	%R15
	ret
