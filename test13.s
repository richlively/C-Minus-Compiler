.text
	.align 4
.globl  main
main:
main_bb2:
	pushq	%R13
	pushq	%R14
	pushq	%R15
main_bb3:
	movl	$0, %EAX
	movl	%EAX, %R13D
	movl	$2, %EAX
	movl	%EAX, %R14D
	movl	$7, %EAX
	movl	%EAX, %R15D
	movl	$10, %EAX
	cmpl	%EAX, %R13D
	jge	main_bb5
main_bb4:
	movl	$5, %EAX
	movl	%EAX, %ESI
	movl	%R14D, %EAX
	addl	%R13D, %EAX
	cmpl	%ESI, %EAX
	jge	main_bb8
main_bb7:
	movl	$65, %EAX
	movl	%EAX, %EDI
	call	putchar
main_bb6:
	movl	$1, %EDI
	movl	%R13D, %EAX
	addl	%EDI, %EAX
	movl	%EAX, %R13D
	movl	$10, %EAX
	cmpl	%EAX, %R13D
	jl	main_bb4
main_bb5:
	cmpl	%R15D, %R13D
	je	main_bb15
main_bb16:
	movl	$0, %EAX
	movl	%EAX, %R13D
main_bb15:
	movl	%R13D, %EAX
main_bb17:
	popq	%R15
	popq	%R14
	popq	%R13
	ret
main_bb12:
	movl	$85, %EAX
	movl	%EAX, %EDI
	call	putchar
	jmp	main_bb6
main_bb8:
	movl	$2, %EDI
	movl	$0, %EDX
	movl	%R13D, %EAX
	idivl	%EDI, %EAX
	movl	%EAX, %EDI
	movl	%R15D, %EAX
	subl	%EDI, %EAX
	cmpl	%ESI, %EAX
	jge	main_bb12
main_bb11:
	movl	$75, %EAX
	movl	%EAX, %EDI
	call	putchar
main_bb10:
	jmp	main_bb6
