package work7;

import java.util.GregorianCalendar;

public class UseGregorianCalendar {
	public static void main(String[] args) {
		GregorianCalendar time = new GregorianCalendar();
		int year = time.get(GregorianCalendar.YEAR);
		int month = time.get(GregorianCalendar.MONTH)+1;
		int day =  time.get(GregorianCalendar.DAY_OF_MONTH);
		System.out.println(year + "��" + month + "��" + day + "��");

		long num = 1234567898765L;
		time.setTimeInMillis(num);
		int year1 = time.get(GregorianCalendar.YEAR);
		int month1 = time.get(GregorianCalendar.MONTH)+1;
		int day1 =  time.get(GregorianCalendar.DAY_OF_MONTH);
		System.out.println(year1 + "��" + month1 + "��" + day1 + "��");
	}
}
