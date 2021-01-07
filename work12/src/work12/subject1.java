package work12;

import java.util.*;

public class subject1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		List<Books> bookList = new ArrayList<Books>();
		Map<Integer, Books> bookMap = new HashMap<Integer, Books>();
        System.out.print("�������鱾�������� ");
        int total = input.nextInt();
        for(int i = 0;i < total; i++){
        	int num;
            String name;
            double price;
            String press;
            
            num = input.nextInt();
            name = input.next();
            price = input.nextInt();
            press = input.next();
            
            Books x = new Books(num,name,price,press);
            bookList.add(x);
            bookMap.put(num,x);
        }
        for (Books book : bookList)
            System.out.println(book.toString());

	}
}

class Books {
    private int num;		//��ı��
    private String name;		//�������
    private double price;		//��ļ۸�
    private String press;		//��ĳ�����
    
    public Books(){
        super();
    }

    Books(int num, String name, double price, String press) {
        super();
        this.num = num;
        this.name = name;
        this.price = price;
        this.press = press;
    }

    int getNum() {
        return num;
    }

    String getName() {
        return name;
    }

    double getPrice() {
        return price;
    }

    String getPress() {
        return press;
    }
    
    @Override
    public String toString(){
        return "Books [��ţ�" + num + " ������ " + name + " ���ۣ�" + price
                + "  �����磺" + press + "]";
    }

}