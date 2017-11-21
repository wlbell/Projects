#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <string.h>
char *command[256];
char *param[256]; 
void type_prompt()
{
	printf("BellShell>>");
}
int main()
{
	int status;
	char *path = getenv("PATH");
        char  pathenv[strlen(path) + sizeof("PATH=")];
        sprintf(pathenv, "PATH=%s", path);
        char *envp[] = {pathenv, NULL};

	while(1)
	{
		type_prompt();
		gets(command);
		char *token = strtok(command, " ");
		int i=0;
   		while( token != NULL ) 
   		{
      			param[i] = token;
			printf("%s\n",token);
      			token = strtok(NULL, " ");
			i++;
   		}
		if(fork() !=0)
		{
			waitpid(-1,&status,0);
		}
		else
		{
			execvpe(param[0], param, envp);
			char *param[256];
		}
	}
}
