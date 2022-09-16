package com.kudiukin.homework3.service;

import com.kudiukin.homework3.model.Cart;
import com.kudiukin.homework3.repository.CartCollection;
import com.kudiukin.homework3.utils.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService{

    private static Integer cartCount = 0;

    private final CartCollection cartCollection;

    private final ProductService productService;

    private final PersonService personService;

    public CartServiceImpl(CartCollection cartCollection, ProductService productService, PersonService personService) {
        this.cartCollection = cartCollection;
        this.productService = productService;
        this.personService = personService;
    }

    @Override
    public Cart createCartByPersonId(Integer id) throws NotFoundException {
        Cart cart = new Cart();
        cart.setCartId(++cartCount);
        cart.setPerson(personService.getPersonById(id));
        cartCollection.getCarts().put(cart.getCartId(), cart);
        personService.getPersonById(id).getCarts().add(cart);
        return cart;
    }

    @Override
    public Cart addProductByProductIdAndCartId(Integer productId, Integer cartId) throws NotFoundException {
        if (cartCollection.getCarts().containsKey(cartId)) {
            Cart cart = cartCollection.getCarts().get(cartId);
            cart.getProducts().add(productService.getProductById(productId));
            cart.setSum(cart.getSum().add(BigDecimal.valueOf(productService.getProductById(productId).getPrice())));
            return cart;
        } else {
            throw new NotFoundException("Cart with ID #" + cartId + " is not found");
        }
    }

    @Override
    public Cart removeProductByProductIdAndCartId(Integer productId, Integer cartId) throws NotFoundException {
        if (cartCollection.getCarts().containsKey(cartId)) {
            Cart cart = cartCollection.getCarts().get(cartId);
            cart.getProducts().remove(productService.getProductById(productId));
            if (cart.getSum().compareTo(new BigDecimal("0.0")) != 0) {
                cart.setSum(cart.getSum().subtract(BigDecimal.valueOf(productService.getProductById(productId).getPrice())));
            } else {
                cart.setSum(BigDecimal.valueOf(0.0));
            }
            return cart;
        } else {
            throw new NotFoundException("Cart with ID #" + cartId + " is not found");
        }
    }

    @Override
    public void removeAllProductsFromCartById(Integer cartId) throws NotFoundException {
        if (!cartCollection.getCarts().get(cartId).getProducts().isEmpty()) {
            cartCollection.getCarts().get(cartId).getProducts().clear();
            cartCollection.getCarts().get(cartId).setSum(new BigDecimal("0.0"));
        } else {
            throw new NotFoundException("Cart with ID #" + cartId + " is empty");
        }
    }

    @Override
    public List<Cart> getAllByPersonId(Integer id) throws NotFoundException {
        if (personService.getPersonById(id).getId().equals(id)) {
            return cartCollection.getCarts().values().stream()
                    .filter(cart -> cart.getPerson().getId().equals(id)).collect(Collectors.toList());
        } else {
            throw new NotFoundException("Person with ID #" + id + " is not found");
        }
    }

    @Override
    public Cart getCartById(Integer cartId) throws NotFoundException {
        if (cartCollection.getCarts().containsKey(cartId)) {
            return cartCollection.getCarts().get(cartId);
        } else {
            throw new NotFoundException("Cart with ID #" + cartId + " is not found");
        }
    }

    @Override
    public void removeCartById(Integer cartId) throws NotFoundException {
        if (cartCollection.getCarts().containsKey(cartId)) {
            cartCollection.getCarts().remove(cartId);
        } else {
            throw new NotFoundException("Cart with ID #" + cartId + " is not found");
        }
    }
}
