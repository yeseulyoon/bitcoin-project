package model.domain;

public class TablesDTO {
	int indexNo;
	String close;
	String date;
	String high;
	String low;
	String open;
	String volume;
	
	public TablesDTO() {
		super();
	}
	public TablesDTO(int indexNo, String close, String date, String high, String low, String open, String volume) {
		super();
		this.indexNo = indexNo;
		this.close = close;
		this.date = date;
		this.high = high;
		this.low = low;
		this.open = open;
	}
	
	public int getIndex_no() {
		return indexNo;
	}
	public void setIndex_no(int indexNo) {
		this.indexNo = indexNo;
	}
	public String getClose() {
		return close;
	}
	public void setClose(String close) {
		this.close = close;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHigh() {
		return high;
	}
	public void setHigh(String high) {
		this.high = high;
	}
	public String getLow() {
		return low;
	}
	public void setLow(String low) {
		this.low = low;
	}
	public String getOpen() {
		return open;
	}
	public void setOpen(String open) {
		this.open = open;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(indexNo);
		builder.append(",close=");
		builder.append(close);
		builder.append(",date=");
		builder.append(date);
		builder.append(",high=");
		builder.append(high);
		builder.append(",low=");
		builder.append(low);
		builder.append(",open=");
		builder.append(open);
		return builder.toString();
	}
}
