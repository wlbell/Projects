# $t1 =  counti
# $t2 =  consti
# $t3 =  countj
# $t4 =  collom order offset
# $t6 =  row order offset
# $t7 =  MxO and MxT
# $s0 = 0x10010000
# $s7 = $s0 + offset for row
# $s6 = $s0 + offset for coll
.data 
	MxO: .word  5 6 3 2 1 7 6 1 5 9 11 10 15 12 8 11
	MxT: .word  0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 #offset start at 0x10010040
	counti: .byte 0
	countj: .byte 0	
	consti: .byte 4
	constl: .byte 4
.text
main:
	lui $s0 0x1001
	lb $t1,136($s0) #counti 
	lb $t2,138($s0) #const	
loop:
	lb $t3,137($s0)#countj
	loop1:
		#row order
		
		sll $t6, $t1, 2
		add $t6, $t6, $t3
		sll $t6, $t6, 2
		add $s7, $s0, $t6 #add offset to mem
		lw $t7, 0($s7)
		#collom order
		#lb $t3, 0($s0)
		sll $t4, $t3, 2
		add $t4, $t4, $t1
		sll $t4, $t4, 2
		add $s6, $s0, $t4#add offset to mem
		sw  $t7, 64($s6)
		addi $t3, $t3, 1
		bne $t3,$t2 loop1
	addi $t1, $t1,1
	bne $t1, $t2, loop
exit:
	ori $v0, $zero,10
	syscall

