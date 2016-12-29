package com.sss.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Question {
	@Id
	@GeneratedValue
	private Long m_Id;
    private String m_Title;
    private String m_Content;
    public Question() {}
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
