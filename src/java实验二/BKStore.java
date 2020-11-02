package javaʵ���;

import java.util.*;
import java.io.*;
public class BKStore {
private ArrayList books = new ArrayList();
private final String fileName="D:\\mydata.data";
public void prt(String message)
{
	System.out.println(message);
}
public void menuInfo()
{
	int i;
	StringBuffer buf = new StringBuffer();
	for(i=0;i<60;i++)buf.append('*');
	prt(buf.toString()+"\n");
	prt("1 �г��嵥");
	prt("2 ����鼮");
	prt("3 �����鼮");
	prt("4 ɾ���鼮");
	prt("5 ��������");
	prt("6 ��������");
	prt("7 �˳�ϵͳ\n");
	prt("��������Ҫִ�еĹ���(1-7)");
	prt(buf.toString()+"\n");
}
public void menu()
{
	int op;
	Scanner ops=new Scanner(System.in);
	this.menuInfo();
	while(true)
	{
		op=ops.nextInt();
		if(op==7) 
		{
			prt("��ӭ�´�ʹ��\n");break;
		}
		switch(op)
		{
		case 1:this.prtListings();break;
		case 2:this.addNewBook();break;
		case 3:this.searchABook();break;
		case 4:this.deleteABook();break;
		case 5:this.save(this.fileName);break;
		case 6:this.loadData(this.fileName);break;
		case 7:break;
		}
		this.menuInfo();
	}
	
}
//Add a new book
public void addNewBook()
{
	String tit,aut,pub,isbn;
	float px;
	Date dt;
	long dtx;
	Scanner input = new Scanner(System.in);
	prt("���������������ߡ������硢��š��۸񡢳���ʱ�䣺");
	tit=input.nextLine();
	aut=input.nextLine();
	pub=input.nextLine();
	isbn=input.nextLine();
	px=input.nextFloat();	
	dtx=input.nextLong();
	dt=new Date(dtx);
	BOOK bk = new BOOK(isbn,tit,aut,pub,px,dt);
	this.books.add(bk);
}
public void prtListings()
{
	Iterator ptr=this.books.iterator();
	while(ptr.hasNext())
	{
		BOOK bk = (BOOK)ptr.next();
		bk.prtBK();
	}
}
//Save data
public void save(String fileName)
{
	try
	{
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(this.books);
		prt("���ݱ������ļ���");
		this.books.clear();
		oos.flush();
		fos.close();
		oos.close();
		
	}catch(Exception ex){ex.printStackTrace();}
}
//Load old data from the data file
public void loadData(String fileName)
{
	try
	{
		FileInputStream fos = new FileInputStream(fileName);
		ObjectInputStream oos = new ObjectInputStream(fos);
		ArrayList oldData=(ArrayList)oos.readObject();
		Iterator ptr=oldData.iterator();
		while(ptr.hasNext())
		{
			BOOK bk = (BOOK)ptr.next();
			this.books.add(bk);
		}
		prt("�ѻ�ȡ�ļ�������");
		fos.close();
		oos.close();
		
	}catch(Exception ex){ex.printStackTrace();}
}
//Search a book
public void searchABook()
{
	String isbn;
	boolean isFound=false;
	Scanner input = new Scanner(System.in);
	prt("Enter isbn:\n");
	isbn=input.nextLine();
	Iterator ptr = this.books.iterator();
	while(ptr.hasNext())
	{
		BOOK bk=(BOOK)ptr.next();
		if(bk.getIsbn().equalsIgnoreCase(isbn))
		{
			prt("Found:\n");
			bk.prtBK();
			isFound=true;
			break;
		}
	}
	if(!isFound)prt("Not found\n");
}
//Delete a book
//Search a book
public void deleteABook()
{
	String isbn;
	boolean isFound=false;
	Scanner input = new Scanner(System.in);
	prt("Enter isbn:\n");
	isbn=input.nextLine();
	Iterator ptr = this.books.iterator();
	while(ptr.hasNext())
	{
		BOOK bk=(BOOK)ptr.next();
		if(bk.getIsbn().equalsIgnoreCase(isbn))
		{
			prt("Deletd:\n");
			bk.prtBK();
			isFound=true;
			this.books.remove(bk);
			break;
		}
	}
	if(!isFound)prt("Not found\n");
}
	public static void main(String[] args) {
      new BKStore().menu();
	}

}

