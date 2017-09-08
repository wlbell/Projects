#include <iostream>
using namespace std;
template <class T>
struct node
{
        T  item;
        node<T> *next;
        node<T> *prev;
};
template <class T>
class linkedlist
{
public:
	class iterator
 	{       
        public: 
                iterator(node<T> *s):sent(s){}
		node<T>& iterpos(){return *sent;}
                node<T>* operator ++(){sent->next=sent->next->next;return sent;}//pre
                node<T>* operator ++(int ignore){sent->next=sent->next->next;return sent;}//post
                node<T>* operator --(){sent->next=sent->next->prev;return sent;}//pre
                node<T>* operator --(int ignore){sent->next=sent->next->prev;return sent;}//post
                T  operator *(){return sent->next->item;}//dereferance operator
                bool operator ==(const iterator iter){return (iter.sent == this->sent);}
        private:
                node<T> *sent = new node<T>;
       };

        linkedlist();
        linkedlist(const linkedlist &listobj);//copy constructor
        virtual ~linkedlist();//destructor
        void addfront(T n);//adds a node to front of list
        void addback(T n);//adds a node to the back of list
        T getfront(){return headnode->next->item;}//returns value at front of list
        T getback(){return headnode->prev->item;}//return value at back of list
        void removefront();//deletes a node at the front of the list
        void removeback();//deletes a node at the back of the list
        bool isempty(){return(headnode->next == headnode);} //returns true for empty list
        T search(T  n);//returns the node if found
        int size();//returns the size of the linked list
        linkedlist& operator = (const linkedlist &rightside);
	iterator frist(){iterator iter(headnode->next);return iter;}
	iterator last(){iterator iter(headnode->prev);return iter;}
	iterator any(node<T> nd){iterator iter(nd);return iter;}
private:
        node<T> *headnode = new node<T>;
};
///////////////////////
//linkedlist functons//
///////////////////////
template <class T>
linkedlist<T>::linkedlist()
{
        headnode->next = headnode;
        headnode->prev = headnode;
}
template <class T>
linkedlist<T>::linkedlist(const linkedlist &listobj)
{
        node <T>*tmp= new node<T>;
	headnode->next = headnode;
	headnode->prev = headnode;
	tmp->next = headnode;
	tmp->prev = listobj.headnode->next;
        while(tmp->prev != listobj.headnode)
        {
                node <T>*tmpn = new node<T>;
                tmpn->item = tmp->prev->item;
                tmpn->next = headnode;
                tmpn->prev = headnode->prev;
                tmpn->prev->next = tmpn;
                headnode->prev = tmpn;
                tmp->prev = tmp->prev->next;
        }
	tmp->prev = tmp;
	tmp->next = tmp;
	delete tmp;
}
template <class T>
linkedlist<T>::~linkedlist()
{
        node <T>*tmp = new node<T>;
        tmp->next = headnode->next;
        tmp->prev = headnode->prev;
        while(tmp->next != headnode)
        {
		tmp->next->prev = 0;
		tmp->next = tmp->next->next;
		tmp->prev->next = 0;
        }
         delete headnode;
}
template <class T>
linkedlist<T>& linkedlist<T>::operator = (const linkedlist<T> &rightside)
{
	node <T>tmp = *rightside.headnode;
        while(tmp.next != rightside.headnode)
       	{
                node <T>*tmpn = new node<T>;
		this->addfront(tmpn->item = tmp.next->item);
		tmp= *tmp.next;
        }
        return *this;
}
template <class T>
void linkedlist<T>::addfront(T n)
{
	node<T> *tmp = new node<T>;
	tmp->item = n;
	tmp->prev = headnode;
        tmp->next = headnode->next;
        headnode->next= tmp;
        tmp->next->prev = tmp;

}
template <class T>
void linkedlist<T>::addback(T n)
{
	node <T>*tmp = new node<T>;
	tmp->item = n;	
        tmp->next = headnode;
        tmp->prev = headnode->prev;
       	tmp->prev->next = tmp; 
        headnode->prev = tmp;
}
template <class T>
void linkedlist<T>::removefront()
{
        node <T>tmp  = *headnode->next;
        headnode->next = tmp.next;
        tmp.next->prev = headnode;
}
template <class T>
void linkedlist<T>::removeback()
{
        node <T>tmp = *headnode->prev;
        tmp.prev->next = headnode;
        headnode->prev = tmp.prev;
}
template <class T>
T linkedlist<T>::search(T n)
{
        node <T>tmp = *headnode;
        while(tmp.next != headnode)
        {
		if(tmp.next->item == n)
		{
			return tmp.next->item;
		}
                tmp = *tmp.next;
        }
}
template <class T>
int linkedlist<T>::size()
{
	node <T>tmp = *headnode;
	int count = 0;
        while(tmp.next != headnode)
        {
                count++;
		tmp = *tmp.next;
        }
        return count;
}

