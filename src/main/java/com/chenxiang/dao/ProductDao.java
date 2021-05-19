package com.chenxiang.dao;

import com.chenxiang.model.Product;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        st.setInt(1,product.getProductId());
        ResultSet rs=st.executeQuery();
        if(rs.next()){
            product=new Product();
            product.setProductId(rs.getInt("productId"));
            product.setProductName(rs.getString("productName"));
            product.setProductDescription(rs.getString("productDescription"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setPrice(rs.getDouble("picture"));
            product.setCategoryId(rs.getInt("categoryId"));
        }
        return 0;
    }


    @Override
    public int update(Product instance, Connection con) throws SQLException {
        Product product=null;
        String sql="update from usertable where prouctId=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setInt(1,product.getProductId());
        ResultSet rs=st.executeQuery();
        if(rs.next()){
            product=new Product();
            product.setProductId(rs.getInt("productId"));
            product.setProductName(rs.getString("productName"));
            product.setProductDescription(rs.getString("productDescription"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setPrice(rs.getDouble("picture"));
            product.setCategoryId(rs.getInt("categoryId"));
        }
        return 0;
    }

    @Override
    public Product findById(Integer productId, Connection con) throws SQLException {
        Product product=null;
        String sql="select*from usertable where prouctId=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setInt(1,product.getProductId());
        ResultSet rs=st.executeQuery();
        if(rs.next()){
            product=new Product();
            product.setProductId(rs.getInt("productId"));
            product.setProductName(rs.getString("productName"));
            product.setProductDescription(rs.getString("productDescription"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setPrice(rs.getDouble("picture"));
            product.setCategoryId(rs.getInt("categoryId"));
        }
        return null;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con) throws SQLException {
        Product product=null;
        String sql="select*from usertable where CategoryId=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setInt(1,product.getCategoryId());
        ResultSet rs=st.executeQuery();
        if(rs.next()){
            product=new Product();
            product.setProductId(rs.getInt("productId"));
            product.setProductName(rs.getString("productName"));
            product.setProductDescription(rs.getString("productDescription"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setPrice(rs.getDouble("picture"));
            product.setCategoryId(rs.getInt("categoryId"));
        }
        return null;
    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        Product product=null;
        String sql="select*from usertable where Price=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setDouble(1,product.getPrice());
        ResultSet rs=st.executeQuery();
        if(rs.next()){
            product=new Product();
            product.setProductId(rs.getInt("productId"));
            product.setProductName(rs.getString("productName"));
            product.setProductDescription(rs.getString("productDescription"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setPrice(rs.getDouble("picture"));
            product.setCategoryId(rs.getInt("categoryId"));
        }
        return null;
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {
        Product product=null;
        String sql="select*from usertable where prouctId=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setInt(1,product.getProductId());
        ResultSet rs=st.executeQuery();
        if(rs.next()){
            product=new Product();
            product.setProductId(rs.getInt("productId"));
            product.setProductName(rs.getString("productName"));
            product.setProductDescription(rs.getString("productDescription"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setPrice(rs.getDouble("picture"));
            product.setCategoryId(rs.getInt("categoryId"));
        }
        return null;
    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {
        Product product=null;
        String sql="select*from usertable where prouctName=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,product.getProductName());
        ResultSet rs=st.executeQuery();
        if(rs.next()){
            product=new Product();
            product.setProductId(rs.getInt("productId"));
            product.setProductName(rs.getString("productName"));
            product.setProductDescription(rs.getString("productDescription"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setPrice(rs.getDouble("picture"));
            product.setCategoryId(rs.getInt("categoryId"));
        }
        return null;
    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {

        return null;
    }
}
