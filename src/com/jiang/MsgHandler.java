package com.jiang;
/**
 * 后台开启线程不断刷新重新加载实现类热加载
 * @author jiangqianghua
 *
 */
public class MsgHandler implements Runnable{

	@Override
	public void run() {
		while(true){
			BaseManager manager = ManagerFactory.getManager(ManagerFactory.MY_MANAGER);
			manager.logic();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
