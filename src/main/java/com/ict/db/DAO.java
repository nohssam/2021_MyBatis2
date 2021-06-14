package com.ict.db;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class DAO {
	private static SqlSession ss;
	private synchronized static SqlSession getSession() {
		if(ss == null) {
			ss = DBService.getFactory().openSession(false);
		}
		return ss;
	}
	
	public static List<VO> getList(){
		List<VO> list = null;
		list = getSession().selectList("list");
		return list;
	}
	
	public static int getInsert(VO vo) {
		int result=0 ;
		result = getSession().insert("insert", vo);
		ss.commit();
		return result;
	}
	
	public static VO getOneList(String idx) {
		VO vo = null;
		vo = getSession().selectOne("onelist", idx);
		return vo;
	}
	
	public static int getDelete(VO vo) {
		int result = 0 ;
		result = getSession().delete("delete", vo);
		ss.commit();
		return result;
	}
	
	public static int getUpdate(VO vo) {
		int result=0 ;
		result = getSession().update("update", vo);
		ss.commit();
		return result;
	}
}

















