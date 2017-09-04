import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import regex.Type;
import vo.BlockVO;
import vo.CountryVO;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Check {
	public static void main(String[] args) {
		//�Է��� ����, TIN �ΰ�..
		//������ ���˰� ��ϴ� �ڸ��� ����� ������ ��ƾ��Ѵ�.
		//����üũ.. X-XXXXXX-X..
		//��üũ.. 1�� 2�� 3��...(������������ ���̰� �´���?)
		//üũ��
		
		Integer country = 1;
//		String str = "930410-1234567";
		String str = "F-123456-D";
		Check c = new Check();
		c.vaild(str, country);
	}
	
	public void vaild(String s, Integer no) {
		StringBuffer pattern = new StringBuffer();
		List<BlockVO> blockList = getBlocks(no);
		
		for(BlockVO vo : blockList) {
			if(vo.getCharArr().length > 0) {
				pattern.append("[");
				for(String str : vo.getCharArr()) {
					pattern.append(str);
				}
				pattern.append("]");
			} else {
				try {
					Class<?> regexClass = Class.forName("regex." + vo.getType());
					pattern.append(regexClass.getDeclaredMethod("get", BlockVO.class).invoke(regexClass.newInstance(), vo));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(pattern);
		System.out.println(s + " : " + Pattern.matches(pattern.toString(), s));
	}
	
	public CountryVO getCountry(Integer no) {
		ObjectMapper mapper = new ObjectMapper();
		List<CountryVO> jsonList = null;
		try {
			jsonList = mapper.readValue(new File(this.getClass().getResource("json/country.json").getPath()), 
					new TypeReference<List<CountryVO>>() {});
			for(CountryVO vo : jsonList) {
				if(vo.getNo() == no) {
					return vo;
				}
			}
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<BlockVO> getBlocks(Integer countryNo) {
		ObjectMapper mapper = new ObjectMapper();
		List<BlockVO> jsonList = null;
		List<BlockVO> result = new ArrayList<BlockVO>();
		try {
			jsonList = mapper.readValue(new File(this.getClass().getResource("json/block.json").getPath()), 
					new TypeReference<List<BlockVO>>() {});
			for(BlockVO vo : jsonList) {
				if(vo.getCountryNo() == countryNo) {
					result.add(vo);
				}
			}
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
