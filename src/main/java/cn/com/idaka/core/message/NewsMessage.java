package cn.com.idaka.core.message;

import java.util.List;

import cn.com.idaka.core.message.Message;
import cn.com.idaka.core.message.parts.News;

public interface NewsMessage extends Message {

	public Integer getArticleCount();

	public void setArticleCount(Integer articleCount);

	public List<News> getArticles();

	public void setArticles(List<News> articles);

}
