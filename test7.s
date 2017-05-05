.data
.comm	a,4,4

.text
	.align 4
.globl  main
main:
main_bb2:
main_bb3:
	movl	$0, %EDI
	movl	%EDI, %EDX
	movl	$0, %EDI
	movl	%EDI, a(%RIP)
	movl	$5, %EDI
	cmpl	%EDI, %EDX
	jge	main_bb1
main_bb4:
	movl	$0, %EDI
	movl	%EDI, %ESI
	movl	$2, %EDI
	cmpl	%EDI, %ESI
	jge	main_bb7
	cmpl	$1, %EAX
	je	main_bb4
main_bb6:
	movl	a(%RIP), %EAX
	movl	$1, %EDI
	addl	%EDI, %EAX
	movl	%EAX, a(%RIP)
	movl	$1, %EDI
	movl	%ESI, %EAX
	addl	%EDI, %EAX
	movl	%EAX, %ESI
	movl	$2, %EAX
	cmpl	%EAX, %ESI
	jge	main_bb6
main_bb7:
	movl	$1, %EDI
	movl	%EDX, %EAX
	addl	%EDI, %EAX
	movl	%EAX, %EDX
	movl	$5, %EAX
	cmpl	%EAX, %EDX
	jge	main_bb9
main_bb8:
main_bb9:
main_bb1:
	ret
