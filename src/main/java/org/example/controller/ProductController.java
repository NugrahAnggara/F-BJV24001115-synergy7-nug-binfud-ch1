package org.example.controller;

import org.example.Data;
import org.example.entity.OrderDetail;
import org.example.entity.Product;
import org.example.service.ProductService;
import org.example.service.ProductServiceImpl;
import org.example.util.exception.InputException;
import org.example.view.ProductView;
import java.util.List;
import java.util.Optional;

public class ProductController {
    private final ProductView productView = new ProductView();

    public List<Product> getData() {
        ProductService productService = new ProductServiceImpl();
        return productService.getProduct();
    }

    public void menuSelected(String choose) throws InputException {
        try {
            int choosing = Integer.parseInt(choose);
            Optional<Product> product = Data.products.stream()
                    .filter(product1 -> product1.getId() == choosing)
                    .findFirst();

            if (product.isPresent()) {
                productView.detailProduct(product.get());
            } else if (choosing == 99) {
                productView.confirmAndPay();
            } else if (choosing == 0) {
                System.exit(0);
            } else {
                throw new InputException("Pilihan Tidak Tersedia");
            }
        } catch (Exception e) {
            System.out.println("Pilihan Tidak Tersedia");
            productView.mainMenu();
        }
    }

    public void addDataOrder(String quantity,String address,Product product)throws InputException{
       try{
           int qty = Integer.parseInt(quantity);
           if (qty == 0) productView.mainMenu();
           ProductService productService = new ProductServiceImpl();
           boolean isAdd = productService.addOrder(qty,address,product);
           if (isAdd){
               System.out.println("Berhasil Menambahkan Pesanan");
               productView.mainMenu();
           }
       }catch (Exception e){
           throw new InputException("Pastikan Memasukkan Quantity Dengan Benar");
       }
    }

    public List<OrderDetail> getOrder(){
        ProductService productService = new ProductServiceImpl();
        return productService.getListOrder();
    }


    public void menuSelectedPayment(String input)throws InputException{
        try{
            int inputan = Integer.parseInt(input);
            switch (inputan){
                case 1 :
                    productView.displayStruct();
                    break;
                case 2 :
                    productView.mainMenu();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    throw new InputException("Pastikan Memilih Inputan Yang Benar");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public void printStruck(){
        ProductService productService = new ProductServiceImpl();
        if (productService.printStruct()){
            System.out.println("Struck Berhasil Dibuat");
        }else {
            System.out.println("Struck Tidak Berhasil Dibuat");
        }
    }


}
