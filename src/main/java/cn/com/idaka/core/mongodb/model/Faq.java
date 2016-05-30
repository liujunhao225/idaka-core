package cn.com.idaka.core.mongodb.model;

import java.util.Date;
import java.util.List;

public class Faq implements java.io.Serializable {

	/**
	 * Default serialVersionUID.
	 */
	private final static long serialVersionUID = 1L;

    private String id;
    private String sid;
	private String name;
    private String kind;
    private Integer sort;
    private String detail;
    private String attachment;
    private Integer state;
    private String proposeId;
    private String proposeRole;
    private String proposeName;
    private Date proposeDate;
    private String answer;
    private String answerAttachment;
    private String answerId;
    private String answerRole;
    private String answerName;
    private Date answerDate;
    private String productId;
    private String productName;

    private List<FaqDiscuss> discusses;

	/** default constructor */
	public Faq() {
	}

	/** minimal constructor */
	public Faq(String id) {
		this.id = id;
	}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

    public String getName (){
		return name;
    }

    public void setName (String name) {
		this.name = name;
    }

    public String getKind (){
		return kind;
    }

    public void setKind (String kind) {
		this.kind = kind;
    }

    public Integer getSort (){
		return sort;
    }

    public void setSort (Integer sort) {
		this.sort = sort;
    }

    public String getDetail (){
		return detail;
    }

    public void setDetail (String detail) {
		this.detail = detail;
    }

    public String getAttachment (){
		return attachment;
    }

    public void setAttachment (String attachment) {
		this.attachment = attachment;
    }

    public Integer getState (){
		return state;
    }

    public void setState (Integer state) {
		this.state = state;
    }

    public String getProposeId (){
		return proposeId;
    }

    public void setProposeId (String proposeId) {
		this.proposeId = proposeId;
    }

    public String getProposeRole (){
		return proposeRole;
    }

    public void setProposeRole (String proposeRole) {
		this.proposeRole = proposeRole;
    }

    public String getProposeName (){
		return proposeName;
    }

    public void setProposeName (String proposeName) {
		this.proposeName = proposeName;
    }

    public Date getProposeDate (){
		return proposeDate;
    }

    public void setProposeDate (Date proposeDate) {
		this.proposeDate = proposeDate;
    }

    public String getAnswer (){
		return answer;
    }

    public void setAnswer (String answer) {
		this.answer = answer;
    }

    public String getAnswerAttachment (){
		return answerAttachment;
    }

    public void setAnswerAttachment (String answerAttachment) {
		this.answerAttachment = answerAttachment;
    }

    public String getAnswerId (){
		return answerId;
    }

    public void setAnswerId (String answerId) {
		this.answerId = answerId;
    }

    public String getAnswerRole (){
		return answerRole;
    }

    public void setAnswerRole (String answerRole) {
		this.answerRole = answerRole;
    }

    public String getAnswerName (){
		return answerName;
    }

    public void setAnswerName (String answerName) {
		this.answerName = answerName;
    }

    public Date getAnswerDate (){
		return answerDate;
    }

    public void setAnswerDate (Date answerDate) {
		this.answerDate = answerDate;
    }

    public String getProductId (){
		return productId;
    }

    public void setProductId (String productId) {
		this.productId = productId;
    }

    public String getProductName (){
		return productName;
    }

    public void setProductName (String productName) {
		this.productName = productName;
    }
    
	public List<FaqDiscuss> getDiscusses() {
		return discusses;
	}

	public void setDiscusses(List<FaqDiscuss> discusses) {
		this.discusses = discusses;
	}

}
