#include <iostream>
#include <crypt.h>
#include <cstring>
using namespace std;
int main(void)
{
	char str1[4];
	for(int x = 0; x<10;x++)
	{
		cin >> str1;
		char *hash = crypt(str1,"$6$00");
		cout << hash <<endl;
	}
}

