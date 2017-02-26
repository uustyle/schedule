package sample;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;

import sample.service.JsonMakeService;

public class JsonMakeRun {

    public static void main(String[] args) throws JsonProcessingException{
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