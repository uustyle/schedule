package sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample.service.JsonMakeService;

import com.fasterxml.jackson.core.JsonProcessingException;

public class JsonMakeRun {

	private static Logger log = LoggerFactory.getLogger(JsonMakeRun.class);

    public static void main(String[] args) throws JsonProcessingException{

    	log.info("Starting my application...");
        JsonMakeRun jsonMakeRun = new JsonMakeRun();
        jsonMakeRun.execute();
    }

    @SuppressWarnings("resource")
	public void execute() throws JsonProcessingException{
    	// BeanFactoryはApplicationContextに書替えてもOK
//        BeanFactory ctx = new ClassPathXmlApplicationContext(
//                "/sample/config/applicationContext.xml");

        BeanFactory ctx = new ClassPathXmlApplicationContext(
                "applicationContext.xml");

        JsonMakeService jsonMakeService = ctx.getBean(JsonMakeService.class);

        String json = jsonMakeService.jsonMake();

    }
}