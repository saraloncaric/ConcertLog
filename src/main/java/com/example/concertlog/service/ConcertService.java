package com.example.concertlog.service;

import com.example.concertlog.entity.Concert;
import com.example.concertlog.repository.ConcertRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConcertService {
    private final ConcertRepository concertRepository;

    public ConcertService(ConcertRepository concertRepository) {
        this.concertRepository = concertRepository;
    }

    public List<Concert> getAll() {
        return concertRepository.findAll();
    }

    public Concert getById(Long id) {
        return concertRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Koncert nije pronađen"));
    }

    public void save(Concert concert) {
        concertRepository.save(concert);
    }

    public void delete(Long id) {
        concertRepository.deleteById(id);
    }

    public List<Concert> searchByIzvodac(String izvodac) {
        return concertRepository.findByIzvodacContainingIgnoreCase(izvodac);
    }

    public List<Concert> searchByGrad(String grad) {
        return concertRepository.findByGradContainingIgnoreCase(grad);
    }

    public List<Concert> searchByZanr(String zanr) {
        return concertRepository.findByZanrContainingIgnoreCase(zanr);
    }

    public List<Concert> filterByStatus(Concert.Status status) {
        return concertRepository.findByStatus(status);
    }
}
