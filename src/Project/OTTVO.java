package Project;

public class OTTVO {
	
	private int idx;
	private String name;
	private String ott;
	private String genre;
	private int open;
	private String img;
	
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOtt() {
		return ott;
	}
	public void setOtt(String ott) {
		this.ott = ott;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getOpen() {
		return open;
	}
	public void setOpen(int open) {
		this.open = open;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "OTTVO [idx=" + idx + ", name=" + name + ", ott=" + ott + ", genre=" + genre + ", open=" + open + ", img="
				+ img + "]";
	}
}
