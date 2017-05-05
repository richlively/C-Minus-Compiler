.text
	.align 4
.globl  main
main:
main_bb2:
	pushq	%R15
main_bb3:
	movl	$0, %EAX
	movl	%EAX, %R15D
	movl	$10, %EAX
	cmpl	%EAX, %R15D
	jge	main_bb5
main_bb4:
	movl	$65, %EAX
	movl	%EAX, %EDI
	call	putchar
	movl	$1, %EDI
	movl	%R15D, %EAX
	addl	%EDI, %EAX
	movl	%EAX, %R15D
	movl	$10, %EAX
	cmpl	%EAX, %R15D
	jl	main_bb4
main_bb5:
	movl	$66, %EAX
	movl	%EAX, %EDI
	call	putchar
	movl	$0, %EAX
main_bb8:
	popq	%R15
	ret
