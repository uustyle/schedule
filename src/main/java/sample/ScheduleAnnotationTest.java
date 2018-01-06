package sample;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import sample.config.ScheduleConfiguration;

public class ScheduleAnnotationTest {

	public static void main(String[] args) throws
	InterruptedException {
		AbstractApplicationContext context = new
				AnnotationConfigApplicationContext(ScheduleConfiguration.class);

//        while (true) {
//            try {
//                Thread.sleep(10000);  // sleep 100msec
//            } catch (InterruptedException e) {
//                break;
//            } finally {
////        		context.close();
//            }
//        }

//		context.close();
	}

}
