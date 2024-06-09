package com.nexusnimbus.controller;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.nexusnimbus.model.AESEncryption;
import com.nexusnimbus.model.OrderModel;
import com.nexusnimbus.model.ProductModel;
import com.nexusnimbus.model.SaveProduct;
import com.nexusnimbus.model.UserModel;
import com.nexusnimbus.utils.StringUtils;

public class DatabaseController {
	public Connection getConnection() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/nexusnimbus";
		String user = "root";
		String pass = "";
		return DriverManager.getConnection(url, user, pass);
	}
	
//	for registration of user
	public int addUser(UserModel userModel) {
		try(Connection con = getConnection()){
			
			PreparedStatement checkEmailSt = con.prepareStatement(StringUtils.GET_EMAIL);
			checkEmailSt.setString(1, userModel.getEmail());
			ResultSet checkEmailRs = checkEmailSt.executeQuery();
			checkEmailRs.next();
			if (checkEmailRs.getInt(1) > 0) {
				return -2;
			}

			PreparedStatement checkPhoneSt = con.prepareStatement(StringUtils.GET_PHONE);
			checkPhoneSt.setString(1, userModel.getPhoneNumber());
			ResultSet checkPhoneRs = checkPhoneSt.executeQuery();
			checkPhoneRs.next();
			if (checkPhoneRs.getInt(1) > 0) {
				return -3;
			}
			
			
			PreparedStatement st = con.prepareStatement(StringUtils.INSERT_USER);
			
			st.setString(1, userModel.getFirstName());
			st.setString(2, userModel.getLastName());
			st.setString(3, userModel.getPhoneNumber());
			st.setString(4, userModel.getAddress()); 
			st.setString(5, userModel.getEmail());
			
			try {
				String encryptedPwd = AESEncryption.encrypt(userModel.getPassword().getBytes(StandardCharsets.UTF_8),"1234567890123456");
				st.setString(6, encryptedPwd);	
			}catch(Exception e) {
				e.printStackTrace();
				return-1;
			}
			
			int result = st.executeUpdate();
			return result > 0 ? 1 : 0;
		}catch(SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return -1;
		}
	}
	
	public int addMessage(String name, String email, String message) {
		try(Connection con = getConnection()){
            PreparedStatement st = con.prepareStatement("INSERT INTO contact (name, email, message) VALUES (?, ?, ?);");
            st.setString(1, name);
            st.setString(2, email);
            st.setString(3, message);
            
            int result = st.executeUpdate();
			return result > 0 ? 1: 0;
		}catch(Exception e) {
			e.printStackTrace();
			return-1;
		}
	}
	
//	for login of user
	public int getUserLoginInfo(String email, String password) {
        try(Connection con = getConnection()){
            PreparedStatement st = con.prepareStatement(StringUtils.GET_LOGIN_USER_INFO);
            st.setString(1, email);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                String email_db = rs.getString("email");
                String password_db = rs.getString("password");
           
//                email and password match in the database
                try {
					String decryptedPwd = AESEncryption.decrypt(password_db,"1234567890123456");

					if(decryptedPwd != null && email_db.equals(email) && decryptedPwd.equals(password))
						return 1;
					else 
						return 0;
				}catch(Exception e){
					e.printStackTrace();
					return -1;
				}
            }else{
//                email and password not match 
                return 0;
            }
        }catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return -1;
        }
	}
	
	
//	determining if the user is admin or normal user
	public boolean isAdmin(String email) {
		try (Connection con = getConnection()){
			PreparedStatement st = con.prepareStatement("SELECT is_admin FROM user_info WHERE email = ?");
			st.setString(1, email);
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				return rs.getBoolean("is_admin");
			}else {
				return false;
			}
		} catch (SQLException | ClassNotFoundException ex) {
			// TODO: handle exception
			ex.printStackTrace();
			return false;
		}
	}
	
	
