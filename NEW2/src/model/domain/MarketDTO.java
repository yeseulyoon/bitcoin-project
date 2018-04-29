package model.domain;

public class MarketDTO {
	int index_no;
	String coin;
	String pairs;
	String prices;
	String volumes;
	public MarketDTO() {
		super();
	}
	public MarketDTO(int index_no, String coin, String pairs, String prices, String volumes) {
		super();
		this.index_no = index_no;
		this.coin = coin;
		this.pairs = pairs;
		this.prices = prices;
		this.volumes = volumes;
	}
	public int getIndexNo() {
		return index_no;
	}
	public void setIndexNo(int index_no) {
		this.index_no = index_no;
	}
	public String getCoins() {
		return coin;
	}
	public void setCoins(String coin) {
		this.coin = coin;
	}
	public String getPairs() {
		return pairs;
	}
	public void setPairs(String pairs) {
		this.pairs = pairs;
	}
	public String getPrices() {
		return prices;
	}
	public void setPrices(String prices) {
		this.prices = prices;
	}
	public String getVolumes() {
		return volumes;
	}
	public void setVolumes(String volumes) {
		this.volumes = volumes;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(index_no);
		builder.append(", coins=");
		builder.append(coin);
		builder.append(", pairs=");
		builder.append(pairs);
		builder.append(", prices=");
		builder.append(prices);
		builder.append(", volumes=");
		builder.append(volumes);
		return builder.toString();
	}
	
	
}
