package sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:applicationContext_2.xml");
		MyTaskExecutor writer = (MyTaskExecutor) context
				.getBean(MyTaskExecutor.class);
		writer.printMessages();
		((AbstractApplicationContext) context).close();

	}

}
