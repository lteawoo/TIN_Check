package regex;

import vo.BlockVO;

public class YYMMDD implements Type{
	@Override
	public String get(BlockVO vo) {
		String ret = "([0-9]{2}(0[1-9]|1[0-2])(0[1-9]|[1,2][0-9]|3[0,1]))";
		ret += "{";
		for(int i = 0; i < vo.getLength().length; i++) {
			ret += vo.getLength()[i];
			if(vo.getLength().length-1 > i) 
				ret += ",";
		}
		ret += "}";
		return ret;
	}
}