//	getting the product according to the brand
	public ArrayList<SaveProduct> getBrandProduct(String brand){
		String query = "";
		
		if (brand.equals("all")) {
			query = "SELECT prodName, brand, prodPrice, prodSpecs, path FROM product_info;";	
			ArrayList<SaveProduct> sp = new ArrayList<>();
			try(Connection con = getConnection()){
				
				 PreparedStatement st = con.prepareStatement(query);
				 
				 ResultSet rs = st.executeQuery();
				 
				 while(rs.next()) {
					SaveProduct s = new SaveProduct(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)); 		
					s.setPicture(rs.getString("path"));
					
					sp.add(s);
				}
			}catch(SQLException | ClassNotFoundException ex) {
				ex.printStackTrace();
			}
			return sp;
		} else {
		    query = "SELECT prodName, brand, prodPrice, prodSpecs, path FROM product_info WHERE prodName LIKE ? OR prodPrice LIKE ? ";
			ArrayList<SaveProduct> sp = new ArrayList<>();
			try(Connection con = getConnection()){
				 PreparedStatement st = con.prepareStatement(query);
				 
				 st.setString(1, "%" + brand + "%");
				 st.setString(2, "%" + brand + "%");
				 ResultSet rs = st.executeQuery();
				  
				 while(rs.next()) {
					 SaveProduct s = new SaveProduct(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)); 		
					 s.setPicture(rs.getString("path"));
						
					 sp.add(s);			
				}
			}catch(SQLException | ClassNotFoundException ex) {
				ex.printStackTrace();
			}
			return sp;
		}


		
	}

//	for getting the user profile. 
	public ArrayList<UserModel> editUserProfile(String email){
        ArrayList<UserModel> um = new ArrayList<>();
        try (Connection con = getConnection()) {
            PreparedStatement st = con.prepareStatement(StringUtils.GET_USER_INFO_FOR_EDIT);
            st.setString(1,email);
            ResultSet rs = st.executeQuery();

            while(rs.next()) {
            	um.add(new UserModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6) ));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return um;
    }
	
