package com.jiang;
/**
 * 封装加载类的信息
 * @author jiangqianghua
 *
 */
public class LoadInfo {
	// 自定义类加载
	private MyClassLoader myloader ;
	// 记录要加载类的时间错，－－ 加载的时间
	private long loadTime;
	
	private BaseManager manager ; 
	
	public LoadInfo(MyClassLoader myLoader , long loadTime) {
		super();
		this.myloader = myLoader ; 
		this.loadTime = loadTime;
	}
	
	public MyClassLoader getMyClassLoader(){
		return myloader;
	}

	public long getLoadTime() {
		return loadTime;
	}

	public void setLoadTime(long loadTime) {
		this.loadTime = loadTime;
	}

	public MyClassLoader getMyloader() {
		return myloader;
	}

	public void setMyloader(MyClassLoader myloader) {
		this.myloader = myloader;
	}

	public BaseManager getManager() {
		return manager;
	}

	public void setManager(BaseManager manager) {
		this.manager = manager;
	}
	
}
