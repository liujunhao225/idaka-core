package cn.com.idaka.core.mongodb.model;

public class FaqDiscuss implements java.io.Serializable {

	/**
	 * Default serialVersionUID.
	 */
	private final static long serialVersionUID = 1L;

    private String personId;
    private String personName;
    private String context;
    private String date;

	/** default constructor */
	public FaqDiscuss() {
	}

    public String getPersonId (){
		return personId;
    }

    public void setPersonId (String personId) {
		this.personId = personId;
    }

    public String getPersonName (){
		return personName;
    }

    public void setPersonName (String personName) {
		this.personName = personName;
    }

    public String getContext (){
		return context;
    }

    public void setContext (String context) {
		this.context = context;
    }

    public String getDate (){
		return date;
    }

    public void setDate (String date) {
		this.date = date;
    }

}
