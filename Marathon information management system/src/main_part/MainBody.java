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
		System.out.println("***********马拉松赛信息管理系统***********");
		//相关测试内容信息和账号
		//管理员账号
		Users admi_trator=new Users();
		admi_trator.setName("BigBoss");	
		admi_trator.setPassword("66668888");
		managerList.add(admi_trator);
		
//		//测试账号1
//		Users test_account=new Users();
//		test_account.setName("test1"); 
//		test_account.setPassword("123");
//		usersList.add(test_account);
//		
//		//测试比赛
//		Competition test_game=new Competition();
//		test_game.setName("mls");
//		competitionList.add(test_game);
//		  
//		//测试成绩1
//		Grade test_grade=new Grade();
//		test_grade.setCompetition(test_game);
//		test_grade.setUser(test_account);
//		test_grade.setGrade(60.5);
//		gradeList.add(test_grade);
//			  
//		//测试公告
//		Notice test_notice=new Notice();
//		test_notice.setName("mls");
//		test_notice.setContent("mls");
//		noticeList.add(test_notice);
		
		
		System.out.println("请选择您的下一步操作：");
		System.out.println("\t1、注册\t\t2、登陆");
		
		int option=input.nextInt();
		if(option==1) 
			register();
		else if(option==2) {
			System.out.println("----------------登陆页面----------------");
			System.out.println("登陆选项：");
			System.out.println("\t1、用户登陆\t\t2、管理员登陆");
			
			int option1=input.nextInt();
			if(option1==1) 
				userLogin();
			else if(option1==2) 
				managerLogin();
		}	
	}
	
	//注册
	public static void register() {	
		Scanner input=new Scanner(System.in); 
		System.out.println("----------------注册页面----------------");
		String name=null;
		String password=null;
		boolean isExist=false;
		boolean flag=true;
		while(flag) {
			System.out.print("请输入您的用户名：");
			name=input.nextLine();
			//用户名校验
			for(Users user:usersList) {
				if(user.getName().equals(name)) {
					System.out.println("该用户名已存在");
					System.out.println("请选择下一步操作");
					System.out.println("\t1、重新注册\t\t2、回到主界面");
					int option=input.nextInt();
					if(option==1) 
						register();
					else if(option==2) 
						main(null);
				}
			}
			if(!isExist){
				System.out.print("请输入您的密码：");
				password=input.nextLine();
				flag=false;
			}
		}		
			
			//数据存入
			Users user=new Users();
			user.setName(name);
			user.setPassword(password);
			usersList.add(user);
			
			System.out.println("注册成功!");
			System.out.println("请选择下一步操作:");
			System.out.println("1、登陆");
			System.out.println("2、返回主界面");

			int option1 = input.nextInt();	
			if(option1==1) 
				userLogin();
			else if(option1==2) 
				main(null);
		}
	
	//用户登录
	public static void userLogin() {
		Scanner input=new Scanner(System.in);
		System.out.println("---------------用户登陆界面----------------");
		String name=null;
		String password=null;
		System.out.print("请输入用户名：");
		name=input.nextLine();
		for(Users user:usersList) {
			if(user.getName().equals(name)){
				System.out.print("请输入密码：");
				password=input.nextLine();
				if(user.getPassword().equals(password)) {
					if(user.isAvalible()==true){
						System.out.println("登陆成功");
						System.out.println("即将跳转至用户界面.........");
						userPage();
					}
					else {
						System.out.println("该账号已被禁用，不可使用");
					}
				}
				else {
					System.out.println("登陆密码错误，请认真核对");
				}
			}
			else {
				System.out.println("用户名错误，请认真核对");
			}
			break;
		}
		System.out.println("即将返回主界面............");
		main(null);
	}
	
	//用户首页
	public static void userPage() {
		Scanner input=new Scanner(System.in);
		System.out.println("----------------用户端界面----------------");
		System.out.println("请选择下一步操作：:");
		System.out.println("\t1、比赛报名\t\t2、比赛成绩查询");
		System.out.println("\t3、比赛公告\t\t4、返回主界面");
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
		
	//报名
	public static void gameRegister() {
		Scanner input=new Scanner(System.in);
		System.out.println("----------------报名界面----------------");
		System.out.print("请输入要参加的比赛：");
		String name=input.nextLine();
		boolean isExist=false;
		Competition match = null;
		for(Competition competition:competitionList) {
			if(competition.getName().equals(name)) {
				isExist=true;
				match=competition;
			}
			else {
				System.out.println("该比赛不存在，请重新确认");
				System.out.println("即将跳转至用户界面.........");
				userPage();
			}
		}
		if(isExist) {
			//输入个人信息
			System.out.print("请输入要参加比赛的用户名:");
			String username=input.nextLine();
			for(Users user:usersList) {
				if(user.getName().equals(username)) {
					if(match==null) {
						System.out.println("比赛不存在，请检查是否输入正确");
					}
					else {
						match.getUsersList().add(user);
						match.setNumber(match.getNumber()+1);
						System.out.println("比赛报名成功");
					}
				}
				else {
					System.out.println("用户不存在，请检查是否输入正确");
					System.out.println("即将返回报名界面.........");
					userPage();
				}
				break;
			}
			System.out.println("若要返回账户管理界面，请按1");
			int option=input.nextInt();
			if(option==1) 
				userPage();
		}
	}
	
	//用户比赛成绩查询
	public static void scoreInquiry() {
		Scanner input=new Scanner(System.in);
		List <Grade> scoreList = new ArrayList<Grade>() ;
		System.out.println("-------------比赛成绩查询界面--------------");
		System.out.print("请输入您要查询的比赛：");
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
			System.out.println("该比赛不存在");
		}
		else {
			System.out.println("-------------比赛排行榜--------------");
			System.out.println("比赛"+name+"排行榜(前10名)如下:");
			int i=1;
			for(Grade gameScore3:scoreList) {
				if(i>10) {
					break;
				}
				System.out.println(gameScore3.getUser().getName()+"\t第"+i+"名:");
				i++;
			}
		}
		System.out.println("请选择下一步操作：");
		System.out.println("\t1、查询个人排名\t\t2、返回用户端界面");
		
		int option1=input.nextInt();
		if(option1==1) {
			System.out.print("请输入您要查询的用户：");
			String username2=input.nextLine();
			String username=input.nextLine();
			for(Grade score:scoreList) {
				if(score.getUser().getName().equals(username)) {
					System.out.println("\t该用户的成绩是："+score.getGrade()+"\n\t该用户的排名是："+score.getRank()+1);
					break;
				}
				else {
					System.out.println("用户未报名参加该比赛或用户名输入错误");
				}
			}
		}
		else if(option1==2) 
			userPage();
		System.out.println("请选择下一步操作：");
		System.out.println("\t1、继续查询\t\t2、返回用户端界面");
		int option=input.nextInt();
		if(option==1) 
			scoreInquiry();
		else if(option==2) 
			userPage();
	}	


	//公告
	public static void competitionNotice() {
		Scanner input=new Scanner(System.in);
		System.out.println("----------------公告界面----------------");
		System.out.println("比赛公告：");
		int i=1;
		for(Notice notice:noticeList) {
			System.out.println("公告"+i+":");
			System.out.println("公告题目："+notice.getName());
			System.out.println("公告内容："+notice.getContent());
			i++;
		}
		System.out.println("若要返回用户端界面，请输入1");
		int option = input.nextInt();	
		if(option==1) {
			System.out.println("即将跳转至用户界面.........");
			userPage();
		}
	}
		
	//管理员端登录
	public static void managerLogin() {
		Scanner input=new Scanner(System.in);
		System.out.println("---------------管理员登陆界面----------------");
		String username=null;
		String password=null;
		System.out.print("请输入管理员账号：");
		username=input.nextLine();
		System.out.print("请输入管理员密码：");
		password=input.nextLine();
		for(Users user:managerList) {
			if(user.getName().equals(username)){
				if(user.getPassword().equals(password)) {
					System.out.println("登陆成功");
					System.out.println("即将跳转至管理员界面.........");
					managerPage();
				}
				else {
					System.out.println("登陆密码错误.........");
				}
			}
			else {
				System.out.println("管理员用户名输入错误.........");
			}
		}
		System.out.println("请选择下一步操作：");
		System.out.println("\t1、重新登陆\t\t2、返回主界面");
		int option=input.nextInt();
		if(option==1) 
			managerLogin();
		else if(option==2) 
			main(null);
	}

	//管理员首页
	public static void managerPage() {
		Scanner input=new Scanner(System.in);
		System.out.println("----------------管理员界面----------------");
		System.out.println("请选择下一步操作：");
		System.out.println("\t1、账户管理\t\t2、成绩管理");
		System.out.println("\t3、比赛管理\t\t4、公告管理");
		System.out.println("\t5、返回主界面");
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
	
	//账户管理
	public static void userManage() {
		Scanner input=new Scanner(System.in);
		System.out.println("---------------账户管理界面----------------");
		System.out.println("请选择以下操作对用户账户进行管理：");
		System.out.println("\t1、账户查询\t\t2、密码重置");
		System.out.println("\t3、账户禁用\t\t4、返回管理员界面");
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
	
	//账户查询
	public static void userSelect() {
		Scanner input=new Scanner(System.in);
		System.out.println("---------------查询界面----------------");
		System.out.print("请输入你要查询的用户：");
		String username=input.nextLine();
		for(Users user:usersList) {
			if(user.getName().equals(username)) {
				System.out.println("该用户信息如下：");
				System.out.println(user);
			}
			else {
				System.out.println("查询失败，无此用户");
			}
			break;
		}
		System.out.println("请选择下一步操作：");
		System.out.println("\t1、继续查询\t\t2、返回账户管理界面");
		int option=input.nextInt();
		if(option==1) 
			userSelect();
		else if(option==2) 
			userManage();
	}
	
	//重置密码
	public static void resetPassword() {
		Scanner input=new Scanner(System.in);
		System.out.println("---------------重置密码界面----------------");
		System.out.print("请输入你要重置密码的账号：");
		String username=input.nextLine();
		for(Users user:usersList) {
			if(user.getName().equals(username)) {
				System.out.println("请再次确认");
				System.out.println("\t1、确认重置\t\t2、取消重置");
				int option=input.nextInt();
				if(option==1) {
					System.out.print("请输入新密码：");
					String password=input.next();
					user.setPassword(password);
					System.out.println("重置成功");
				}
				else if(option==2) {
					System.out.println("取消成功");
				}
				break;
			}
			//查询失败
			else {
				System.out.println("查询失败，无此账号信息");
			}
		}
		System.out.println("请选择下一步操作：");
		System.out.println("\t1、继续重置\t\t2、返回账户管理界面");
		int option=input.nextInt();
		if(option==1) 
			resetPassword();
		else if(option==2) 
			userManage();
	}
	
	//账户禁用
	public static void accountDisable() {
		Scanner input = new Scanner(System.in);
		System.out.println("---------------账户禁用界面----------------");
		System.out.println("请输入您要禁用的账户：");
		String username = input.nextLine();
		for(Users user:usersList) {
			if(user.getName().equals(username)) {
				System.out.println("请再次确认");
				System.out.println("\t1、确认禁用\t\t2、取消");
				int option = input.nextInt();
				if(option == 1) {
					user.setAvalible(false);
					System.out.println("禁用成功");
				}
				else {
					System.out.println("取消成功");	
				}
				break;
			}
			else {
				System.out.println("查询失败，无此账号信息");
			}
		}
		System.out.print("请选择下一步操作：");
		System.out.print("\t1、继续禁用\t\t2、返回账户管理界面");
		int option=input.nextInt();
		if(option==1) 
			accountDisable();
		else if(option==2) 
			userManage();
	}
	
	//比赛管理
	public static void gameManage() {
		Scanner input=new Scanner(System.in);
		System.out.println("---------------比赛管理界面----------------");
		System.out.println("请选择下一步操作：");
		System.out.println("\t1、添加比赛\t\t2、启停比赛");
		System.out.println("\t3、报名情况\t4、返回管理员界面");
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
	
	//添加比赛
	public static void addGame() {
		Scanner input=new Scanner(System.in);
		System.out.println("---------------比赛添加界面----------------");
		System.out.print("请输入添加的比赛名称：");
		String name=input.nextLine();
		System.out.print("请输入添加的比赛内容：");
		String content=input.nextLine();
		System.out.println("请再次确认：");
		System.out.println("\t1、确认添加\t\t2、取消添加");
		int option =input.nextInt();
		if(option==1) {
			Competition competition=new Competition(name,content);
			competitionList.add(competition);
			System.out.println("比赛添加成功!");
		}
		else if(option==2){
			System.out.println("取消成功");
		}
		System.out.println("请选择下一步操作：");
		System.out.println("\t1、继续添加比赛\t2、返回比赛管理界面");
		int option1=input.nextInt();
		if(option1==1) 
			addGame();
		else if(option1==2) 
			gameManage();
	}
	
	//比赛启动或者暂停
	public static void handleGame() {
		Scanner input=new Scanner(System.in);
		System.out.println("---------------比赛启停界面----------------");
		System.out.println("请选择您要启停的比赛的名称：");
		String name=input.nextLine();
		for(Competition competition:competitionList) {
			if(competition.getName().equals(name)) {
				System.out.println("请选择下一步操作：");
				System.out.println("\t1、开启比赛\t\t2、停止比赛");
				int option=input.nextInt();
				if(option == 1) {
					competition.setAvalible(true);
					System.out.println("比赛开启成功");
				}
				else if(option == 2) {
					competition.setAvalible(false);
					System.out.println("比赛停止成功");
				}
			}
			else {
				System.out.println("该比赛不存在，请仔细核对校验");
			}
		}
		System.out.println("请选择下一步操作：");
		System.out.println("\t1、继续启停比赛\t\t2、返回比赛管理界面");
		int option=input.nextInt();
		if(option==1) 
			handleGame();
		else if(option==2) 
			gameManage();
	}
	
	//比赛查询报名情况
	public static void selectRegister() {
		System.out.println("---------------比赛查询界面----------------");
		System.out.print("请输入您要查询的比赛名称：");
		Scanner input=new Scanner(System.in);
		String name=input.nextLine();
		System.out.println("---------------比赛报名情况----------------");
		for(Competition game:competitionList) {
			if(game.getName().equals(name)) {	
				System.out.println("报名总人数："+game.getNumber());
				System.out.println("报名用户详情：");
				for(Users user:game.getUsersList()) {
					System.out.println(user);
				}
			}
			else {
				System.out.println("该比赛不存在");
			}
			break;
		}
		System.out.println("");
		System.out.println("请选择下一步操作：");
		System.out.println("\t1、继续查询\t\t2、返回比赛管理界面");
		int option=input.nextInt();
		if(option==1) 
			selectRegister();
		else if(option==2) 
			gameManage();
	}
	
	//成绩管理
	public static void gradeManage() {
		Scanner input=new Scanner(System.in);
		System.out.println("---------------成绩管理界面----------------");
		System.out.println("请选择下一步操作：");
		System.out.println("\t1、成绩录入\t2、个人成绩和排名");
		System.out.println("\t3、总排行榜\t4、返回管理员首页");
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
		
	//录入成绩
	public static void addGrade() {
	Scanner input=new Scanner(System.in);
	System.out.println("---------------成绩录入界面----------------");
	System.out.print("请输入比赛名称：");
	String name=input.nextLine();
	for(Competition game:competitionList) {		
		if(game.getName().equals(name)) {				
			System.out.print("请输入用户名：");
			String username=input.nextLine();
			for(Users user:usersList) {
				if(user.getName().equals(username)) {
					System.out.print("请输入该用户的成绩：");
					double grade=input.nextDouble();
					System.out.println("请再次确认：");
					System.out.println("\t1、确认录入\t\t2、取消录入");
					int option=input.nextInt();
					if(option==1) {
						Grade gameScore=new Grade();
						gameScore.setCompetition(game);
						gameScore.setUser(user);
						gameScore.setGrade(grade);
						gradeList.add(gameScore);
						System.out.println("成绩录入成功");										
					}
					else if(option==2) {	
						System.out.println("取消成功");	
					}	
					break;	
				}
				else {		
					System.out.println("该用户不存在");	
				}	
			}	
		}		
		else {	
			System.out.println("该比赛不存在!");
		}	
	}
	System.out.println("请选择下一步操作：");
	System.out.println("\t1、继续录入成绩\t\t2、返回成绩管理界面");
	int option1=input.nextInt();
	if(option1==1) 
		addGrade();
	else if(option1==2) 
		gradeManage();	
	}
		
	//查询运动员成绩和排名
	public static void selectGrade() {
		Scanner input=new Scanner(System.in);
		List <Grade> Grade = new ArrayList<Grade>() ;
		System.out.println("---------------成绩查询界面----------------");
		System.out.print("请输入比赛的名称：");
		String name=input.nextLine();
		for(Grade score2:gradeList) {
			if(score2.getCompetition().getName().equals(name)) {
				Grade.add(score2);
				Collections.sort(Grade);
				System.out.print("请输入要查询的用户名");
				String username=input.nextLine();
				for(Grade score3:Grade) {
					if(score3.getUser().getName().equals(username)) {
						System.out.println("查询成功");
						System.out.println("该用户的成绩是:"+score3.getGrade()+" 排名是:"+"第"+score3.getRank()+"名");
					}
					else {
						System.out.println("该用户不存在");
					}
				}
			}
			else {
				System.out.println("该比赛不存在");
			}
		}
		System.out.print("请选择下一步操作：");
		System.out.print("\t1、继续录入成绩\t\t2、返回成绩管理界面");
		int option=input.nextInt();
		if(option==1) 
			selectGrade();
		else if(option==2) 
			gradeManage();
	}
		
	//查询总排行	
	public static void selectRank() {
		Scanner input=new Scanner(System.in);
		List <Grade> gameScore = new ArrayList<Grade>() ;
		System.out.println("---------------总排行查询界面----------------");
		System.out.println("请输入要查询的比赛：");
		String name=input.nextLine();
		for(Grade gameScore2:gradeList) {
			if(gameScore2.getCompetition().getName().equals(name)) {
				gameScore.add(gameScore2);
				Collections.sort(gameScore);
				System.out.println("比赛"+name+"排行榜：");
				for(Grade gameScore3:gameScore) {
					System.out.println(gameScore3.getUser().getName()+"\t第"+gameScore3.getRank()+"名:");
				}
			}
			else {
				System.out.println("该比赛不存在");
			}
		}
		System.out.println("如果要返回成绩管理界面，请输入1");
		int option=input.nextInt();
		if(option==1) 
			gradeManage();
	}	

	
	//比赛公告管理
	public static void noticeManage() {
		Scanner input=new Scanner(System.in);
		System.out.println("---------------比赛公告界面----------------");
		System.out.println("请进行以下操作对比赛通知进行管理：");
		System.out.println("\t1、添加公告\t\t2、返回管理员界面");
		int option=input.nextInt();
		if(option==1) 
			addNotice();
		else if(option==2) 
			managerPage();		
	}
	
	//添加公告
	public static void addNotice() {
		Scanner input=new Scanner(System.in);
		System.out.println("---------------公告添加界面----------------");
		System.out.print("请输入公告名称：");
		String name=input.nextLine();
		
		System.out.print("请输入公告内容：");
		String content=input.nextLine();
		System.out.println("请再次确认：");
		System.out.println("\t1、确认添加\t\t2、取消添加");
		int option =input.nextInt();
		if(option==1) {
			Notice notice=new Notice();
			notice.setName(name);
			notice.setContent(content);
			noticeList.add(notice);
			System.out.println("公告添加成功");
		}
		else {
			System.out.println("取消成功");
		}
		System.out.println("请选择下一步操作：");
		System.out.println("\t1、继续添加\t\t2、返回公告管理界面");
		int option1=input.nextInt();
		if(option1==1) 
			addNotice();
		else if(option1==2) 
			noticeManage();
	}
}