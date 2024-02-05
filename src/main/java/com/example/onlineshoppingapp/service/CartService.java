package com.example.onlineshoppingapp.service;

import com.example.onlineshoppingapp.dto.CartDTO;
import com.example.onlineshoppingapp.enums.CartStatus;
import com.example.onlineshoppingapp.mapper.CartMapper;
import com.example.onlineshoppingapp.model.Cart;
import com.example.onlineshoppingapp.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    //private final CustomerMapper customerMapper;
    private final CartMapper cartMapper;

    public List<CartDTO> findAll() {
        List<Cart> carts = cartRepository.findAll();
        return carts.stream().map(cartMapper::toCartDto).collect(Collectors.toList());
    }

    public List<CartDTO> findAllCartsInStatuses(List<String> statuses) {
        return cartRepository.findAllByStatusIn(statuses).map(cartMapper::toCartDto).collect(Collectors.toList());
    }

    public CartDTO create(CartDTO cartDTO) {
        Cart savedCart = cartRepository.save(cartMapper.toCart(cartDTO));
        return cartMapper.toCartDto(savedCart);
    }

    public CartDTO findById(Long id) {
        return cartRepository.findById(id).map(cartMapper::toCartDto).orElse(null);
    }

    public void delete(Long id) {
        cartRepository.deleteById(id);
    }


    public List<CartDTO> getUserActiveCarts(Long userId) {
        return cartRepository.findAllByStatusInAndCustomerId(List.of(CartStatus.NEW.name(), CartStatus.CONFIRMED.name()), userId)
            .map(cartMapper::toCartDto).collect(Collectors.toList());
    }

    /*private CartDTO toCartDTO(Cart cart) {
        return CartDTO.builder()
            .id(cart.getId())
            .status(cart.getStatus().name())
            .customer(customerMapper.toCustomerDTO(cart.getCustomer()))
            .build();
    }*/
}
