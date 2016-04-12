package cn.aki.test;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import cn.aki.entity.User;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class FreemarkerTest {

	@Test
	public void initTest(){
		Configuration configuration=new Configuration(Configuration.VERSION_2_3_24);
		try {
			/*配置*/
			final String tempatePath="C:/Users/Aki/git/web/src/main/webapp/WEB-INF/template";
			configuration.setDirectoryForTemplateLoading(new File(tempatePath));
			configuration.setDefaultEncoding("utf-8");
			configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
			//不记录，抛出来
			configuration.setLogTemplateExceptions(false);
			/*model*/
			Map<String,Object> data=new HashMap<String, Object>();
			data.put("title", "freemarker测试模版");
			User user=new User();
			user.setUsername("username");
			user.setPassword("password");
			data.put("user", user);
			/*模版*/
			Template template=configuration.getTemplate("freemarkerTest.ftl");
			try {
				template.process(data, new OutputStreamWriter(System.err));
			} catch (TemplateException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
