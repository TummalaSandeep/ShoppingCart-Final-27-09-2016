package com.niit.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.ShoppingCart.DAO.ProductDAO;
import com.niit.ShoppingCart.DAO.SupplierDAO;
import com.niit.ShoppingCart.model.Product;
import com.niit.ShoppingCart.model.Supplier;

@Controller
public class ProductController {
	@Autowired
	ProductDAO pd;
	@Autowired
	SupplierDAO sd;

	@ModelAttribute("Product")
	public Product createProduct() {
		return new Product();
	}
	@RequestMapping("/ManageProduct")
	public ModelAndView display11() {
		ModelAndView m10 = new ModelAndView("ManageProduct");
		return m10;
	}
	@RequestMapping("editproduct")
	public ModelAndView display15() {
		ModelAndView m6 = new ModelAndView("editproduct");
		return m6;

	}		 		 
 @RequestMapping(value="editproduct",method=RequestMethod.GET)
    public ModelAndView editPro(@RequestParam int id){
	 Product product1=pd.get(id);
    	return new ModelAndView("editproduct","Product",product1);
    }
@RequestMapping("addproduct")
	public ModelAndView display3() {

		ModelAndView mv3 = new ModelAndView("addproduct");
		mv3.addObject("supplier", new Supplier());
        List suppliers= sd.list();
        mv3.addObject("suppliers", suppliers);
        return mv3;
	}
@RequestMapping("/viewproduct")
public ModelAndView display8() {
	ModelAndView m4 = new ModelAndView("viewproduct");
	return m4;
}

@RequestMapping("storeproduct")
	public String addproduct(HttpServletRequest request, @Valid @ModelAttribute("Product") Product product,BindingResult result) 
   {
		
		System.out.println(product.getId());
		System.out.println(product.getName());
		String filename = product.getImg().getOriginalFilename();
		product.setImage(filename);

		try {
			byte[] bytes = new byte[product.getImg().getInputStream().available()];
			product.getImg().getInputStream().read(bytes);
			BufferedInputStream buffer = new BufferedInputStream(product.getImg().getInputStream());
			MultipartFile file = product.getImg();
			String path = request.getServletContext().getRealPath("/") + "resources/images";
			File rootPath = new File(path);
			if (!rootPath.exists())
				rootPath.mkdirs();
			File store = new File(rootPath.getAbsolutePath() + "/" + filename);
			System.out.println("Image path :" + path);
			OutputStream os = new FileOutputStream(store);
			os.write(bytes);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		pd.save(product);
		return "addproduct";
   }

@RequestMapping(value = "list", method = RequestMethod.GET, produces = "application/json")
public @ResponseBody String showList()
{
	List list = pd.list();
	Gson x = new Gson();
	String json = x.toJson(list);
	return json;
}
@RequestMapping("/delete")
public ModelAndView deleteProduct(@RequestParam int id) {
	pd.delete(id);
	ModelAndView m1 = new ModelAndView("ManageProduct");
	return m1;
}
@RequestMapping(value = "viewproduct", method = RequestMethod.GET)
public ModelAndView viewPro(@RequestParam int id, @ModelAttribute Product products) {
	Product product = pd.get(id);
	return new ModelAndView("viewproduct", "product", product);
}
@RequestMapping(value = "viewproductuser", method = RequestMethod.GET)
public ModelAndView viewProuser(@RequestParam int id, @ModelAttribute Product products) {
	Product product = pd.get(id);
	return new ModelAndView("viewproductuser", "product", product);
}
 		 
 
 @RequestMapping(value="/update",method=RequestMethod.POST)
    public ModelAndView updateProduct(HttpServletRequest request,@Valid @ModelAttribute("Product")Product product,BindingResult result)
    {
    	
    	String filename=product.getImg().getOriginalFilename();
    	
    	product.setImage(filename);
 	
    	try{
 		byte[] bytes=new byte[product.getImg().getInputStream().available()];
 		product.getImg().getInputStream().read(bytes);
 		BufferedInputStream buffer=new BufferedInputStream(product.getImg().getInputStream());
 		MultipartFile file=product.getImg();
 		String path=request.getServletContext().getRealPath("/")+"resources/images";
 		File rootPath=new File(path);
 		if(!rootPath.exists())
 			rootPath.mkdirs();
 		File store=new File(rootPath.getAbsolutePath()+"/"+filename);
 		System.out.println("Image path :"+path);
 		OutputStream os=new FileOutputStream(store);
 		os.write(bytes);
 	}
 	catch(Exception e){
 		System.out.println(e.getMessage());
 	}
 		        
    	pd.save(product);
    	return new ModelAndView("ManageProduct");
    }
}
