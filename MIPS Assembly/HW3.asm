 # Will Bell
# Homework #3 - Data Definitions
# February 11, 2015

# Base program for Homework #3

# Insert your data definitions after the .data assembler directive

	.data
first: .asciiz "will"
last: .asciiz "bell"
nod: .byte 10
nopp: .byte 10
pin: .word 123456789
dob: .word 19910515
gender: .ascii "m"
hight: .half 186
weight: .hal 91
pdc: .half 12345
ppc: .half 12345





# Make no changes below this comment line
	.text
main:
exit:	ori	$v0, $zero, 10
	syscall

