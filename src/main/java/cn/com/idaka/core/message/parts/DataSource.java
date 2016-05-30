package cn.com.idaka.core.message.parts;

import java.util.List;

public class DataSource {
	private String name;
	private String code;
	private String summary;
	private int type;
	private int invoke;
	private int dataStatus;
	private int size = 1;
	private String dataParam;
	private List<String> dataId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public List<String> getDataId() {
		return dataId;
	}
	public void setDataId(List<String> dataId) {
		this.dataId = dataId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getInvoke() {
		return invoke;
	}
	public void setInvoke(int invoke) {
		this.invoke = invoke;
	}
	public int getDataStatus() {
		return dataStatus;
	}
	public void setDataStatus(int dataStatus) {
		this.dataStatus = dataStatus;
	}
	public String getDataParam() {
		return dataParam;
	}
	public void setDataParam(String dataParam) {
		this.dataParam = dataParam;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}

}
