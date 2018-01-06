package sample;

import org.springframework.core.task.TaskExecutor;

public class MyTaskExecutor {

	private TaskExecutor taskExecutor;

	public MyTaskExecutor(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	public void printMessages() {
		for (Integer i = 0; i < 5; i++) {
			taskExecutor.execute(new MyTask(i.toString()));
		}
	}

}
