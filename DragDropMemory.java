import java.io.Serializable;
import java.util.ArrayList;


public class DragDropMemory implements Serializable {

	private String title;
	private String Url;
	private ArrayList<Box>  as;


	public DragDropMemory(String title, String url, ArrayList<Box> as) {
		super();
		this.title = title;
		Url = url;
		this.as = as;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	public ArrayList<Box> getAs() {
		return as;
	}
	public void setAs(ArrayList<Box> as) {
		this.as = as;
	}
}
