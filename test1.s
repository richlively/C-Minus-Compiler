.text
	.align 4
.globl  gcd
gcd:
gcd_bb2:
	movl	%EDI, %R8D
gcd_bb3:
	movl	$0, %EAX
	cmpl	%EAX, %ESI
	jne	gcd_bb6
gcd_bb5:
	movl	%R8D, %EAX
gcd_bb9:
	ret
gcd_bb6:
	movl	$0, %EDX
	movl	%R8D, %EAX
	idivl	%ESI, %EAX
	imull	%ESI, %EAX
	movl	%EAX, %EDI
	movl	%R8D, %EAX
	subl	%EDI, %EAX
	movl	%EAX, %ESI
	movl	%ESI, %EDI
	movl	%ECX, %EAX
	jmp	gcd_bb9
.globl  main
main:
main_bb2:
main_bb3:
	movl	%EDI, %ESI
	movl	%ESI, %EDI
	movl	%EAX, %EDI
main_bb7:
	ret
