package com.example.concertlog.repository;

import com.example.concertlog.entity.Concert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConcertRepository extends JpaRepository<Concert, Long> {
    List<Concert> findByIzvodacContainingIgnoreCase(String izvodac);
    List<Concert> findByGradContainingIgnoreCase(String grad);
    List<Concert> findByZanrContainingIgnoreCase(String zanr);
    List<Concert> findByStatus(Concert.Status status);
}
