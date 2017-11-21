#Will Bell homework 7
#$s0 upper imediate
#$t1 first floating point number from $f1
#$s1 second floating point number from $f2
#$t7 mask of floating point
#$t2 first floating point sign
#$t3 first floating point exp
#$t4 first floating point sig
#$s2 second floating point sign
#$s3 second floating point exp
#$s4 second floating point sig	
#$f12 product of floating point numbers
#$v0 system(MIPS) register
#$a0 system(MIPS) register 
#$ra system(MIPS) register	
	.data
	infloat1: .word 0 #0
	infloat2: .word 0 #4
	maskSign: .word 0x80000000 #8
	maskE: .word 0x7f800000 #12
	maskSigf: .word 0x007fffff #16
	first: .asciiz "Enter a floating point number"
	second: .asciiz "Enter another floating point number"
	out: .asciiz "The Product of the two numbers is:"
	newline: .ascii "\n"
	.text
main:	
	lui $s0, 0x1001
	jal input
	jal fmulti
	jal split
	jal output	
exit:	
	li $v0,10
	syscall
split:
	lw $t7,8($s0) #load bit mask for sign 
	#first float sign
	and $t2, $t1, $t7
	srl $t2, $t2,31
	#second float sign
	and $s2, $s1,$t7
	srl $s2, $s2, 31
	#first exp
	lw $t7, 12($s0) #load bit mask for exp
	and $t3, $t1, $t7
	srl $t3, $t3, 23
	#second
	and $s3,$s1,$t7
	srl $s3, $s3, 23
	#first sig
	lw $t7, 16($s0) #load bit mask for signifcant
	and $t4, $t1, $t7
	srl $t4, $t4, 9
	#second sig
	and $s4, $s1, $t7
	srl $s4, $s4, 9
	jr $ra
fmulti:
	mtc1 $t1,$f1
	mtc1 $s1, $f2
	mul.s $f12, $f1, $f2
	jr $ra
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
	la $a0,out
	syscall
	#output product
	li $v0, 2
	syscall
	jr $ra
 
