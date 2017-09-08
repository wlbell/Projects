#include <stdlib.h>
#include <stdio.h>
#include <crypt.h>
#include <string.h>
#include <omp.h>
double start;
void inc(char *c)
{
	if(c[0]=='~')
	{
       		c[0]='!';
        	inc(c+1);
    	}
    	c[0]++;



}
int main(void)
{
	int n =2; //key length
	int j;
	char *key = malloc((n+1)*sizeof(char));
	char *hash;
	char line[93];
	FILE *fr;
	fr = fopen("/home/will/Cracker/CS466Final/tmppass","rt");
	key[n]=0;
	start = omp_get_wtime();
	while(fgets(line,93,fr) != NULL)
	{
		int flag = 1;
		for(j=0;j<n;j++)
	        {
        	        key[j]='!';
        	}
		#pragma omp parallel num_threads(8)
		do	
		{
			hash =crypt(key,"$6$00");
			if(strcmp(hash,line) ==0)
			{
				printf("%s\n%s\n",hash,line);
				flag = 0;
				
			}
			inc(key);
		}while(flag ==1);
		//fgets(line,93,fr);
	}
	printf("It took::%fseconds\n\n",omp_get_wtime()-start);
	fclose(fr);
}


