

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Nerdery
 */
@WebServlet("/Nerdery")
public class Nerdery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Nerdery() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		System.out.println("Hellooo:Post");
		GameBean gb = new GameBean();
		ArrayList gameList = gb.getGameList();
		
		request.setAttribute("gameList",gameList);
		
        String nextJSP = "/gamevote.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request,response);
		
		System.out.println("Disconnected from database");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Hellooo");
		String result="Success";
		boolean dublicate= false;
		String actionType = request.getParameter("actionType").toString();
		System.out.println("actionType"+actionType);
		
		if (actionType.equalsIgnoreCase("Add")){
			GameBean gb = new GameBean();
			String gameTitle = request.getParameter("addtitle").toString();
			ArrayList gameList = gb.getGameList();
			
			Iterator itr = gameList.iterator();
			System.out.println("Hellooo"+gameTitle);
			while(itr.hasNext())
			{				
				ArrayList viewList = (ArrayList)itr.next();
				String gameName = viewList.get(1).toString();
				if(gameName.equalsIgnoreCase(gameTitle)){
				dublicate = true;
				}
			}
			
			if(gameTitle =="") {
				request.setAttribute("result","Enter a value");
			}
			else if(dublicate){
				System.out.println("Hellooo"+dublicate);
				request.setAttribute("result","Dublicate Value! Enter a different value");
			}
			
			Calendar cal = Calendar.getInstance();
			 int dow = cal.get(Calendar.DAY_OF_WEEK);
			 
			 if(dow ==0 || dow ==1){
				 dublicate = true;
				 request.setAttribute("result","Adding Title over the weekend not allowed");
			 }
			
			if(!dublicate){
				result = gb.addGame(gameTitle);
			    request.setAttribute("result",result);
			 }
			
			ArrayList gameList2 = gb.getGameList();
			request.setAttribute("gameList",gameList2);
	        String nextJSP = "/gamevote.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
			dispatcher.forward(request,response);
			
		}
		
		if (actionType.equalsIgnoreCase("Vote")){
			System.out.println("Enter into vote!!");
			GameBean gb = new GameBean();
			int id = Integer.parseInt(request.getParameter("gameid").toString());
			System.out.println("Vote:"+id);
			
			 Calendar cal = Calendar.getInstance();
			 int dow = cal.get(Calendar.DAY_OF_WEEK);
			 
			 if(dow ==0 || dow ==1){
				 request.setAttribute("result","Voting Title over the weekend not allowed");
			 }else{		
			     String gameList = gb.voteGame(id);
			 }
			ArrayList gameList2 = gb.getGameList();
			request.setAttribute("gameList",gameList2);
	        String nextJSP = "/gamevote.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
			dispatcher.forward(request,response);
		}
		
		if (actionType.equalsIgnoreCase("Own")){
			System.out.println("Enter into Own!!");
			GameBean gb = new GameBean();
			int id = Integer.parseInt(request.getParameter("gameid").toString());
			System.out.println("own:"+id);
			String gameList = gb.ownGame(id);
			ArrayList gameList2 = gb.getOwnList();
			request.setAttribute("ownList",gameList2);
	        String nextJSP = "/gameown.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
			dispatcher.forward(request,response);
		}
		
		if (actionType.equalsIgnoreCase("votepage")){
			GameBean gb = new GameBean();
			ArrayList gameList2 = gb.getGameList();
			request.setAttribute("gameList",gameList2);
	        String nextJSP = "/gamevote.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
			dispatcher.forward(request,response);
		}
	}

}
