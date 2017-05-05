.data
.comm	a,4,4

.text
	.align 4
.globl  main
main:
main_bb2:
main_bb3:
	movl	$0, %EAX
	movl	%EAX, %ECX
	movl	$1, %EAX
	movl	%EAX, %EDX
	movl	$1, %EAX
	movl	%EAX, %ESI
	movl	$0, %EAX
	movl	%EAX, %EDI
	movl	$0, %EAX
	movl	$0, %EAX
	cmpl	%EAX, %ECX
	jne	main_bb6
main_bb5:
	movl	$0, %EAX
	cmpl	%EAX, %EDX
	jne	main_bb9
main_bb8:
	movl	$1, %EAX
main_bb11:
	movl	$2, %EAX
main_bb14:
	movl	$10, %EAX
main_bb4:
	movl	$0, %EAX
main_bb16:
	ret
main_bb15:
	movl	$3, %EAX
	jmp	main_bb4
main_bb12:
	movl	$0, %EAX
	cmpl	%EAX, %EDI
	jne	main_bb15
	jmp	main_bb14
main_bb9:
	movl	$0, %EAX
	cmpl	%EAX, %ESI
	jne	main_bb12
	jmp	main_bb11
main_bb6:
	movl	$0, %EAX
	jmp	main_bb4
