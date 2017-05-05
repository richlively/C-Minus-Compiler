.data
.comm	a,4,4

.text
	.align 4
.globl  main
main:
main_bb2:
main_bb3:
	movl	$0, %EAX
	movl	%EAX, %EDI
	movl	$1, %EAX
	movl	%EAX, %ESI
	movl	$8, %EAX
	cmpl	%EAX, %ESI
	jg	main_bb5
	movl	%EDI, %EAX
	addl	%ESI, %EAX
	movl	$1, %EDI
	movl	%ESI, %EAX
	addl	%EDI, %EAX
main_bb5:
	movl	$0, %EAX
main_bb6:
	ret
