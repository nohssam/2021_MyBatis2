package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.VO;

public class OneListCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		  String idx = request.getParameter("idx");
		  VO vo = DAO.getOneList(idx);
		  // 수정과 삭제를 위해서 vo 를 session에 넣자 
		  request.getSession().setAttribute("vo", vo);	
		return "view/onelist.jsp";
	}
}
