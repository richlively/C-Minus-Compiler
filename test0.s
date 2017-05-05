.data
.comm	howdy,4,4

.text
	.align 4
.globl  main
main:
main_bb2:
main_bb3:
	movl	$2, %EAX
	movl	%EAX, %ESI
	movl	$2, %EAX
	cmpl	%EAX, %ESI
	jne	main_bb4
main_bb5:
	movl	$1, %EDI
	movl	%ESI, %EAX
	addl	%EDI, %EAX
main_bb4:
	movl	$0, %EAX
main_bb6:
	ret
