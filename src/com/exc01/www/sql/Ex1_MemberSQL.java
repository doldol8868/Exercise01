package com.exc01.www.sql;
// 연습

public class Ex1_MemberSQL {
	public final int GET_LOGIN		=	1001;
	public final int SEL_MEMB_INFO	=	1002;
	
	
	public final int EDIT_MEMB_INFO	=	2001;
	
	public final int ADD_MEMB		=	3001;
	
	// 코드를 입력하면 질의명령을 반환해주는 함수
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		
		switch(code) {
		case GET_LOGIN:
			buff.append("SELECT ");
			buff.append("	count(*) cnt ");
			buff.append("FROM ");
			buff.append("	Ex1_member ");
			buff.append("WHERE ");
			buff.append("	m_id = ? ");
			buff.append("	AND m_pw = ? ");
			break;
		case SEL_MEMB_INFO:
			buff.append("SELECT ");
			buff.append("	m_no mno, m_id id, m_name name, ");
			buff.append("	m_mail mail, m_tel tel, m_join mdate ");
			buff.append("FROM ");
			buff.append("	Ex1_member ");
			buff.append("WHERE ");
			buff.append("	m_id = ? ");
			break;
		case EDIT_MEMB_INFO:
			buff.append("UPDATE ");
			buff.append("	Ex1_member ");
			buff.append("SET ");
			buff.append("	### ");
			buff.append("WHERE ");
			buff.append("	m_no = ? ");
			break;
		case ADD_MEMB:
			buff.append("INSERT INTO");
			buff.append("	member ");
			buff.append("VALUES( ");
			buff.append("	(SELECT NVL(MAX(m_no) + 1, 1001) FROM member), ");
			buff.append("	?, ?, ?, ?, ?, sysdate ");
			buff.append(")");
			break;
		}
		return buff.toString();
	}
}
