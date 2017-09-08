#include <iostream>
#include "linkedlist.cpp"
int main()
{
	linkedlist<int> *tmp= new linkedlist<int>;
	for(int x = 0 ; x<5;x++)
	{
		tmp->addback(x);
	}
	linkedlist<int>::iterator iter = tmp->frist();
	linkedlist<int>::iterator iter2 = tmp->frist();
	node<int> start = iter.iterpos();
	while(iter.iterpos().next != start.next->prev)
	{
		cout <<endl<<"++"<<*iter<<endl;
		iter++;
	}
	while(iter.iterpos().next !=start.next)
	{
		iter--;
		cout <<endl << "--"<< *iter<<endl;
	}
	cout << endl <<  "=="<<(iter == iter2)<<endl;
}
