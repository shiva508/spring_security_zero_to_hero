package com.pool.controller;
/*import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;*/


import java.net.URI;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;*/
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.pool.exception.ProductNotFoundException;
import com.pool.form.ProductForm;
import com.pool.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService productService;
	@PostMapping("/saveproduct")
	public ResponseEntity<Object> saveProduct(@RequestBody ProductForm productForm,HttpServletRequest request) {
		/*ResponseEntity<Object>*/
		ProductForm savedProductForm= productService.saveProduct(productForm);
		URI path=ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{userid}")
		.buildAndExpand(savedProductForm.getProductId())
		.toUri();
		//return new ResponseEntity<ProductForm>(savedProductForm, HttpStatus.CREATED);
		//ResponseEntity.created(path).body(savedProductForm).getBody()
		return ResponseEntity.created(path).build();
	}
	/*@GetMapping("/product/{productId}")
	public Resource<ProductForm> getProduct(@PathVariable("productId") Integer productId) {
		ProductForm productForm=productService.product(productId);
		if(productForm==null) {
			throw new ProductNotFoundException("PRODUCT NOT FOUND WITH PRODUCT ID:"+productId);
		}
		Resource<ProductForm> resource=new Resource<ProductForm>(productForm);
		ControllerLinkBuilder linkTo=linkTo(methodOn(this.getClass()).getProduct(productId));
		ControllerLinkBuilder linkTo1=linkTo(methodOn(this.getClass()).getAllProducts());
		resource.add(linkTo.withRel("productbyid"));
		resource.add(linkTo1.withRel("allproducts"));
		return resource;
	}*/
	@GetMapping("/products")
	public List<ProductForm> getAllProducts(){
		return null;
	}
	
}
