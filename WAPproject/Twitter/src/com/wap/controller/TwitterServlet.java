package com.wap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Arrays;
import java.util.List;


import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.OAuth2Token;
import twitter4j.conf.ConfigurationBuilder;
import wap.com.model.TwitterDatabase;
import wap.com.model.TwitterItem;
import wap.com.model.TwitterTrend;

/**
 * Servlet implementation class TwitterServlet
 */
@WebServlet("/TwitterServlet")
public class TwitterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Twitter twitter = TwitterConnection.getInstance();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TwitterServlet() {
        
              
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String category;
		if (request.getParameter("category") == null) category = "romance";
		else category = request.getParameter("category") ;
		System.out.println("category: " + category);
		
		if (category.equalsIgnoreCase("seetrends")) {
			List<TwitterTrend> trendsList;
			try {
				trendsList = TwitterDatabase.getTwitterTrends();
				request.getSession().setAttribute("trendList", trendsList);
				response.sendRedirect("index.jsp");
			} catch (TwitterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				List<TwitterItem> itemList = TwitterDatabase.getTwitterItems(category);
				for (TwitterItem i: itemList) {
					System.out.println("content:" + i.getContent());
					System.out.println("image" + i.getImage());
					System.out.println("========================================================================");
				}
				request.getSession().setAttribute("categoryList", itemList);
				response.sendRedirect("index.jsp");					
			} catch (TwitterException e) {
				
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

	
}
