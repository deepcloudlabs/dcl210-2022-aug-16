import com.example.crm.service.CustomerService;
import com.example.crm.service.business.FastCustomerService;
import com.example.crm.service.business.StandardCustomerService;

module com.example.crm {
	exports com.example.crm.domain;
	exports com.example.crm.service;
	provides CustomerService 
	with FastCustomerService, StandardCustomerService ;
}