//	for updating the user data in the database
	public int updateUser(UserModel userModel, HttpServletRequest request) {

		try(Connection con = getConnection()){	
			HttpSession session =  request.getSession();
			String sessionEmail = (String) session.getAttribute("email");
			String ph = userModel.getPhoneNumber();
			
			PreparedStatement checkPhoneSt = con.prepareStatement(StringUtils.GET_PHONE);
			checkPhoneSt.setString(1, userModel.getPhoneNumber());
			ResultSet checkPhoneRs = checkPhoneSt.executeQuery();
			checkPhoneRs.next();
			if (checkPhoneRs.getInt(1) > 0) {
				return -2;
			}
			
			PreparedStatement st = con.prepareStatement("UPDATE user_info SET first_name = ?, last_name = ?, phone_number = ?, address = ?, password = ?  WHERE email = ?");		
			
			st.setString(1, userModel.getFirstName());
			st.setString(2, userModel.getLastName());
			st.setString(3, ph);
			st.setString(4, userModel.getAddress()); 
			st.setString(6, sessionEmail);
			try {
				String encryptedPwd = AESEncryption.encrypt(userModel.getPassword().getBytes(StandardCharsets.UTF_8),"1234567890123456");
				st.setString(5, encryptedPwd);							
			} catch (Exception e) {
				e.printStackTrace();
				return-1;
			}
			
						
			int res = st.executeUpdate();
			return res > 0 ? 1: 0;		

		}catch(SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return -1;
		}	
	}
	
	public ArrayList<ProductModel> specificProduct(String productName){
	    String query = "SELECT prodName, processor, gpu, brand, display, memory, storage, prodPrice, path FROM product_info WHERE prodName LIKE ?";
	    ArrayList<ProductModel> sp = new ArrayList<>();
	    try (Connection con = getConnection()) {
	        PreparedStatement st = con.prepareStatement(query);
	        st.setString(1, "%" + productName + "%");

	        ResultSet rs = st.executeQuery();

	        while(rs.next()) {
	            // Construct ProductModel and add to ArrayList
	            sp.add(new ProductModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9)));
	        }

	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }

	    return sp;
	}
	
	public int addToCart(String productName, int sessionId, int quantity) {
	    String queryProd = "SELECT prodId, prodPrice FROM product_info where prodName = ?";
	    String query = "INSERT INTO `cart`(`customerId`, `prodId`, `quantity`, `amount`) VALUES (?,?,?,?)";
	    String prodId = "";
	    int total = 0;
	    int prodPrice = 0;

	    try (Connection con = getConnection()) {
	        PreparedStatement qp = con.prepareStatement(queryProd);
	        qp.setString(1, productName);

	        ResultSet rp = qp.executeQuery();

	        while (rp.next()) {
	            prodId = rp.getString(1);
	            prodPrice = Integer.parseInt(rp.getString(2));

	            total = quantity * prodPrice;

	        }

	        PreparedStatement st = con.prepareStatement(query);
	        st.setInt(1, sessionId);  
	        st.setString(2, prodId);   
	        st.setInt(3, quantity);   
	        st.setInt(4, total);    

	        int res = st.executeUpdate();
			return res > 0 ? 1: 0;	
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        return -1; 
	    }
	}
		
	public List<ProductModel> cartProduct(int customerId) {
		List<ProductModel> products = new ArrayList<>();
	    try (Connection con = getConnection()) {
	    	PreparedStatement st = con.prepareStatement("SELECT p.prodId, prodName, processor, gpu, brand, display, memory, storage, prodPrice, path FROM product_info p JOIN cart c ON p.prodid = c.prodId WHERE c.customerId = ?");
	    	st.setInt(1, customerId);
		    ResultSet rs = st.executeQuery();
		    while (rs.next()) {
		    	ProductModel product = new ProductModel(
		    			rs.getString("prodName"),
		    			rs.getString("processor"), 
		    			rs.getString("gpu"), 
		    			rs.getString("brand"), 
		    			rs.getString("display"), 
		    			rs.getString("memory"), 
		    			rs.getString("storage"), 
		    			rs.getInt("prodPrice"), 
		    			rs.getString("path")
		    			);
	            product.setProductId(rs.getString("prodId"));
	            product.setPicture(rs.getString("path"));
	            System.out.print(rs.getString("path"));
		    	products.add(product);
		        System.out.println(products);
		    }
	    } catch (SQLException | ClassNotFoundException ex) {
	        ex.printStackTrace();
	    }
		return products;

	}
	
	public int deleteCartProduct(String prodId, String Id) {
		try(Connection con = getConnection()){
			PreparedStatement st = con.prepareStatement("DELETE FROM cart WHERE prodId = ? AND customerId = ?");
			st.setString(1, prodId);
			st.setString(2, Id);
			int res = st.executeUpdate();
			return res > 0 ? 1: 0;	
		}	 catch (SQLException | ClassNotFoundException ex) {
	        ex.printStackTrace();
	        return -1;
	    }
		
	}
	
	
	public int addOrder(String prodAmount, int id) {
		try(Connection con= getConnection()){
			PreparedStatement st = con.prepareStatement("INSERT INTO orders (customerId, date, totalAmt, Status) VALUES (?, CURRENT_TIMESTAMP, ?, ?)");
			st.setInt(1, id);
			st.setString(2, prodAmount);
			st.setString(3, "Pending");
			
			int res = st.executeUpdate();
			return res > 0 ? 1: 0;
		}catch(SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return -1;
		}
	}
	
	public String getUserId(String email) {
		String id = "";
		try(Connection con= getConnection()){
			PreparedStatement st = con.prepareStatement("SELECT id FROM user_info WHERE email = ?");
			st.setString(1, email);
			
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				id = rs.getString("id");
			}
				
		}catch(SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return id;
	}
	
	public List<OrderModel> getUserOrders(String id) {
	    List<OrderModel> orders = new ArrayList<>();
	    try (Connection con = getConnection()) {
	        PreparedStatement st = con.prepareStatement("SELECT id, customerId, date, totalAmt, Status FROM orders WHERE customerId = ?");
	        st.setString(1, id);
	        ResultSet rs = st.executeQuery();
	        while (rs.next()) {
	            OrderModel order = new OrderModel(
	            	rs.getInt("id"),
	            	rs.getInt("customerId"),
	            	rs.getString("date"),
	            	rs.getInt("totalAmt"),
	            	rs.getString("Status")
	            );
	
	            orders.add(order);
		        System.out.println(order);
	        }
	    } catch (SQLException | ClassNotFoundException ex) {
	        ex.printStackTrace();
	    }
	    return orders;
	}
	
	
	
	
