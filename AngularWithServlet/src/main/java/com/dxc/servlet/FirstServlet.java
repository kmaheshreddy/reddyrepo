package com.dxc.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class FirstServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doGet(req, res);
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = null;
		String str = "";
		BufferedReader br = null;
		JSONObject jo = null;
		StringBuffer sb = null;

		try {
			br = req.getReader();
			sb = new StringBuffer();

			while ((str = br.readLine()) != null) {
				sb.append(str);
			}
			jo = new JSONObject(sb.toString());
			String name = jo.getString("name");
			pw = res.getWriter();
			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");

			pw.println("<b> Hi Hello" + name + "</b>");

			pw.close();
		} catch (IOException ioe) {
			ioe.getStackTrace();
		}
	}

}
