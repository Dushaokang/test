package java实验二;

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
	prt("1 列出清单");
	prt("2 添加书籍");
	prt("3 搜索书籍");
	prt("4 删除书籍");
	prt("5 保存数据");
	prt("6 载入数据");
	prt("7 退出系统\n");
	prt("请输入需要执行的功能(1-7)");
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
			prt("欢迎下次使用\n");break;
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
	prt("请输入书名、作者、出版社、编号、价格、出版时间：");
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
		prt("数据保存在文件内");
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
		prt("已获取文件中数据");
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

