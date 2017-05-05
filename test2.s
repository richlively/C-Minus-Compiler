.text
	.align 4
.globl  fact
fact:
fact_bb2:
	movl	%EDI, %EDX
fact_bb3:
	movl	$1, %EAX
	cmpl	%EAX, %EDX
	jle	fact_bb6
fact_bb5:
	movl	$1, %EDI
	movl	%EDX, %EAX
	subl	%EDI, %EAX
	movl	%EAX, %EDI
	movl	%EDX, %EAX
	imull	%ESI, %EAX
fact_bb9:
	ret
fact_bb6:
	movl	$1, %EAX
	jmp	fact_bb9
.globl  main
main:
main_bb2:
main_bb3:
	movl	%EDI, %ESI
	movl	$0, %EDI
	cmpl	%EDI, %ESI
	jle	main_bb8
main_bb6:
	movl	%ESI, %EDI
	movl	%EAX, %EDI
main_bb8:
	ret
