package com.estudos.course.repository;

import com.estudos.course.entities.OrderItem;
import com.estudos.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