//	admin part
	
	
	public int addProduct(ProductModel productModel) {
		try (Connection con = getConnection()){
			PreparedStatement st = con.prepareStatement("INSERT INTO product_info(prodName, brand, prodPrice, prodSpecs, processor, gpu, display, memory, storage, path) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			st.setString(1, productModel.getProductName());
			st.setString(2, productModel.getProductBrand());
			st.setInt(3, productModel.getProductPrice());
			st.setString(4, "New");
			st.setString(5, productModel.getProductProcessor());
			st.setString(6, productModel.getProductGPU());
			st.setString(7, productModel.getProductDisplay());
			st.setString(8, productModel.getProductMemory());
			st.setString(9, productModel.getProductStorage());
			st.setString(10, productModel.getPicture());

			int result = st.executeUpdate();
			return result > 0 ? 1 : 0;
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return -1;
		}
	}
	
	public List<ProductModel> getProducts() {
	    List<ProductModel> products = new ArrayList<>();
	    try (Connection con = getConnection()) {
	        PreparedStatement st = con.prepareStatement("SELECT * FROM product_info;");
	        ResultSet rs = st.executeQuery();
	        while (rs.next()) {
	            ProductModel product = new ProductModel(
	                rs.getString("prodName"),
	                rs.getString("processor"),
	                rs.getString("gpu"),
	                rs.getString("brand"),
	                rs.getString("display"),
	                rs.getString("memory"),
	                rs.getString("storage"),
	                rs.getInt("prodPrice"),
	                rs.getString("path")
	            );
	            product.setProductId(rs.getString("prodId"));
	            products.add(product);
		        System.out.println(product);
	        }
	    } catch (SQLException | ClassNotFoundException ex) {
	        ex.printStackTrace();
	    }
	    return products;
	}
	
	public int deleteProduct(String id) {
		try (Connection con = getConnection()){
			PreparedStatement st = con.prepareStatement("DELETE FROM product_info WHERE prodId = ?;");
		
			st.setString(1, id);

			int result = st.executeUpdate();
			return result > 0 ? 1 : 0;
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return -1;
		}
	}
	
	public int editProduct(ProductModel product) {
		try (Connection con = getConnection()){
			PreparedStatement st = con.prepareStatement("UPDATE product_info SET prodName = ?, brand = ?, prodPrice = ?, processor = ?, gpu = ?, display = ?, memory = ?, storage = ? WHERE prodName = ?");
			st.setString(1, product.getProductName());
			st.setString(2, product.getProductBrand());
			st.setInt(3, product.getProductPrice());
			st.setString(4, product.getProductProcessor());
			st.setString(5, product.getProductGPU());
			st.setString(6, product.getProductDisplay());
			st.setString(7, product.getProductMemory());
			st.setString(8, product.getProductStorage());
			st.setString(9, product.getProductName());
			
			int result = st.executeUpdate();
			return result > 0 ? 1 : 0;
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return -1;
		}
	}
	
	public List<ProductModel> getProductsEdit(String id) {
	    List<ProductModel> products = new ArrayList<>();
	    try (Connection con = getConnection()) {
	        PreparedStatement st = con.prepareStatement("SELECT * FROM product_info WHERE prodId = ?;");
	        st.setString(1, id);
	        
	        ResultSet rs = st.executeQuery();

	        while (rs.next()) {
	            ProductModel product1 = new ProductModel(
	                rs.getString("prodName"),
	                rs.getString("processor"),
	                rs.getString("gpu"),
	                rs.getString("brand"),
	                rs.getString("display"),
	                rs.getString("memory"),
	                rs.getString("storage"),
	                rs.getInt("prodPrice"),
	                rs.getString("path")
	            );
	            product1.setProductId(rs.getString("prodId"));
	            products.add(product1);
		        System.out.println(product1);
	        }
	    } catch (SQLException | ClassNotFoundException ex) {
	        ex.printStackTrace();
	    }
	    return products;
	}
	
	public List<OrderModel> getOrders() {
	    List<OrderModel> orders = new ArrayList<>();
	    try (Connection con = getConnection()) {
	        PreparedStatement st = con.prepareStatement("SELECT o.id, o.customerId, o.date, o.totalAmt, o.Status, u.email FROM orders o JOIN user_info u ON o.customerId = u.id");
	        ResultSet rs = st.executeQuery();
	        while (rs.next()) {
	            OrderModel order = new OrderModel(
	            	rs.getInt("id"),
	            	rs.getInt("customerId"),
	            	rs.getString("date"),
	            	rs.getInt("totalAmt"),
	            	rs.getString("Status")
	            );
	            
	            order.setUserName(rs.getString("email"));

	            orders.add(order);
		        System.out.println(order);
	        }
	    } catch (SQLException | ClassNotFoundException ex) {
	        ex.printStackTrace();
	    }
	    return orders;
	}
	
	public int changeOrderStatus(String id, String status) {
		try (Connection con = getConnection()){
			PreparedStatement st = con.prepareStatement("UPDATE orders SET Status = ? WHERE id = ?;");
			st.setString(1, status);
			st.setString(2, id);
			
			int result = st.executeUpdate();
			return result > 0 ? 1: 0;
		} catch(SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return -1;
		}
	}
	
}
