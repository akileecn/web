package cn.aki.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 日志框架
 * @author aki
 * 2016年4月11日 上午10:27:41
 */
public class Slf4jTest {
	public static void main(String[] args) {
		Logger logger=LoggerFactory.getLogger(Slf4jTest.class);
		logger.info("hello {}","world");
	}
}
