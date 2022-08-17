import com.example.product.service.ProductService;
import com.example.product.service.business.StandardProductService;

module com.example.product {
	exports com.example.product.domain;
	exports com.example.product.service;
	provides ProductService
	with StandardProductService;
}