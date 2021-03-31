package hh.fi.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.fi.Bookstore.domain.Book;
import hh.fi.Bookstore.domain.CategoryRepository;
import hh.fi.Bookstore.domain.BookRepository;
import hh.fi.Bookstore.domain.Category;


@Controller
public class CategoryController {
	
	@Autowired 
	private BookRepository repository;
	
	@Autowired 
	private CategoryRepository crepository;

	@RequestMapping(value="/categorylist")
	public String categoryList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "categorylist";
	}
	
	@RequestMapping(value = "/newcategory")
    public String addCategory(Model model){
    	model.addAttribute("categorys", crepository.findAll());
        return "newcategory";
    } 

}
