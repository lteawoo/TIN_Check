package regex;

import vo.BlockVO;

public class Number implements Type{
	@Override
	public String get(BlockVO vo) {
		String ret = "[0-9]";
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
