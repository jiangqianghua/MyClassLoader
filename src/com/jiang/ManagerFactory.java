package com.jiang;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ManagerFactory {

	// 记录热加载的加载信息
	private static final Map<String, LoadInfo> loadTimeMap = new HashMap<String, LoadInfo>();
	// 要加载类的classpath
	public static final String CLASS_PATH = "/Users/jiangqianghua/Documents/workspace/MyClassLoader/bin/";
	//  而加载的全名称
	public static final String MY_MANAGER = "com.jiang.MyManager";
	
	public static BaseManager getManager(String className){
		String path = CLASS_PATH+className.replaceAll("\\.","/")+".class" ; 
		File loadFile = new File(path);
		long lastModified = loadFile.lastModified();
		System.out.println("lastModified="+lastModified);
		if(loadTimeMap.get(className) == null){
			System.out.println("load null");
			load(className,lastModified);
		}
		else if(loadTimeMap.get(className).getLoadTime() != lastModified){
			// 加载类的时间错发现变化
			System.out.println("load time change");
			load(className, lastModified);
		}
		return loadTimeMap.get(className).getManager();
	}
	/**
	 * 加载到虚拟机
	 * @param className
	 * @param lastModified
	 */
	private static void load(String className, long lastModified) {
		MyClassLoader myClassLoader = new MyClassLoader(CLASS_PATH);
		Class<?> loadClass = null ;
		try {
			//loadClass = myClassLoader.loadClass(MY_MANAGER);
			loadClass = myClassLoader.findClass(MY_MANAGER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		BaseManager manager = newInstance(loadClass);
		LoadInfo loadInfo = new LoadInfo(myClassLoader, lastModified);
		loadInfo.setManager(manager);
		loadTimeMap.put(className, loadInfo);
	}
	/**
	 *反射方式实现BaseManager子类的对象
	 * @param loadClass
	 * @return
	 */
	private static BaseManager newInstance(Class<?> loadClass) {
	
		try {
			return (BaseManager)loadClass.getConstructor(new Class[]{}).newInstance(new Object[]{});
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null ;
	}
}
