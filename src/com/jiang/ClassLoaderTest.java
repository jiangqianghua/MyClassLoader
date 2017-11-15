package com.jiang;
/**
 * 测试java类的热加载
 * @author jiangqianghua
 *
 */
public class ClassLoaderTest {

	public static void main(String[] args) {
		new Thread(new MsgHandler()).start();
	}
}
