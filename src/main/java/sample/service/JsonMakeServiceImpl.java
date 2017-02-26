package sample.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sample.dto.Hoge;
import sample.dto.HogeList;
import sample.dto.PropertiesDto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Component
public class JsonMakeServiceImpl implements JsonMakeService {

	@Autowired
	private PropertiesDto propertiesDto;

	public List<Hoge> inputFile() throws FileNotFoundException,IOException{

		List<Hoge> existFileContent=new ArrayList<Hoge>();
		FileReader reader = new FileReader(new File(propertiesDto.inputFilePath));
		List<String> lines = IOUtils.readLines(reader);
		try{
			for (String line : lines) {
				if (StringUtils.indexOf(line, "=") == -1 ) {
					continue;
				}
				String tmp[] = StringUtils.split(line, "=");
				if (tmp.length == 2){
					Hoge hoge = new Hoge();
					hoge.id = Integer.parseInt(tmp[0]);
					hoge.name = tmp[1];
					existFileContent.add(hoge);
				}
			}
		}finally{
			IOUtils.closeQuietly(reader);
		}
		return existFileContent;
	}

	public String jsonMake() throws JsonProcessingException{

		//		System.out.println(propertiesDto.mbmpath);
		System.out.println(propertiesDto.inputFilePath);
		System.out.println(propertiesDto.outputFilePath);


		List<Hoge> list = new ArrayList<Hoge>();

		Hoge hoge = new Hoge();
		hoge.id = 10;
		hoge.name = "hoge";

		list.add(hoge);

		hoge = new Hoge();
		hoge.id = 10;
		hoge.name = "hoge";

		list.add(hoge);

		hoge = new Hoge();
		hoge.id = 10;
		hoge.name = "hoge";

		list.add(hoge);

		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		String json = mapper.writeValueAsString(list);

		HogeList hogeList = new HogeList();
		hogeList.list = list;
		json = mapper.writeValueAsString(hogeList.list);

		System.out.println(json);

		System.out.println("jsonMake");

		return json;

	}

	public void outputFile(String json) throws IOException{

		FileUtils.writeStringToFile(new File(propertiesDto.outputFilePath), json);

	}

}