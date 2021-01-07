package main_part;

import java.util.*;

import second_part.Competition;
import second_part.Grade;
import second_part.Notice;
import second_part.Users;

public class MainBody {
	public static List<Users>managerList=new ArrayList<Users>();
	public static List<Users>usersList=new ArrayList<Users>();
	public static List<Competition>competitionList=new ArrayList<Competition>();
	public static List<Grade>gradeList=new ArrayList<Grade>();
	public static List<Notice>noticeList=new ArrayList<Notice>();
	
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in); 
		System.out.println("***********����������Ϣ����ϵͳ***********");
		//��ز���������Ϣ���˺�
		//����Ա�˺�
		Users admi_trator=new Users();
		admi_trator.setName("BigBoss");	
		admi_trator.setPassword("66668888");
		managerList.add(admi_trator);
		
//		//�����˺�1
//		Users test_account=new Users();
//		test_account.setName("test1"); 
//		test_account.setPassword("123");
//		usersList.add(test_account);
//		
//		//���Ա���
//		Competition test_game=new Competition();
//		test_game.setName("mls");
//		competitionList.add(test_game);
//		  
//		//���Գɼ�1
//		Grade test_grade=new Grade();
//		test_grade.setCompetition(test_game);
//		test_grade.setUser(test_account);
//		test_grade.setGrade(60.5);
//		gradeList.add(test_grade);
//			  
//		//���Թ���
//		Notice test_notice=new Notice();
//		test_notice.setName("mls");
//		test_notice.setContent("mls");
//		noticeList.add(test_notice);
		
		
		System.out.println("��ѡ��������һ��������");
		System.out.println("\t1��ע��\t\t2����½");
		
		int option=input.nextInt();
		if(option==1) 
			register();
		else if(option==2) {
			System.out.println("----------------��½ҳ��----------------");
			System.out.println("��½ѡ�");
			System.out.println("\t1���û���½\t\t2������Ա��½");
			
			int option1=input.nextInt();
			if(option1==1) 
				userLogin();
			else if(option1==2) 
				managerLogin();
		}	
	}
	
	//ע��
	public static void register() {	
		Scanner input=new Scanner(System.in); 
		System.out.println("----------------ע��ҳ��----------------");
		String name=null;
		String password=null;
		boolean isExist=false;
		boolean flag=true;
		while(flag) {
			System.out.print("�����������û�����");
			name=input.nextLine();
			//�û���У��
			for(Users user:usersList) {
				if(user.getName().equals(name)) {
					System.out.println("���û����Ѵ���");
					System.out.println("��ѡ����һ������");
					System.out.println("\t1������ע��\t\t2���ص�������");
					int option=input.nextInt();
					if(option==1) 
						register();
					else if(option==2) 
						main(null);
				}
			}
			if(!isExist){
				System.out.print("�������������룺");
				password=input.nextLine();
				flag=false;
			}
		}		
			
			//���ݴ���
			Users user=new Users();
			user.setName(name);
			user.setPassword(password);
			usersList.add(user);
			
			System.out.println("ע��ɹ�!");
			System.out.println("��ѡ����һ������:");
			System.out.println("1����½");
			System.out.println("2������������");

			int option1 = input.nextInt();	
			if(option1==1) 
				userLogin();
			else if(option1==2) 
				main(null);
		}
	
	//�û���¼
	public static void userLogin() {
		Scanner input=new Scanner(System.in);
		System.out.println("---------------�û���½����----------------");
		String name=null;
		String password=null;
		System.out.print("�������û�����");
		name=input.nextLine();
		for(Users user:usersList) {
			if(user.getName().equals(name)){
				System.out.print("���������룺");
				password=input.nextLine();
				if(user.getPassword().equals(password)) {
					if(user.isAvalible()==true){
						System.out.println("��½�ɹ�");
						System.out.println("������ת���û�����.........");
						userPage();
					}
					else {
						System.out.println("���˺��ѱ����ã�����ʹ��");
					}
				}
				else {
					System.out.println("��½�������������˶�");
				}
			}
			else {
				System.out.println("�û�������������˶�");
			}
			break;
		}
		System.out.println("��������������............");
		main(null);
	}
	
	//�û���ҳ
	public static void userPage() {
		Scanner input=new Scanner(System.in);
		System.out.println("----------------�û��˽���----------------");
		System.out.println("��ѡ����һ��������:");
		System.out.println("\t1����������\t\t2�������ɼ���ѯ");
		System.out.println("\t3����������\t\t4������������");
		int option=input.nextInt();
		if(option==1) 
			gameRegister();
		else if(option==2) 
			scoreInquiry();
		else if(option==3) 
			competitionNotice();
		else if(option==4) 
			main(null);
	}
		
	//����
	public static void gameRegister() {
		Scanner input=new Scanner(System.in);
		System.out.println("----------------��������----------------");
		System.out.print("������Ҫ�μӵı�����");
		String name=input.nextLine();
		boolean isExist=false;
		Competition match = null;
		for(Competition competition:competitionList) {
			if(competition.getName().equals(name)) {
				isExist=true;
				match=competition;
			}
			else {
				System.out.println("�ñ��������ڣ�������ȷ��");
				System.out.println("������ת���û�����.........");
				userPage();
			}
		}
		if(isExist) {
			//���������Ϣ
			System.out.print("������Ҫ�μӱ������û���:");
			String username=input.nextLine();
			for(Users user:usersList) {
				if(user.getName().equals(username)) {
					if(match==null) {
						System.out.println("���������ڣ������Ƿ�������ȷ");
					}
					else {
						match.getUsersList().add(user);
						match.setNumber(match.getNumber()+1);
						System.out.println("���������ɹ�");
					}
				}
				else {
					System.out.println("�û������ڣ������Ƿ�������ȷ");
					System.out.println("�������ر�������.........");
					userPage();
				}
				break;
			}
			System.out.println("��Ҫ�����˻�������棬�밴1");
			int option=input.nextInt();
			if(option==1) 
				userPage();
		}
	}
	
	//�û������ɼ���ѯ
	public static void scoreInquiry() {
		Scanner input=new Scanner(System.in);
		List <Grade> scoreList = new ArrayList<Grade>() ;
		System.out.println("-------------�����ɼ���ѯ����--------------");
		System.out.print("��������Ҫ��ѯ�ı�����");
		String name=input.nextLine();
		boolean isExist=false;
		for(Grade score:gradeList) {
			if(score.getCompetition().getName().equals(name)) {
				isExist=true;
				scoreList.add(score);
			}
		}
		Collections.sort(scoreList);
			
		if(!isExist) {
			System.out.println("�ñ���������");
		}
		else {
			System.out.println("-------------�������а�--------------");
			System.out.println("����"+name+"���а�(ǰ10��)����:");
			int i=1;
			for(Grade gameScore3:scoreList) {
				if(i>10) {
					break;
				}
				System.out.println(gameScore3.getUser().getName()+"\t��"+i+"��:");
				i++;
			}
		}
		System.out.println("��ѡ����һ��������");
		System.out.println("\t1����ѯ��������\t\t2�������û��˽���");
		
		int option1=input.nextInt();
		if(option1==1) {
			System.out.print("��������Ҫ��ѯ���û���");
			String username2=input.nextLine();
			String username=input.nextLine();
			for(Grade score:scoreList) {
				if(score.getUser().getName().equals(username)) {
					System.out.println("\t���û��ĳɼ��ǣ�"+score.getGrade()+"\n\t���û��������ǣ�"+score.getRank()+1);
					break;
				}
				else {
					System.out.println("�û�δ�����μӸñ������û����������");
				}
			}
		}
		else if(option1==2) 
			userPage();
		System.out.println("��ѡ����һ��������");
		System.out.println("\t1��������ѯ\t\t2�������û��˽���");
		int option=input.nextInt();
		if(option==1) 
			scoreInquiry();
		else if(option==2) 
			userPage();
	}	


	//����
	public static void competitionNotice() {
		Scanner input=new Scanner(System.in);
		System.out.println("----------------�������----------------");
		System.out.println("�������棺");
		int i=1;
		for(Notice notice:noticeList) {
			System.out.println("����"+i+":");
			System.out.println("������Ŀ��"+notice.getName());
			System.out.println("�������ݣ�"+notice.getContent());
			i++;
		}
		System.out.println("��Ҫ�����û��˽��棬������1");
		int option = input.nextInt();	
		if(option==1) {
			System.out.println("������ת���û�����.........");
			userPage();
		}
	}
		
	//����Ա�˵�¼
	public static void managerLogin() {
		Scanner input=new Scanner(System.in);
		System.out.println("---------------����Ա��½����----------------");
		String username=null;
		String password=null;
		System.out.print("���������Ա�˺ţ�");
		username=input.nextLine();
		System.out.print("���������Ա���룺");
		password=input.nextLine();
		for(Users user:managerList) {
			if(user.getName().equals(username)){
				if(user.getPassword().equals(password)) {
					System.out.println("��½�ɹ�");
					System.out.println("������ת������Ա����.........");
					managerPage();
				}
				else {
					System.out.println("��½�������.........");
				}
			}
			else {
				System.out.println("����Ա�û����������.........");
			}
		}
		System.out.println("��ѡ����һ��������");
		System.out.println("\t1�����µ�½\t\t2������������");
		int option=input.nextInt();
		if(option==1) 
			managerLogin();
		else if(option==2) 
			main(null);
	}

	//����Ա��ҳ
	public static void managerPage() {
		Scanner input=new Scanner(System.in);
		System.out.println("----------------����Ա����----------------");
		System.out.println("��ѡ����һ��������");
		System.out.println("\t1���˻�����\t\t2���ɼ�����");
		System.out.println("\t3����������\t\t4���������");
		System.out.println("\t5������������");
		int option=input.nextInt();
		if(option==1) 
			userManage();
		else if(option==2) 
			gradeManage();
		else if(option==3) 
			gameManage();
        else if(option==4) 
        	noticeManage();
        else if(option==5) 
        	main(null);
	}
	
	//�˻�����
	public static void userManage() {
		Scanner input=new Scanner(System.in);
		System.out.println("---------------�˻��������----------------");
		System.out.println("��ѡ�����²������û��˻����й���");
		System.out.println("\t1���˻���ѯ\t\t2����������");
		System.out.println("\t3���˻�����\t\t4�����ع���Ա����");
		int option=input.nextInt();
		if(option==1) 
			userSelect();
		else if(option==2) 
			resetPassword();
		else if(option==3) 
			accountDisable();
        else if(option==4) 
        	managerPage();
	}
	
	//�˻���ѯ
	public static void userSelect() {
		Scanner input=new Scanner(System.in);
		System.out.println("---------------��ѯ����----------------");
		System.out.print("��������Ҫ��ѯ���û���");
		String username=input.nextLine();
		for(Users user:usersList) {
			if(user.getName().equals(username)) {
				System.out.println("���û���Ϣ���£�");
				System.out.println(user);
			}
			else {
				System.out.println("��ѯʧ�ܣ��޴��û�");
			}
			break;
		}
		System.out.println("��ѡ����һ��������");
		System.out.println("\t1��������ѯ\t\t2�������˻��������");
		int option=input.nextInt();
		if(option==1) 
			userSelect();
		else if(option==2) 
			userManage();
	}
	
	//��������
	public static void resetPassword() {
		Scanner input=new Scanner(System.in);
		System.out.println("---------------�����������----------------");
		System.out.print("��������Ҫ����������˺ţ�");
		String username=input.nextLine();
		for(Users user:usersList) {
			if(user.getName().equals(username)) {
				System.out.println("���ٴ�ȷ��");
				System.out.println("\t1��ȷ������\t\t2��ȡ������");
				int option=input.nextInt();
				if(option==1) {
					System.out.print("�����������룺");
					String password=input.next();
					user.setPassword(password);
					System.out.println("���óɹ�");
				}
				else if(option==2) {
					System.out.println("ȡ���ɹ�");
				}
				break;
			}
			//��ѯʧ��
			else {
				System.out.println("��ѯʧ�ܣ��޴��˺���Ϣ");
			}
		}
		System.out.println("��ѡ����һ��������");
		System.out.println("\t1����������\t\t2�������˻��������");
		int option=input.nextInt();
		if(option==1) 
			resetPassword();
		else if(option==2) 
			userManage();
	}
	
	//�˻�����
	public static void accountDisable() {
		Scanner input = new Scanner(System.in);
		System.out.println("---------------�˻����ý���----------------");
		System.out.println("��������Ҫ���õ��˻���");
		String username = input.nextLine();
		for(Users user:usersList) {
			if(user.getName().equals(username)) {
				System.out.println("���ٴ�ȷ��");
				System.out.println("\t1��ȷ�Ͻ���\t\t2��ȡ��");
				int option = input.nextInt();
				if(option == 1) {
					user.setAvalible(false);
					System.out.println("���óɹ�");
				}
				else {
					System.out.println("ȡ���ɹ�");	
				}
				break;
			}
			else {
				System.out.println("��ѯʧ�ܣ��޴��˺���Ϣ");
			}
		}
		System.out.print("��ѡ����һ��������");
		System.out.print("\t1����������\t\t2�������˻��������");
		int option=input.nextInt();
		if(option==1) 
			accountDisable();
		else if(option==2) 
			userManage();
	}
	
	//��������
	public static void gameManage() {
		Scanner input=new Scanner(System.in);
		System.out.println("---------------�����������----------------");
		System.out.println("��ѡ����һ��������");
		System.out.println("\t1����ӱ���\t\t2����ͣ����");
		System.out.println("\t3���������\t4�����ع���Ա����");
		int option=input.nextInt();
		if(option==1) 
			addGame();
		else if(option==2) 
			handleGame();
		else if(option==3) 
			selectRegister();
		else if(option==4) 
			managerPage();
	}
	
	//��ӱ���
	public static void addGame() {
		Scanner input=new Scanner(System.in);
		System.out.println("---------------������ӽ���----------------");
		System.out.print("��������ӵı������ƣ�");
		String name=input.nextLine();
		System.out.print("��������ӵı������ݣ�");
		String content=input.nextLine();
		System.out.println("���ٴ�ȷ�ϣ�");
		System.out.println("\t1��ȷ�����\t\t2��ȡ�����");
		int option =input.nextInt();
		if(option==1) {
			Competition competition=new Competition(name,content);
			competitionList.add(competition);
			System.out.println("������ӳɹ�!");
		}
		else if(option==2){
			System.out.println("ȡ���ɹ�");
		}
		System.out.println("��ѡ����һ��������");
		System.out.println("\t1��������ӱ���\t2�����ر����������");
		int option1=input.nextInt();
		if(option1==1) 
			addGame();
		else if(option1==2) 
			gameManage();
	}
	
	//��������������ͣ
	public static void handleGame() {
		Scanner input=new Scanner(System.in);
		System.out.println("---------------������ͣ����----------------");
		System.out.println("��ѡ����Ҫ��ͣ�ı��������ƣ�");
		String name=input.nextLine();
		for(Competition competition:competitionList) {
			if(competition.getName().equals(name)) {
				System.out.println("��ѡ����һ��������");
				System.out.println("\t1����������\t\t2��ֹͣ����");
				int option=input.nextInt();
				if(option == 1) {
					competition.setAvalible(true);
					System.out.println("���������ɹ�");
				}
				else if(option == 2) {
					competition.setAvalible(false);
					System.out.println("����ֹͣ�ɹ�");
				}
			}
			else {
				System.out.println("�ñ��������ڣ�����ϸ�˶�У��");
			}
		}
		System.out.println("��ѡ����һ��������");
		System.out.println("\t1��������ͣ����\t\t2�����ر����������");
		int option=input.nextInt();
		if(option==1) 
			handleGame();
		else if(option==2) 
			gameManage();
	}
	
	//������ѯ�������
	public static void selectRegister() {
		System.out.println("---------------������ѯ����----------------");
		System.out.print("��������Ҫ��ѯ�ı������ƣ�");
		Scanner input=new Scanner(System.in);
		String name=input.nextLine();
		System.out.println("---------------�����������----------------");
		for(Competition game:competitionList) {
			if(game.getName().equals(name)) {	
				System.out.println("������������"+game.getNumber());
				System.out.println("�����û����飺");
				for(Users user:game.getUsersList()) {
					System.out.println(user);
				}
			}
			else {
				System.out.println("�ñ���������");
			}
			break;
		}
		System.out.println("");
		System.out.println("��ѡ����һ��������");
		System.out.println("\t1��������ѯ\t\t2�����ر����������");
		int option=input.nextInt();
		if(option==1) 
			selectRegister();
		else if(option==2) 
			gameManage();
	}
	
	//�ɼ�����
	public static void gradeManage() {
		Scanner input=new Scanner(System.in);
		System.out.println("---------------�ɼ��������----------------");
		System.out.println("��ѡ����һ��������");
		System.out.println("\t1���ɼ�¼��\t2�����˳ɼ�������");
		System.out.println("\t3�������а�\t4�����ع���Ա��ҳ");
		int option =input.nextInt();
		if(option==1) 
			addGrade();	
		else if(option==2) 
			selectGrade();
		else if(option==3) 
			selectRank();
		else if(option==4) 
			managerPage();
	}
		
	//¼��ɼ�
	public static void addGrade() {
	Scanner input=new Scanner(System.in);
	System.out.println("---------------�ɼ�¼�����----------------");
	System.out.print("������������ƣ�");
	String name=input.nextLine();
	for(Competition game:competitionList) {		
		if(game.getName().equals(name)) {				
			System.out.print("�������û�����");
			String username=input.nextLine();
			for(Users user:usersList) {
				if(user.getName().equals(username)) {
					System.out.print("��������û��ĳɼ���");
					double grade=input.nextDouble();
					System.out.println("���ٴ�ȷ�ϣ�");
					System.out.println("\t1��ȷ��¼��\t\t2��ȡ��¼��");
					int option=input.nextInt();
					if(option==1) {
						Grade gameScore=new Grade();
						gameScore.setCompetition(game);
						gameScore.setUser(user);
						gameScore.setGrade(grade);
						gradeList.add(gameScore);
						System.out.println("�ɼ�¼��ɹ�");										
					}
					else if(option==2) {	
						System.out.println("ȡ���ɹ�");	
					}	
					break;	
				}
				else {		
					System.out.println("���û�������");	
				}	
			}	
		}		
		else {	
			System.out.println("�ñ���������!");
		}	
	}
	System.out.println("��ѡ����һ��������");
	System.out.println("\t1������¼��ɼ�\t\t2�����سɼ��������");
	int option1=input.nextInt();
	if(option1==1) 
		addGrade();
	else if(option1==2) 
		gradeManage();	
	}
		
	//��ѯ�˶�Ա�ɼ�������
	public static void selectGrade() {
		Scanner input=new Scanner(System.in);
		List <Grade> Grade = new ArrayList<Grade>() ;
		System.out.println("---------------�ɼ���ѯ����----------------");
		System.out.print("��������������ƣ�");
		String name=input.nextLine();
		for(Grade score2:gradeList) {
			if(score2.getCompetition().getName().equals(name)) {
				Grade.add(score2);
				Collections.sort(Grade);
				System.out.print("������Ҫ��ѯ���û���");
				String username=input.nextLine();
				for(Grade score3:Grade) {
					if(score3.getUser().getName().equals(username)) {
						System.out.println("��ѯ�ɹ�");
						System.out.println("���û��ĳɼ���:"+score3.getGrade()+" ������:"+"��"+score3.getRank()+"��");
					}
					else {
						System.out.println("���û�������");
					}
				}
			}
			else {
				System.out.println("�ñ���������");
			}
		}
		System.out.print("��ѡ����һ��������");
		System.out.print("\t1������¼��ɼ�\t\t2�����سɼ��������");
		int option=input.nextInt();
		if(option==1) 
			selectGrade();
		else if(option==2) 
			gradeManage();
	}
		
	//��ѯ������	
	public static void selectRank() {
		Scanner input=new Scanner(System.in);
		List <Grade> gameScore = new ArrayList<Grade>() ;
		System.out.println("---------------�����в�ѯ����----------------");
		System.out.println("������Ҫ��ѯ�ı�����");
		String name=input.nextLine();
		for(Grade gameScore2:gradeList) {
			if(gameScore2.getCompetition().getName().equals(name)) {
				gameScore.add(gameScore2);
				Collections.sort(gameScore);
				System.out.println("����"+name+"���а�");
				for(Grade gameScore3:gameScore) {
					System.out.println(gameScore3.getUser().getName()+"\t��"+gameScore3.getRank()+"��:");
				}
			}
			else {
				System.out.println("�ñ���������");
			}
		}
		System.out.println("���Ҫ���سɼ�������棬������1");
		int option=input.nextInt();
		if(option==1) 
			gradeManage();
	}	

	
	//�����������
	public static void noticeManage() {
		Scanner input=new Scanner(System.in);
		System.out.println("---------------�����������----------------");
		System.out.println("��������²����Ա���֪ͨ���й���");
		System.out.println("\t1����ӹ���\t\t2�����ع���Ա����");
		int option=input.nextInt();
		if(option==1) 
			addNotice();
		else if(option==2) 
			managerPage();		
	}
	
	//��ӹ���
	public static void addNotice() {
		Scanner input=new Scanner(System.in);
		System.out.println("---------------������ӽ���----------------");
		System.out.print("�����빫�����ƣ�");
		String name=input.nextLine();
		
		System.out.print("�����빫�����ݣ�");
		String content=input.nextLine();
		System.out.println("���ٴ�ȷ�ϣ�");
		System.out.println("\t1��ȷ�����\t\t2��ȡ�����");
		int option =input.nextInt();
		if(option==1) {
			Notice notice=new Notice();
			notice.setName(name);
			notice.setContent(content);
			noticeList.add(notice);
			System.out.println("������ӳɹ�");
		}
		else {
			System.out.println("ȡ���ɹ�");
		}
		System.out.println("��ѡ����һ��������");
		System.out.println("\t1���������\t\t2�����ع���������");
		int option1=input.nextInt();
		if(option1==1) 
			addNotice();
		else if(option1==2) 
			noticeManage();
	}
}