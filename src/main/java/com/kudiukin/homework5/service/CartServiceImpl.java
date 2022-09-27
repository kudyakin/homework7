package com.kudiukin.homework5.service;

import com.kudiukin.homework5.model.Cart;
import com.kudiukin.homework5.model.Product;
import com.kudiukin.homework5.repository.CartRepository;
import com.kudiukin.homework5.utils.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    private final ProductService productService;

    private final PersonService personService;

    public CartServiceImpl(CartRepository cartRepository, ProductService productService, PersonService personService) {
        this.cartRepository = cartRepository;
        this.productService = productService;
        this.personService = personService;
    }

    @Override
    public Cart createCartByPersonId(Long id) throws NotFoundException {
        Cart cart = new Cart(personService.getPersonById(id));
        personService.getPersonById(id).getCarts().add(cart);
        return cartRepository.save(cart);
    }

    @Override
    public Cart addProductByProductIdAndCartId(Long productId, Long cartId) throws NotFoundException {
        Cart cart = cartRepository.findById(cartId).get();
        Product product = productService.getProductById(productId);
        if (cartRepository.findById(cartId).isPresent()) {
            cart.getProducts().add(product);
            cart.setSum(cart.getSum().add(BigDecimal.valueOf(productService.getProductById(productId).getPrice())));
            cartRepository.save(cart);
            return cart;
        } else {
            throw new NotFoundException("Cart with ID #" + cartId + " is not found");
        }
    }

    @Override
    public Cart removeProductByProductIdAndCartId(Long productId, Long cartId) throws NotFoundException {
        Cart cart = cartRepository.findById(cartId).get();
        Product product = productService.getProductById(productId);
        if (cartRepository.findById(cartId).isPresent()) {
            cart.getProducts().remove(product);
            if (cart.getSum().compareTo(new BigDecimal("0.0")) != 0) {
                cart.setSum(cart.getSum().subtract(BigDecimal.valueOf(productService.getProductById(productId).getPrice())));
            } else {
                cart.setSum(BigDecimal.valueOf(0.0));
            }
            cartRepository.save(cart);
            return cart;
        } else {
            throw new NotFoundException("Cart with ID #" + cartId + " is not found");
        }
    }

    @Override
    public Long removeAllProductsFromCartById(Long cartId) throws NotFoundException {
        if (cartRepository.findById(cartId).isPresent()) {
            Cart cart = cartRepository.findById(cartId).get();
            cart.getProducts().clear();
            cart.setSum(new BigDecimal("0.00"));
            cartRepository.save(cart);
            return cartId;
        } else {
            throw new NotFoundException("Cart with ID #" + cartId + " is empty");
        }
    }

    @Override
    public Cart getCartById(Long cartId) throws NotFoundException {
        if (cartRepository.findById(cartId).isPresent()) {
            return cartRepository.findById(cartId).get();
        } else {
            throw new NotFoundException("Cart with ID #" + cartId + " is not found");
        }
    }

    @Override
    public Long removeCartById(Long cartId) throws NotFoundException {
        if (cartRepository.findById(cartId).isPresent()) {
            Cart cart = cartRepository.findById(cartId).get();
            personService.getPersonById(cart.getPerson().getId()).getCarts().remove(cart);
            cartRepository.deleteById(cartId);
            return cartId;
        } else {
            throw new NotFoundException("Cart with ID #" + cartId + " is not found");
        }
    }

    @Override
    public List<Cart> getAllCarts() {
        return (List<Cart>) cartRepository.findAll();
    }

}
