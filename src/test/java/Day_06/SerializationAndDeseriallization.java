package Day_06;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Day_02.Pojo_Variable;

public class SerializationAndDeseriallization {
	
	
	@Test
	void pojo2Json() throws JsonProcessingException {
		//Creating java object by pojo class
		Pojo_Variable  data=new Pojo_Variable();
		data.setFirstname("RAJAN_01");
		data.setLastname("SETHI");
		data.setGender("male");
		data.setAge(28);
		data.setNumber("9996464204");
		
		//Converting java Object to Json Object
		ObjectMapper objMapper= new ObjectMapper();
		String jsondata=objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
		
		System.out.println(jsondata);
	}
	
	
	
	@Test
	void jsontoPojo() throws JsonMappingException, JsonProcessingException {
		
		String jsondata="{\r\n"
				+ "  \"firstname\" : \"RAJAN_01\",\r\n"
				+ "  \"lastname\" : \"SETHI\",\r\n"
				+ "  \"gender\" : \"male\",\r\n"
				+ "  \"age\" : 28,\r\n"
				+ "  \"number\" : \"9996464204\"\r\n"
				+ "}";
		ObjectMapper objMapper= new ObjectMapper();
		Pojo_Variable pojovar=objMapper.readValue(jsondata,Pojo_Variable.class );
		
		System.out.println(pojovar.getAge());
		System.out.println(pojovar.getFirstname());
		
	}

}
