package vo;

public class BlockVO {
	private Integer countryNo;
	private Integer no;
	private String type;
	private Integer[] length;
	private String[] charArr;
	
	public Integer getCountryNo() {
		return countryNo;
	}
	public void setCountryNo(Integer countryNo) {
		this.countryNo = countryNo;
	}
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer[] getLength() {
		return length;
	}
	public void setLength(Integer[] length) {
		this.length = length;
	}
	public String[] getCharArr() {
		return charArr;
	}
	public void setCharArr(String[] charArr) {
		this.charArr = charArr;
	}
}
