package regex;

import vo.BlockVO;

public class All implements Type{
	@Override
	public String get(BlockVO vo) {
		String ret = ".";
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
