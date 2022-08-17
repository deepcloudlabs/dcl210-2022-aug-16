import com.example.crm.service.CustomerService;
import com.example.product.service.ProductService;

module com.example.order {
	requires com.example.product;
	requires com.example.crm;
	uses CustomerService;
	uses ProductService;
}