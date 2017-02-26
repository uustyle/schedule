package sample.dto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesDto {

//	@Value("${MBMPATH}")
//    public String mbmpath;

	@Value("${input.filePath}")
	public String inputFilePath;

    @Value("${output.filePath}")
    public String outputFilePath;
}
