package com.nexusnimbus.utils;


public class StringUtils {
	
//	SQL Query for inserting the user data into the user_info table 
	public static final String INSERT_USER = "INSERT INTO user_info "
			+ "(first_name, last_name, phone_number, address, email, password, is_admin)"
			+ "VALUES(?, ?, ?, ?, ?, ?, false)";
	
//	
	public static final String FIRST_NAME = "firstname";
	public static final String LAST_NAME = "lastname";
	public static final String PHONE_NUMBER = "phonenumber";
	public static final String ADDRESS = "address";
	public static final String EMAIL = "email";
	public static final String PASSWORD = "password";
	public static final String CONFIRM_PASSWORD = "confirmpassword";
	
//	
	public static final String GET_LOGIN_USER_INFO = "SELECT * FROM user_info WHERE email = ? ";
	public static final String GET_USER_INFO_FOR_EDIT = "SELECT first_name, last_name, phone_number, address, email, password FROM user_info WHERE email = ? ";
	
	//
	public static final String GET_PHONE = "SELECT COUNT(*) FROM user_info WHERE phone_number = ?  ";
	public static final String GET_EMAIL = "SELECT COUNT(*) FROM user_info WHERE email = ?  ";
	
	//
	public static final String EMAIL_ERROR_MESSAGE = "Email is already registered";
	public static final String PHONENO_ERROR_MESSAGE = "Phone number is already registered";
	public static final String PASSWORD_UNMATCHED_ERROR_MESSAGE = "The password doesnot match";
	
	// path to jsp files. 
	public static final String LOGIN_PAGE = "/pages/login.jsp";
	public static final String HOME_PAGE = "/pages/home.jsp";
	public static final String EDIT_PROFILE_PAGE = "/pages/editProfile.jsp";
	public static final String CART_PAGE = "/pages/cart.jsp";
	public static final String ADD_PROD_PAGE = "/pages/admin/addProduct.jsp";
	public static final String INPUT_ERROR = "/pages/inputError.html";
	public static final String SERVER_ERROR = "/pages/serverError.html";
	public static final String PHONE_NUMBER_PAGE = "/pages/phnNumber.html";
	public static final String USER_PRODUCT_PAGE = "/pages/prodd.jsp";
	//
	public static final String SUCCESS_REGISTER_MESSAGE = "Successfully registered !";
	public static final String REGISTER_ERROR_MESSAGE = "Please input correct data in the form !";
	public static final String SERVER_ERROR_MESSAGE = "An unexpected server error occured !";
	public static final String SUCCESS_LOGIN_MESSAGE = "Successfully logged in !";
	public static final String LOGIN_ERROR_MESSAGE = " Your email and password doesnot match"; 
	public static final String SUCCESS_MESSAGE = "successMessage";
	public static final String ERROR_MESSAGE = "errorMessage";
	public static final String REG_ERROR_MESSAGE = "errorMessage";
	
	
	//
	public static final String REGISTER_SERVLET = "/RegisterServlet";
	public static final String LOGIN_SERVLET = "/LoginServlet";
	public static final String UPDATE_PROFILE_SERVLET= "/UpdateProfileServlet";
	
	
	
	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String PROCESSOR = "processor";
	public static final String GPU = "gpu";
	public static final String BRAND = "brand";
	public static final String DISPLAY = "display";
	public static final String MEMORY = "memory";
	public static final String STORAGE = "storage";
	public static final String PRICE = "price";	
	
//	database query
	public static final String INSERT_PRODUCT = "INSERT INTO products (name, processor, gpu, brand, display, memory, storage, price) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
	public static final String TOTAL_ORDERS_COUNT = "";
	public static final String TOTAL_USERS_COUNT = "";
	public static final String TOTAL_SALES_COUNT = "";
	public static final String EDIT_PRODUCT = "UPDATE products "
	        + "SET name = ?, processor = ?, gpu = ?, brand = ?, display = ?, memory = ?, storage = ?, price = ? WHERE name = ?";
	public static final String DELETE_PRODUCT = "DELETE FROM products "
	        + "WHERE id = ?;";
	public static final String GET_PRODUCT = "SELECT * FROM products;"
			+ "";
	public static final String GET_ORDER = "SELECT * FROM orders;";
	public static final String CHANGE_ORDER_STATUS = "UPDATE orders SET order_status = ? WHERE name = ?";
	
//	message
	public static final String ORDER_ERROR_MESSAGE = "Please correct the form data";

//	frontend path	
	public static final String DASHBOARD_PAGE = "/pages/admin/dashBoard.jsp";
	public static final String ORDER_PAGE = "/pages/admin/order.jsp";
	public static final String PRODUCT_PAGE = "/pages/admin/product.jsp";
	public static final String ADD_PRODUCT_PAGE = "/pages/admin/addProduct.jsp";

//	servlet path
	public static final String ORDER_SERVLET = "/registerServlet";
	public static final String PRODUCT_SERVLET = "/productServlet";
	public static final String DISPLAY_PRODUCT_SERVLET = "/displayProductServlet";
	public static final String EDIT_PRODUCT_SERVLET = "/editProductServlet";
	
	
	public static final String CHECK_PRODUCT = "";
}
