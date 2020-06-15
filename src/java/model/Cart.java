/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author ASUS
 */
public class Cart {

    private TreeMap<product, Integer> list;
    private long cartID;

    public Cart() {
        list = new TreeMap<>();
        cartID = System.currentTimeMillis();
    }

    public Cart(TreeMap<product, Integer> list, long cartID) {
        this.list = list;
        this.cartID = cartID;
    }

    public TreeMap<product, Integer> getList() {
        return list;
    }

    public void setList(TreeMap<product, Integer> list) {
        this.list = list;
    }

    public long getCartID() {
        return cartID;
    }

    public void setCartID(long cartID) {
        this.cartID = cartID;
    }

    public void insertToCart(product sp, int sluong) {
        boolean bln = list.containsKey(sp);
        if (bln) {
            int sl = list.get(sp);
            sluong += sl;
            list.put(sp, sluong);
        } else {
            list.put(sp, sluong);
        }
    }

    public void subToCart(product sp, int so_luong) {
        boolean bln = list.containsKey(sp);
        if (bln) {
            int sl = list.get(sp);
            if (sl > 1) {
                so_luong = sl - so_luong;
            }
            if (so_luong <= 0) {
                list.remove(sp);
            } else {
                list.remove(sp);
                list.put(sp, so_luong);
            }
        }
    }

    public void removeToCart(product sp) {
        boolean bln = list.containsKey(sp);
        if (bln) {
            list.remove(sp);
        }
    }

    public double total() {
        int count = 0;
        for (Map.Entry<product, Integer> list : list.entrySet()) {
            count += list.getKey().getProductPrice()
                    * list.getValue();
        }
        return count;
    }
}
