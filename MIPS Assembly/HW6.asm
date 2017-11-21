#Will Bell homework 6
#$s0 upper imediate
#$t0 first floating point number from $f0
#$t1 second floating point number from $f0	
#$v0 system(MIPS) register
#$a0 system(MIPS) register 
#$ra system(MIPS) register	
	.data
	infloat1: .word 0
	infloat2: .word 0
	first: .asciiz "Enter a floating point number"
	second: .asciiz "Enter another floating point number"
	out: .asciiz "The two numbers entered were:\n"
	newline: .ascii "\n"
	.text
main:	
	lui $s0, 0x1001
	jal firstin
	jal secondin
	jal output
exit:
	li $v0,10
	syscall
firstin:
	#output
	li $v0, 4
	la $a0,first
	syscall
	#input
	li $v0, 6
	syscall
	mfc1 $t0,$f0
	sw $t0, 0($s0)
	jr $ra
secondin:
	#output
	li $v0, 4
	la $a0,second
	syscall
	#input
	li $v0, 6
	syscall
	mfc1 $t1,$f0
	sw $t1, 4($s0)
	jr $ra
output:
	#output prompt
	li $v0, 4
	la $a0,out
	syscall
	#output first
	mtc1 $t0,$f12
	li $v0, 2
	syscall
	#need a newline
	li $v0, 4
	la $a0,newline
	syscall
	#output second
	mtc1 $t1,$f12
	li $v0,2
	syscall
	jr $ra 
