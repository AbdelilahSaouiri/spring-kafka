package net.ensah.inventoryservice.repository;

import net.ensah.inventoryservice.entity.ProductIneventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInvRepository  extends JpaRepository<ProductIneventory,Long> {
}
