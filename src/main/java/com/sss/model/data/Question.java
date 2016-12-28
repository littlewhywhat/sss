package com.sss.model.data;

public class Question {
    private String m_Title;
    private String m_Content;
    public Question(String title, String content) {
    	m_Title = title;
    	m_Content = content;
    }
	public String getTitle() {
		return m_Title;
	}
	public void setTitle(String title) {
		this.m_Title = title;
	}
	public String getContent() {
		return m_Content;
	}
	public void setContent(String content) {
		this.m_Content = content;
	}
}
