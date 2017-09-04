package regex;

import vo.BlockVO;

public class Alpha implements Type{
	@Override
	public String get(BlockVO vo) {
		String ret = "[A-Z]";
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
