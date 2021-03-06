package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, String>
{

}
