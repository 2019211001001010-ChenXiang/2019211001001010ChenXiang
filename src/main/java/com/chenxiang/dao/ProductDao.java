package com.chenxiang.dao;

import com.chenxiang.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements  IProductDao{
    @Override
    public int save(Product product, Connection con) throws SQLException {
        int n = 0;
        String sql = "insert into product(ProductName,ProductDescription,Picture,price,CategoryID) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, product.getProductName());
        pt.setString(2, product.getProductDescription());
        if(product.getPicture()!=null) {
            //for sql server
            pt.setBinaryStream(3, product.getPicture());
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, product.getPrice());
        pt.setInt(5, product.getCategoryId());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }//end save

    @Override
    public int delete(Integer productId, Connection con) throws SQLException {
        Product product=null;
        String sql="delete from usertable where prouctId=?";
        PreparedStatement st=con.prepareStatement(sql);
        /*st.setInt(1,product.getProductId(rs.getInt("ProductId")));*/
        st.setInt(1,product.getProductId());
        ResultSet rs=st.executeQuery();
        if(rs.next()){
            product=new Product();
            product.setProductId(rs.getInt("productId"));
            product.setProductName(rs.getString("productName"));
            product.setProductDescription(rs.getString("productDescription"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryId(rs.getInt("categoryId"));
        }
        return 0;
    }


    @Override
    public int update(Product instance, Connection con) throws SQLException {
        int n = 0;
        String sql = "UPDATE product SET ProductName=?,ProductDescription=?,Picture=?,price=?,CategoryID=?" +
                "WHERE ProductId=?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, instance.getProductName());
        pt.setString(2, instance.getProductDescription());
        if(instance.getPicture()!=null) {
            //for sql server
            pt.setBinaryStream(3, instance.getPicture());
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, instance.getPrice());
        pt.setInt(5, instance.getCategoryId());
        /*pt.setInt(6,instance.getProductId(rs.getInt("ProductId")));*/
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }

    @Override
    public Product findById(Integer productId, Connection con) throws SQLException {
        String sql = "select * from product  where productId=?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setInt(1,productId);
        ResultSet rs=pt.executeQuery();
        Product product=new Product();
        while (rs.next()){

            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryId(rs.getInt("CategoryId"));

        }
        return product;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con) throws SQLException {
        List<Product> list=new ArrayList<Product>();
        String sql = "select * from product  where categoryId=?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setInt(1,categoryId);
        ResultSet rs=pt.executeQuery();
        while (rs.next()){
            Product product=new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryId(rs.getInt("CategoryId"));
            list.add(product);
        }
        return list;
    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        String sql = "SELECT*FROM product WHERE price>=? AND price<=?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setDouble(1,minPrice);
        pt.setDouble(2,maxPrice);
        ResultSet rs=pt.executeQuery();
        List<Product> list=new ArrayList<>();
        while (rs.next()){
            Product product=new Product();
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryId(rs.getInt("CategoryId"));
            list.add(product);
            return list;
        }
        return null;
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {
        List<Product> list= new ArrayList<Product>();
            String queryString = "SELECT*FROM product";
            PreparedStatement pt = con.prepareStatement(queryString);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("ProductId"));
                product.setProductName(rs.getString("ProductName"));
                product.setProductDescription(rs.getString("ProductDescription"));
                product.setPicture(rs.getBinaryStream("picture"));
                product.setPrice(rs.getDouble("price"));
                product.setCategoryId(rs.getInt("categoryId"));
                list.add(product);
            }
            System.out.println("successful");

        return list;
    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {
        String sql = "SELECT*FROM product WHERE ProductName=?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1,productName);
        ResultSet rs=pt.executeQuery();
        List<Product> list=new ArrayList<>();
        while (rs.next()){
            Product product=new Product();
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryId(rs.getInt("CategoryId"));
            list.add(product);
            return list;
        }
        return null;
    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {
        return null;
    }

    public byte[] getPictureById(Integer productId, Connection con) throws SQLException {
        byte[] imgBytes=null;
        String  sql ="select picture from product where productId=?";
        PreparedStatement pt=con.prepareStatement(sql);
        pt.setInt(1,productId);
        ResultSet rs=pt.executeQuery();
        while(rs.next()){
            Blob blob=rs.getBlob("picture");
            imgBytes=blob.getBytes(1,(int)blob.length());//get all
        }
        return imgBytes;
    }
}
