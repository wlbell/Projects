a = [];
function two_out = two(a)
  two_out = (a(1,1)*a(2,2)) - (a(1,2)*a(2,1));
end
function three_out = three(a)
  x = a(1,1);
  y = -a(1,2);
  z = a(1,3);
  c1 = a(2:3,2:3);
  c2 = a([2,8;3,9]);
  c3 = a(2:3,1:2);
  three_out = x*two(c1) + y*two(c2) + z*two(c3);
end
function four_out = four(a)
  w = a(1,1);
  x = -a(1,2);
  y = a(1,3);
  z = -a(1,4);
  c1 = a(2:4,2:4);
  c2 = a([2 10 14;3 11 15;4 12 16]);
  c3 = a([2 6 14; 3 7 15; 4 8 16]);
  c4 = a(2:4,1:3);
  four_out = w*three(c1)+x*three(c2) + y*three(c3) + z*three(c4);
end  
prompt = 'Enter a nxn matrix(max 4x4)';
A = input(prompt);
[m,n] = size(A);
if(m == 2)
  two(A)
end
if(m == 3)
  three(A)
end
if(m == 4)
  four(A)
end
