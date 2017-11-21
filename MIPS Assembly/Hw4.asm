 
#Will Bell
#Homework 4
# y $t0
# w $t1
# x $t2
# z $t3
# c $t0
# d $t1
# f $t2
# a $t3
# bb $t4
# e $t5
# h $s0
# jj $s2
# k $s3
.data		   #offset	
	h: .word 0 #0-4
	jj: .word 0 #4-8
	k: .word 0 #8-12
	y: .half -24304 #12-14
	w: .half 17690 #14-16
	c: .half 4610 #16-18
	f: .half -13700 #18-20
	bb: .half 8872 #20-22
	x: .byte 74 #22-23
	z: .byte -46 #23-24
	d: .byte 124 #24-25
	a: .byte -88 #25-26
	e: .byte 62 #26-27

.text
	lui $s1 0x1001
	lh $t0,12($s1)
	lh $t1,14($s1)
	lb $t2,22($s1)
	lb $t3,23($s1)
	add $t0, $t0, $t1
	sub $s0, $t0, $t2
	add $s0, $s0, $t3
	sw $s0,0($s1)
	lh $t0,16($s1)
	lb $t1,24($s1)
	lh $t2,18($s1)
	lb $t3,25($s1)
	lh $t4,20($s1)
	lb $t5,26($s1)
	sub $t0, $t0,$t1
	add $t2, $t2, $t3
	add $t2, $t2, $t4
	sub $t2,$t2,$t5
	sub $s2,$t0,$t2
	sw $s2,4($s1)
	add $s3,$s0,$s2
	sw $s3, 8($s1)
main:
exit: ori $v0, $zero,10
	syscall
