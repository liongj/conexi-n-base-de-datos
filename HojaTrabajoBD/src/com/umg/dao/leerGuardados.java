package com.umg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.umg.connection.MariaDBConnecction;

public class leerGuardados {
				
			 public static boolean ingresarProducto ( ) {
				 
				 System.out.println("A continuacion se le solicitaran los datos del producto");
			    	Scanner sc = new Scanner(System.in);
					
					System.out.println("cliente: ");
					String cliente=sc.nextLine();
					
					System.out.println("direccion_de_pedidos: ");
					String direccion_de_pedidos=sc.nextLine();
					
					System.out.println("estado_de_pedido: ");
					String estado_de_pedido=sc.nextLine();
					
					

			
			        Connection conn = MariaDBConnecction.getConnection();

			        if (conn != null) {

			            try {

			            	String consulta = "INSERT INTO productos (cliente,"
			                		+ " direccion_de_pedido, estado_de_pedido,) VALUES (?, ?, ?,)";

			                PreparedStatement statement = conn.prepareStatement(consulta);


			                statement.setString(1, cliente);
							statement.setString(2, direccion_de_pedidos);
			                statement.setString(3, estado_de_pedido );
			                
			               
			             
			                
			                
			                int filasInsertadas = statement.executeUpdate();
			                
			                System.out.println("Registro creado: " + filasInsertadas);

			                statement.close();

			                conn.close();


			                return filasInsertadas > 0;

			            } catch (SQLException e) {

			                System.out.println("Error al crear producto: " + e.getMessage());

			                return false;

			            }

			        } else {

			            System.out.println("No se pudo establecer la conexión.");

			            return false;

			        }

			 }
			 	






		//eliminar producto 


		public static boolean eliminarProducto() {
			
			System.out.println("Por favor ingrese el ID del producto que desea eliminar: ");
			Scanner sc = new Scanner(System.in);
			int idproducto = sc.nextInt();
			
			

		    Connection conn = MariaDBConnecction.getConnection();

		    if (conn != null) {

		        try {

		            String consulta = "DELETE FROM inventario WHERE idproducto = ?";

		            PreparedStatement statement = conn.prepareStatement(consulta);

		            statement.setInt(1, idproducto);

		            int filasEliminadas = statement.executeUpdate();

		            statement.close();

		            conn.close();

		            return filasEliminadas > 0;

		        } catch (SQLException e) {

		            System.out.println("Error al eliminar producto: " + e.getMessage());

		            return false;

		        }

		    } else {

		        System.out.println("No se pudo establecer la conexión.");

		        return false;

		    }

		}
			

			
			
			
			
			
			//actualizacion de producto 
			
			
			
			
			public static boolean actualizarProducto() {
				
				
				Scanner sc = new Scanner(System.in);
		    	System.out.println("A continuacion se le solicitaran los datos del producto para actualizar");
		    	
		    	System.out.println("Ingrese el ID producto: ");
		    	String idproducto = sc.nextLine();
		    	
		    	System.out.println("clienete: ");
				String cliente=sc.nextLine();
		    			
				System.out.println("direccion_de_pedido: ");
				String direccion_de_pedido=sc.nextLine();
						
				System.out.println("estado_de_pedido: ");
				String estado_de_pedido=sc.nextLine();

			    Connection conn = MariaDBConnecction.getConnection();

			    if (conn != null) {

			        try {

			            String consulta = "UPDATE inventario SET descripcion = ?, stock = ?, precio_venta = ? WHERE idproducto = ?";

			            PreparedStatement statement = conn.prepareStatement(consulta);

			            statement.setString(1, cliente);

			            statement.setString(2, direccion_de_pedido);

			            statement.setString(3, estado_de_pedido);

			            statement.setString(4, idproducto);

			            int filasActualizadas = statement.executeUpdate();

			            statement.close();

			            conn.close();

			            return filasActualizadas > 0;

			        } catch (SQLException e) {

			            System.out.println("Error al actualizar producto: " + e.getMessage());

			            return false;

			        }

			    } else {

			        System.out.println("No se pudo establecer la conexión.");

			        return false;

			    }

			}
			public static void leerProducto() {
			    Connection conn = MariaDBConnecction.getConnection();
			    if (conn != null) {
			        try {
			            String consulta = "SELECT * FROM productos";
			            PreparedStatement statement = conn.prepareStatement(consulta);
			            ResultSet resultSet = statement.executeQuery();
			            while (resultSet.next()) {
			                int idproducto = resultSet.getInt("idproducto");
			                String direccion_de_pedido = resultSet.getString("direccion de pedido");
			                String cliente = resultSet.getString("cliente");
			                String estado_de_pedido = resultSet.getString("estado_de_pedido");
			                System.out.println("ID producto: " + idproducto + ", direccion_de_pedido: " + direccion_de_pedido + ", cliente: " + cliente + ", estado_de_pedido: " + estado_de_pedido);
			            }
			            resultSet.close();
			            statement.close();
			            conn.close();
			        } catch (SQLException e) {
			            System.out.println("Error al leer producto: " + e.getMessage());	
			        }
			    } else {
			        System.out.println("No se pudo establecer la conexión.");
			    }

			}
	}
	



