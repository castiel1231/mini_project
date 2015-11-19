package com.emc.miniproject;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Yichen LI
 * Servlet implementation class MyController
 */
@WebServlet("/MyController")
public class MyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String options[]=request.getParameterValues("table");

		
		if(options[0].equals("student"))
        {
			StudentDao dao = new StudentDao();
			
            request.setAttribute("studentList", dao.selectAll());
            request.setAttribute("columnTab", Column.getCol(options[0]));
            
        }
        else if(options[0].equals("teacher"))
        {
           TeacherDao dao = new TeacherDao();
           
           request.setAttribute("teacherList", dao.selectAll());
           request.setAttribute("columnTab", Column.getCol(options[0]));
        }
           
 		getServletContext().getRequestDispatcher("/view.jsp").forward(request, response);
	
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


	}

}
