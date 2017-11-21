#Will Bell homework 8
#$t1 first floating point number from $f1
#$t2 first floating point sign
#$t3 first floating point exp
#$t4 first floating point sig
#$t5 added exponents&&-127
#$t6 HI reg 
#$t7 masks
#####################
#$s1 second floating point number from $f2
#$s2 second floating point sign
#$s3 second floating point exp
#$s4 second floating point sig
#$s5 combined LO and HI
#$s7 LO reg
#####################
#$f12 product of floating point numbers
	
	.data
	infloat1: .word 0 #0
	infloat2: .word 0 #4
	floatprod: .word 0 #8
	maskSign: .word 0x80000000 #12
	maskE: .word 0x7f800000 #16
	maskSigf: .word 0x007fffff #20
	maskimpy: .word 0x01000000 #24
	first: .asciiz "Enter a floating point number"
	second: .asciiz "Enter another floating point number"
	outf: .asciiz "The Product of the two numbers using f-registers is:"
	outg: .asciiz "The Product of the two numbers using general-registers is:"
	newline: .ascii "\n"
	.text
main:	
	lui $s0, 0x1001
	jal input
	##muti using f-registers##
	mtc1 $t1,$f1
	mtc1 $s1, $f2
	mul.s $f12, $f1, $f2
	##split##
	lw $t7,12($s0) #load bit mask for sign 
	#float sign
	and $t2, $t1, $t7
	and $s2, $s1,$t7
	#exp
	lw $t7, 16($s0) #load bit mask for exp
	and $t3, $t1, $t7
	and $s3,$s1,$t7
	srl $t3, $t3, 23
	srl $s3, $s3, 23 
	#sig
	lw $t7, 20($s0) #load bit mask for signifcant
	and $t4, $t1, $t7
	and $s4, $s1, $t7
	lw $t7, 24($s0) #load bit mask for implied bit
	or $t4, $t4,$t7
	or $s4, $s4,$t7
	##muti using general regisrters##
	#add exponents and sub 127
	add $t5,$t3,$s3
	subi $t5,$t5,127
	#muti sigs
	mul $t6,$t4,$s4
	mfhi $t6
	mflo $s7
	sll $t6,$t6 16
	srl $s7,$s7, 16
	or $s5,$t6,$s7
	lw $t7, 12($s0)
	and $s6, $s5, $t7
	beq $s6, 1, norm
	srl $s5, $s5, 23
	xor $s5, $t1,$s1	
	#combining
	srl $t5,$t5,9
	lw $t7,24($s0)
	add $s5, $s5,$t7
	or $t5, $t5, $s5
	
	sw $s5, 8($s0)
	jal output
norm:
	srl $s5, $s5,1
	addi $t5, $t5,1
exit:	
	li $v0,10
	syscall
input:	
	li $v0, 4
	la $a0,first
	syscall
	li $v0, 6
	syscall
	mfc1 $t1,$f0
	sw $t1, 0($s0)
	#secondin
	li $v0, 4
	la $a0,second
	syscall
	li $v0, 6
	syscall
	mfc1 $s1,$f0
	sw $s1, 4($s0)
	jr $ra
output:
	#output prompt
	li $v0, 4
	la $a0,outf
	syscall
	#output product
	li $v0, 2
	syscall
	#output other product
	jr $ra
 
