package work7;

public class Watch {
	public static void main(String[] args) {
		StopWatch time = new StopWatch();
		int maxsize = 100000;
		int[] num = new int[maxsize];
		for(int i = 0; i < maxsize; i++)
			num[i] = (int)(Math.random()*1000);
		
		time.start();
		for(int i = 0; i < maxsize - 1; i++){
			for(int j = i+1; j < maxsize; j++){
				if(num[i] > num[j]){
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}
		time.stop();
		
		System.out.println("执行时间为：" + time.getElapsedTime() + " ms");
	}
}

class StopWatch{
	private long startTime;
	private long endTime;
	
	public StopWatch(){
		startTime = System.currentTimeMillis();
	}
	
	public void start(){
		startTime = System.currentTimeMillis();
	}
	
	public void stop(){
		endTime = System.currentTimeMillis();
	}
	
	public long getElapsedTime(){
		return endTime - startTime;
	}
}
