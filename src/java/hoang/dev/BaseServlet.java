/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package hoang.dev;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import hoang.dev.data.dao.CategoryDao;
import hoang.dev.data.dao.Database;
import hoang.dev.data.dao.DatabaseDao;
import hoang.dev.data.model.Category;

/**
 *
 * @author Laptop T&T
 */
public class BaseServlet extends HttpServlet{
    @Override
    public void init() throws ServletException {
        DatabaseDao.init(new Database());  // Khởi tạo database
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
        List<Category> categoryList = categoryDao.findAll();
        
        request.setAttribute("categoryList", categoryList);
    }
}